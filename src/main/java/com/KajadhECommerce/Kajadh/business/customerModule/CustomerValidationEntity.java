package com.KajadhECommerce.Kajadh.business.customerModule;

import java.time.LocalDate;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;

public class CustomerValidationEntity {
	private Customer customer = null;
	
	public CustomerValidationEntity() {
		super();
	}
	
	public boolean isValidCustomer(Customer customer) {
		this.customer = customer;
//		if (isValidateName());
		
		return false;
	}
	
	private boolean isValidateName() {
		String name = customer.getName();
		
		if (name.length() < 3)
			return true;
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
		
			if ( ! (Character.isAlphabetic(ch) ||   
					Character.isDigit(ch) 	   || 
					Character.isWhitespace(ch))) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean validateDate() {
		DateOfBirth dob = customer.getDateOfBirth();
		
		LocalDate dobDate = LocalDate.of(dob.getYear() + 18, dob.getMonth(), dob.getDate());
		
		LocalDate curDate = LocalDate.now();
		
		System.out.println(dobDate + " " + curDate);
		
		return  dobDate.isAfter(curDate) || dobDate.isEqual(curDate);
	}
}
