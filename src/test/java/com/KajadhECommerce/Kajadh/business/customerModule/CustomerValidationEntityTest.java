package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.KajadhECommerce.Kajadh.SpringContext.Contex;

class CustomerValidationEntityTest {
	
	CustomerValidationEntity cutomerValidationExist = Contex.getContext()
													.getBean(CustomerValidationEntity.class);
	
	@Test
	void testCustomerValidationEntity() {
		fail("Not yet implemented");
	}

	@Test
	void testIsValidCustomer() {
		fail("Not yet implemented");
	}

}
