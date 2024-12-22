package com.KajadhECommerce.Kajadh.business.customerModule;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;
import com.KajadhECommerce.Kajadh.business.loginValidation.Authentication;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomerValidationEntity extends Authentication{
	private Customer customer = null;
	
	public CustomerValidationEntity(Customer customer) {
		super(customer.getName(), 
				customer.getCustomerLogin().getMail(), 
				customer.getCustomerLogin().getPassword());
	}
	
	private boolean isValidCustomer() {
		return isValidSecretPin() || 
				isValidAddress()  || 
				isValidateDate()  ||
				isExistCustomer() ||
				isValidData();
	}
	
	private boolean isValidSecretPin() {
		return customer.getSecretPin() < 2;
	}
	
	private boolean isValidAddress() {
		return customer.getAddress() == null;
	}
	
	private boolean isValidateDate() {
		DateOfBirth dob = customer.getDateOfBirth();
		
		LocalDate dobDate = LocalDate.of(dob.getYear() + 18, dob.getMonth(), dob.getDate());
		
		LocalDate curDate = LocalDate.now();
		
		System.out.println(dobDate + " " + curDate);
		
		return  dobDate.isAfter(curDate) || dobDate.isEqual(curDate);
	}
	
	private boolean isExistCustomer() {
		String query = "SELECT * FROM customer WHERE customer_name = :name";
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("name", customer.getName());
		
		List<Customer> customers = ReadData.<Customer>getViaNativeQuery(query, parameters, Customer.class);
		
		if (customers == null || customers.isEmpty())
			return true;
		
		
		return customers.get(0).equals(customer);
	}
} 