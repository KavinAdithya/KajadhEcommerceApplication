package com.KajadhECommerce.Kajadh.DataAccess;

import java.io.PrintStream;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;


public class InsertData {
	
	private static final PrintStream console = System.out;
	
	private final static SessionFactory sessionFactory = 
			Contex
				.getContext()
				.getBean(Connectivity.class)
				.getSessionfactory();
	
	private InsertData() {
		super();
	}
	
	public static <Type>void persist(Type object) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.persist(object);
		
		session.getTransaction().commit();
		
		console.println(object + " Object Has been persisted ...");
	}
	
	public static void persistViaJPQL(String query, Map<String, String> parameters) {
		var session = sessionFactory.openSession();
		
		Query execQuery = session.createQuery(query);
		
		for (Map.Entry<String, String> para : parameters.entrySet()) {
			execQuery.setParameter(para.getKey(), para.getValue());
		}
		
		session.beginTransaction();
		
		execQuery.executeUpdate();
		
		session.getTransaction().commit();
		
		console.println(" Object Has been Updated using persistViaJPQL ...");
	}
}
