package com.KajadhECommerce.Kajadh.Driver;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KajadhECommerce.Kajadh.DataAccess.Connectivity;
import com.KajadhECommerce.Kajadh.DataAccess.DeleteData;
import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.*;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;
import com.KajadhECommerce.Kajadh.business.productModule.CheckOut;
import com.KajadhECommerce.Kajadh.business.productModule.ProductOperation;

public class Driver {
	public static void main(String[] args) {
//		var context = KajadhConfigurationClass.getContext();
//		var sess = context.getBean(Connectivity.class);
//		System.out.println("No issuess");
//		var context = new AnnotationConfigApplicationContext(KajadhConfigurationClass.class);

//		try {
//			ordersOperation();
//		}
//		catch (Exception e) {
//	
//			e.printStackTrace();
//		}
//		
//		productOperation();
		
		
		var context = Contex.getContext();
		
		System.out.println(context.getBean(Connectivity.class));
	}
	
	private static void ordersOperation() {
		var context = Contex.getContext();
		var checkOut = context.getBean(CheckOut.class);
		var po = context.getBean(ProductOperation.class);
		
		for (Product prod : po.getProducts()) {
			System.out.println(prod);
		}
		
//		System.out.println(checkOut.placeOrder(1, 1));
		
//		System.out.println(checkOut.orderList());
	}
	private static  void productOperation() {
		var con = Contex.getContext();
		var po = con.getBean(ProductOperation.class);
		
		Map<String, String> spec = new HashMap<>();
		spec.put("kavin", "19");
		spec.put("pizels", "8k");
		
		var product = new Product("MegaBk", "1", 2, 23322.0, spec);
		
//		po.addProduct(product);
		
		for (Product prod : po.getProducts()) {
			System.out.println(prod);
		}
		
//		po.deleteProduct("MegaBk", "1");
		po.updateProduct("MegaBk", "1", spec);
		
		for (Product prod : po.getProducts()) {
			System.out.println(prod);
		}
	}
		
	private static void persist() {
		var adminLogin = new AdminLogin("kavinadithya3@gmail.com", "KDharani3");
		adminLogin.setId(4);
		var administrator = new Administrator("kavin", adminLogin);
		administrator.setId(5);
//				adminLogin.setId(1);
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
		
		var customer = new Customer("java", dateOfBirth, "1234455",null, 0,customerLogin);
		
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
			
		var customer = new Customer("java", dateOfBirth, "1234455",null, 0, customerLogin);
		customer.setId(1);
		
		var order = new Order(customer, product, 1, 122.890);
		
//		InsertData.<Order>persist(order);
		var data = ReadData.<Order>get(1, Order.class);
		
		System.out.println(data);
		var data1 = ReadData.<Order>get(1, Order.class);
		System.out.println(data1);
	}
}
