package com.KajadhECommerce.Kajadh.business.customerModule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Exception.CustomerNotFoundException;
import com.KajadhECommerce.Kajadh.business.loginValidation.abstraction.AuthenticateLogin;

@Service
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerUpdation {
	
	@Autowired
	private ManageCustomer manageCustomer;
	
	private Customer customer;
	
	@Autowired
	private AuthenticateLogin authenticateLogin;

	public CustomerUpdation() {
		super();
	}
	
	private boolean isValidSecretPin(int pin) {
		return pin == customer.getSecretPin();
	}
	
	public boolean updatePassword(String email,  String password, int secretPin) throws CustomerNotFoundException {
	
		if (! loadCustomer(email) || ! isValidSecretPin(secretPin) || ! authenticateLogin.isValidPassword(password))
			return false;
		
		customer.getCustomerLogin().setPassword(password);
		
		try {
			UpdateData.<Customer>update(customer);
			System.out.println("Customer Password Updated ....");
		}
		catch(Exception e) {
			System.out.println("Failed to update customer password");
			
			throw e;
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
	
	public boolean loadCustomer(String mail) throws CustomerNotFoundException {
		this.customer = manageCustomer.getCustomer(-1, mail);
		
		return customer != null;
	}
}