package com.KajadhECommerce.Kajadh.business.customerModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.Customer;

@Service
@Lazy
public class CustomerUpdation {
	private Customer customer;
	
	@Autowired
	public CustomerUpdation(Customer customer) {
		this.customer = customer;
	}
	
	public boolean isValidSecretPin(int pin) {
		return pin == customer.getSecretPin();
	}
	
	public boolean updatePassword(String password) {
		customer.getCustomerLogin().setPassword(password);
		try {
			UpdateData.<Customer>update(customer);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean updateAddress(String address) {
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
