package com.KajadhECommerce.Kajadh.DataAccess;

import java.util.Map;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;


public class InsertData {
	
	private final static SessionFactory sessionFactory = 
			KajadhConfigurationClass
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
		
	}
}
