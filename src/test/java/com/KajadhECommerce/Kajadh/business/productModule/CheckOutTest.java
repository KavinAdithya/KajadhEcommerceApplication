package com.KajadhECommerce.Kajadh.business.productModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import org.springframework.context.ApplicationContext;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.business.customerModule.CustomerObjects;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CheckOutTest {
	private ApplicationContext context = Contex.getContext();	
	private CustomerObjects cus = context.getBean(CustomerObjects.class);
	
	
	@BeforeAll
	void load() {
		cus.setId(1);
	}
	
	@Test
	void testAEstimateCost() {
		System.out.println("Test A");
		
		CheckOut checkOut = context.getBean(CheckOut.class);
		
		assertEquals(46644, checkOut.estimateCost(2, 2));
	}

	@Test
	void testBPlaceOrder() {
		System.out.println("Test B");
		CheckOut checkOut = context.getBean(CheckOut.class);
		assertTrue(checkOut.placeOrder(2, 1));
	}
}