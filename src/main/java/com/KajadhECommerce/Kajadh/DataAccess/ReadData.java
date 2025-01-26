package com.KajadhECommerce.Kajadh.DataAccess;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.KajadhECommerce.Kajadh.SpringContext.Contex;

public class ReadData {
	private static final PrintStream console = System.out;
	
	private final static SessionFactory sessionFactory = 
			Contex
				.getContext()
				.getBean(Connectivity.class)
				.getSessionfactory();
	
	private ReadData() {
		super();
	}
	
	static {
		console.println("Read Class Loaded into memory...");
	}
	
	public static <Type>Type get(int id, Class<Type> type) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Type object = session.get(type, id);
		
		session.getTransaction().commit();
		session.close();
		
		console.println("For given id : "  + id + " match are" + object);
		return object;
	}
	
	public static <Type>Type lazyLoad(int id, Class<Type> type) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Type object = session.load(type, id);
		
		session.getTransaction().commit();
		
		console.println("For give id : " + id + " match are loaded in lazy is " + object);
		return object;
	}
	
	public static <Type>List<Type> getViaHQLOrJPQL(String query, Map<String, String> parameters, Class<Type> type) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query<Type> execQuery = session.createQuery(query, type);
		
		for (Map.Entry<String, String> para : parameters.entrySet()) {
			execQuery.setParameter(para.getKey(), para.getValue());
		}
		
		
		List<Type> objects = execQuery.list();
		
		session.getTransaction().commit();
		
		console.println("Matches found in getViaHQLOrJPQL is " + objects);
		
		return objects;
	}
	
	public static <Type>List<Type> getViaNativeQuery(String query, Map<String, String> parameters, Class<Type> type) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		NativeQuery<Type> execQuery = session.createNativeQuery(query, type);
		
		for (Map.Entry<String, String> para : parameters.entrySet()) {
			execQuery.setParameter(para.getKey(), para.getValue());
		}	
		
		
		List<Type> objects = execQuery.list();
		
		session.getTransaction().commit();
		
		console.println("Matches found using getViaNativeQuery is : " + objects);
		
		session.close();
		
		return objects;
	}
	
	public static <Type>List<Type> getViaHQLOrJPQL(String query, Map<String, String> parameters, Class<Type> type, int start, int maximum) {
		var session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query<Type> execQuery = session.createQuery(query, type);
		
		for (Map.Entry<String, String> para : parameters.entrySet()) {
			execQuery.setParameter(para.getKey(), para.getValue());
		}
		
		execQuery.setFirstResult(start);
		execQuery.setMaxResults(maximum);
		
		List<Type> objects = execQuery.list();
		
		session.getTransaction().commit();
		
		console.println("Pagination result for start : " + start + " maximum : " + maximum + " is " + objects);
		
		
		return objects;
	}
}