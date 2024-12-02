package com.KajadhECommerce.Kajadh.Driver;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KajadhECommerce.Kajadh.DataAccess.Connectivity;
import com.KajadhECommerce.Kajadh.Entities.*;
import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;

public class Driver {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(KajadhConfigurationClass.class)){
			@SuppressWarnings("unused")
			var connectivity = context.getBean(Connectivity.class);
			
			var sessionFactory = connectivity.getSessionfactory();
			
			var session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			
			
			persist(session);
			
			session.getTransaction().commit();
		}
	}
		
	private static void persist(Session session) {
		var adminLogin = new AdminLogin("kavinadithya3@gmail.com", "KavinDharani@3", null);
		adminLogin.setId(1);
//		
//		session.persist(adminLogin);
		
		var administrator = new Administrator("kavin", adminLogin);
		session.persist(administrator);
	}
	
}
