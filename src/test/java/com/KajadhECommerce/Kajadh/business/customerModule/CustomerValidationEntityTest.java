package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.CustomerLogin;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerValidationEntityTest {
	private Customer customer = new Customer();
	private CustomerValidationEntity valid ;
	
	@BeforeAll
	public void setData() {
		customer.setName("Kavin");
		customer.setDateOfBirth(new DateOfBirth((byte)15, (byte)12, (short)2005));
		customer.setAddress("Ram,");
		customer.setSecretPin(20);
		customer.setMail("Kavinadithya3@gmail.com");
		
		var customerLogin = new CustomerLogin("Kavinadithya3@gmail.com", "KavinAdithya@3");
		customer.setCustomerLogin(customerLogin);
		
		valid = new CustomerValidationEntity(customer);
	}
	
	@Test
	void testCustomerNew() {
		assertTrue(valid.isValidCustomer());
	}	
}
