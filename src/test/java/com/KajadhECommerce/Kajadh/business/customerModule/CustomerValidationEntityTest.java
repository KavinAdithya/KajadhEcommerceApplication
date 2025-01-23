package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.CustomerLogin;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;

class CustomerValidationEntityTest {
	
	CustomerValidationEntity cusValid = Contex.getContext()
													.getBean(CustomerValidationEntity.class);
	
	@Test
	void testIsValidCustomer() {
		var customer = new Customer();
		
		customer.setDateOfBirth(new DateOfBirth((byte)7, (byte)3, (short)2005));
		customer.setName("javagaa");
		customer.setSecretPin(3);
		customer.setMail("kavinadithya3@gmail.com");
		customer.setAddress("1234455");
		var customerLogin = new CustomerLogin("kavinadithya3@gmail.com", "pAsss@3445");
		
		customer.setCustomerLogin(customerLogin);
		cusValid.setCustomer(customer);
		assertTrue(cusValid.isValidCustomer());
	}
}