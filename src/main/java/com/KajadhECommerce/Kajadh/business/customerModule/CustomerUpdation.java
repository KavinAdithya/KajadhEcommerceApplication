package com.KajadhECommerce.Kajadh.business.customerModule;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.Customer;

@Service
@Lazy
public class CustomerUpdation {
	private Customer customer;

	public CustomerUpdation() {
		super();
	}
	
	private boolean isValidSecretPin(int pin) {
		return pin == customer.getSecretPin();
	}
	
	public boolean updatePassword(String email, int secretPin, String password) {
		if (! isValidSecretPin(secretPin))
			return false;
		
		customer.getCustomerLogin().setPassword(password);
		try {
			UpdateData.<Customer>update(customer);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean updateAddress(String email, String password, int secretPin, String address) {
		if (! isValidSecretPin(secretPin))
			return false;
		
		customer.setAddress(address);
		try {
			UpdateData.<Customer>update(customer);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}
