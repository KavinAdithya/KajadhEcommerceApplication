package com.KajadhECommerce.Kajadh.DataAccess;

import java.util.Map;

import org.hibernate.SessionFactory;

import com.KajadhECommerce.Kajadh.SpringContext.Contex;

public class DeleteData {
	private final static SessionFactory sessionFactory = 
				Contex
				.getContext()
				.getBean(Connectivity.class)
				.getSessionfactory();
	
	private DeleteData() {
		super();
	}
	
	public static <Type>void delete(Type object) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
	}
	
	public static void deleteViaJPQL(String query, Map<String, String> parameters) {
		InsertData.persistViaJPQL(query, parameters);
	}
}
