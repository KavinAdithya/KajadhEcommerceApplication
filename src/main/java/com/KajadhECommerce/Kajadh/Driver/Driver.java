package com.KajadhECommerce.Kajadh.Driver;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KajadhECommerce.Kajadh.DataAccess.Connectivity;
import com.KajadhECommerce.Kajadh.DataAccess.DeleteData;
import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.*;
import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;

public class Driver {
	public static void main(String[] args) {
		orderPersist();
		
	}
		
	private static void persist() {
		var adminLogin = new AdminLogin("kavinadithya3@gmail.com", "KDharani3", null);
		adminLogin.setId(4);
		var administrator = new Administrator("kavin", adminLogin);
		adminLogin.setAdministrator(administrator);
		administrator.setId(5);
		//		adminLogin.setId(1);
//		
//		InsertData.<Administrator>persist(administrator);
		
//		UpdateData.<Administrator>update(administrator);
		
//		var admin = ReadData.<Administrator>get(1, Administrator.class);
//		System.out.println(admin);
//		admin.getAdminLogin().setPassword("1234555666");
//		UpdateData.<Administrator>update(administrator);
		DeleteData.<Administrator>delete(administrator);
		
		
	}
	
	
	private static void customerPersist() {
		var customerLogin = new CustomerLogin("122", "passs");
		
		var dateOfBirth = new DateOfBirth(); 
		dateOfBirth.setDate((byte)7);
		dateOfBirth.setMonth((byte)3);
		dateOfBirth.setYear((short)2005);
		
		var customer = new Customer("java", dateOfBirth, "1234455", customerLogin);
		
		InsertData.<Customer>persist(customer);
		
	}
	
	private static void productPersist() {
		Map<String, String> spec = new HashMap<>();
		spec.put("ram", "123");
		spec.put("rom", "456");
		
		var product = new Product("Techno", "122333", 1, 122.0, spec);
		
		InsertData.<Product>persist(product);
	}
	
	private static void orderPersist() {
		Map<String, String> spec = new HashMap<>();
		spec.put("ram", "123");
		spec.put("rom", "456");
		
		var product = new Product("Techno", "122333", 1, 122.0, spec);
		product.setId(1);
		
		var customerLogin = new CustomerLogin("122", "passs");
		
		var dateOfBirth = new DateOfBirth(); 
		dateOfBirth.setDate((byte)7);
		dateOfBirth.setMonth((byte)3);
		dateOfBirth.setYear((short)2005);
		
		var customer = new Customer("java", dateOfBirth, "1234455", customerLogin);
		customer.setId(1);
		
		var order = new Order(customer, product, 1, 122.890);
		
//		InsertData.<Order>persist(order);
		
		System.out.println(ReadData.<Order>get(1, Order.class));
		System.out.println(ReadData.<Order>get(1, Order.class));
		
	}
}
