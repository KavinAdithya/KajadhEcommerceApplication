package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;

class CustomerValidationEntityTest {

	@Test
	void testDate() {
		var customer = new Customer();
		customer.setDateOfBirth(new DateOfBirth((byte)15, (byte)12, (short)2006));
		
		var customerValid = new CustomerValidationEntity();
		customerValid.isValidCustomer(customer);
		
		assertTrue(customerValid.validateDate());
	}

}
