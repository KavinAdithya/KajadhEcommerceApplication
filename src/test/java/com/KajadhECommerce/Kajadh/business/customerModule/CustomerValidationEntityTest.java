package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;


import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerValidationEntityTest {
	private Customer customer = new Customer();
	private CustomerValidationEntity valid = new CustomerValidationEntity(customer);
	
	@BeforeAll
	public void setData() {
		customer.setName("java");
		customer.setDateOfBirth(new DateOfBirth((byte)15, (byte)12, (short)2006));
		customer.setAddress("Ram,");
		customer.setSecretPin(20);
		
	}
	
	
}
