package com.KajadhECommerce.Kajadh.business.customerModule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.context.ApplicationContext;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.CustomerLogin;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;
import com.KajadhECommerce.Kajadh.Entities.Order;
import com.KajadhECommerce.Kajadh.Entities.Product;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerObjectsTest {
	private ApplicationContext context = Contex.getContext();
	private Customer customer = new Customer();
	private List<Order> orders = new ArrayList<>();
	private Product product = new Product();
	
	@BeforeAll
	void testSetId() {
		var customerObjects = context.getBean(ManageCustomer.class);
		customer.setId(1);
		customer.setDateOfBirth(new DateOfBirth((byte)7, (byte)3, (short)2005));
		customer.setName("java");
		customer.setSecretPin(0);
		customer.setAddress("1234455");
		var customerLogin = new CustomerLogin("kavinadithya3@gmail.com", "passs");
		customerLogin.setId(1);
		customer.setCustomerLogin(customerLogin);

//		customerObjects.setId(2);
//		customerObjects.setMail("kavinadithya3@gmail.com");
	}

	@BeforeAll
	void setProduct() {
		product.setId(2);
		product.setBrandName("MegaBook");
		product.setName("123");
		product.setPrice(23322);
		product.setQuantity(2);
		
		Map<String, String> productSpec = new HashMap<>();
		productSpec.put( "Display","Full HD");
		productSpec.put( "pizels","4k");
		
		product.setSpecification(productSpec);
	}
	
	@BeforeAll
	void setOrders() {
		var order = new Order();
		order.setId(1);
		order.setCost(230.00);
		order.setQuantity(3);
		order.setCustomer(customer);
		order.setProduct(product);
		
		orders.add(order);
	}
	
//	@Test
	void testGetCustomer() {
		
		System.out.println(context.getBean(Customer.class));
		
		assertEquals(customer, context.getBean(Customer.class));
		
	}

	@Test
	void testSetMail() {
		
	}

	@Test
	void testOrderList() {
		assertEquals(orders, context.getBean(List.class));
	}

}
