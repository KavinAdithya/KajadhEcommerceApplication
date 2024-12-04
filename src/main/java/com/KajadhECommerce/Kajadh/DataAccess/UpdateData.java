package com.KajadhECommerce.Kajadh.DataAccess;

import java.util.Map;

import org.hibernate.SessionFactory;

import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;

public class UpdateData {
	private final static SessionFactory sessionFactory = 
			Contex
				.getContext()
				.getBean(Connectivity.class)
				.getSessionfactory();
	
	private UpdateData() {
		super();
	}
	
	public static <Type>void update(Type object) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.update(object);
		
		session.getTransaction().commit();
	}
	
	public static void update(String query, Map<String, String> parameters) {
		InsertData.persistViaJPQL(query, parameters);
	}
}
