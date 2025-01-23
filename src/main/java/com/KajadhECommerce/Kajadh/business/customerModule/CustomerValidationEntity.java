package com.KajadhECommerce.Kajadh.business.customerModule;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;
import com.KajadhECommerce.Kajadh.business.customerModule.abstraction.CustomerExist;
import com.KajadhECommerce.Kajadh.business.loginValidation.abstraction.AuthenticateLogin;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerValidationEntity {
	
	private Customer customer;
	
	@Autowired
	private AuthenticateLogin authenticateLogin;
	
	@Autowired
	private CustomerExist customerExist;
	
	public CustomerValidationEntity() {
		super();
	}
	
	public boolean isValidCustomer() {
		return isNotNullCustomer() &&
			   isValidName()&&
			   isValidSecretPin() &&
			   isValidDate() &&
			   isValidAddress() &&
			   isValidLogin() &&
			   customerExist.isCustomerNotExist(customer) && 
			   persistCustomer();
	}
	
	private boolean isNotNullCustomer() {
		if (customer == null) {
			System.out.println("Customer is Null !");
			return false;
		}
		
		return true;
	}
	
	private boolean isValidName() {		
		String name = customer.getName();
		
		if (name.length() < 3)
			return false;
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
		
			if ( ! (Character.isAlphabetic(ch) ||   
					Character.isWhitespace(ch))) {
				System.out.println("Invalid Customer Name !");
				return false;
			}
		}
		return true;
	}
	
	private boolean isValidSecretPin() {
		return customer.getSecretPin() >= 2;
	}
	
	private boolean isValidAddress() {
		return customer.getAddress() != null;
	}
	
	private boolean isValidDate() {
		DateOfBirth dob = customer.getDateOfBirth();
		
		LocalDate dobDate = LocalDate.of(dob.getYear() + 18, dob.getMonth(), dob.getDate());
		
		LocalDate curDate = LocalDate.now();
		
		System.out.println(dobDate + " " + curDate);
		
		return  ! (dobDate.isAfter(curDate) || dobDate.isEqual(curDate));
	}
	
	private boolean isValidLogin() {
		var customerLogin = customer.getCustomerLogin();
		
		return authenticateLogin.isValidEmail(customerLogin.getMail()) 
				&& authenticateLogin.isValidPassword(customerLogin.getPassword());
	}
	
	private boolean persistCustomer() {
		try {
			InsertData.<Customer>persist(customer);
			
			System.out.println("Customer Persisted");
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
} 