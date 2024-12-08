package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerUpdationTest {
	private ApplicationContext context = Contex.getContext();
	private CustomerUpdation customerUpdation;
	
	@BeforeAll
	public void updateCustomer() {
		context.getBean(CustomerObjects.class).setId(1);
		customerUpdation = context.getBean(CustomerUpdation.class);
	}
	
	
	@Test
	void isValidSecretPinTest() {
		assertTrue(customerUpdation.isValidSecretPin(0));
	}
	
	@Test
	void updatePasswordTest() {
		assertTrue(customerUpdation.updatePassword("java@3"));
		System.out.println(context.getBean(Customer.class));
	}
	
	@Test
	void updateAddressTest() {
		assertTrue(customerUpdation.updateAddress("Rajathi Street Periyampatti"));
		System.out.print(context.getBean(Customer.class));
	}
}
