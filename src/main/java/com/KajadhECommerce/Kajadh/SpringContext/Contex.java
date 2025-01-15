package com.KajadhECommerce.Kajadh.SpringContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class Contex implements ServletContextListener{
	static {
		System.out.println("Contex Class Loaded..");
	}
	
	private  static ApplicationContext applicationContext;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		applicationContext = new AnnotationConfigApplicationContext(KajadhConfigurationClass.class);
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (applicationContext instanceof AnnotationConfigApplicationContext) {
			((AnnotationConfigApplicationContext) applicationContext).close();
		}
	}
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}
}