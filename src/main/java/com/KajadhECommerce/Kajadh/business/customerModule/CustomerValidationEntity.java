package com.KajadhECommerce.Kajadh.business.customerModule;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;
import com.KajadhECommerce.Kajadh.business.loginValidation.Authentication;

public class CustomerValidationEntity extends Authentication{
	private Customer customer = null;
	
	public CustomerValidationEntity(Customer customer) {
		super(customer.getName(), 
				customer.getCustomerLogin().getMail(), 
				customer.getCustomerLogin().getPassword());
		this.customer = customer;
	}
	
	public boolean isValidCustomer() {
		
		System.out.println(isValidSecretPin());
		System.out.println(isValidAddress() );
		System.out.println(isValidateDate());
		System.out.println(isExistCustomer());
		System.out.println(isValidData());
		
		if (isValidSecretPin() || 
				isValidAddress()  || 
				isValidateDate()  ||
				isExistCustomer() ||
				isValidData())
			return true;
		
		try {
			InsertData.<Customer>persist(customer);
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return true;
		}
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
		
		
		
		return customers == null || 
				(!customers.isEmpty() && 
				customers.get(0).equals(customer));
	}
} 