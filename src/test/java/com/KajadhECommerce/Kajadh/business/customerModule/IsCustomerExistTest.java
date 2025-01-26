package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.business.customerModule.abstraction.CustomerExist;

class IsCustomerExistTest {

	CustomerExist customerExist = Contex.getContext()
									.getBean(CustomerExist.class);
	
	@Test
	void testIsCustomerNotExist() {
		var customer = new Customer();
		assertTrue(customerExist.isCustomerNotExist(customer));
		
		var customer1 = new Customer();
		
		assertFalse(customerExist.isCustomerNotExist(customer1));
	}

}
