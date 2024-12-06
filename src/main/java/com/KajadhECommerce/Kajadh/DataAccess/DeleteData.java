package com.KajadhECommerce.Kajadh.DataAccess;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

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
	
	public static <Type>int deleteViaNativeQuery(String query, Map<String, String> parameters, Class<Type> type) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		NativeQuery<Type> execQuery = session.createNativeQuery(query, type);
		
		for (Map.Entry<String, String> para : parameters.entrySet()) {
			execQuery.setParameter(para.getKey(), para.getValue());
		}	
		
		int rowsAffected = execQuery.executeUpdate();
		
		session.getTransaction().commit();
		
		session.close();
		
		return rowsAffected;
	}
}
