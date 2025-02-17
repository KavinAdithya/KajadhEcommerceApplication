package com.KajadhECommerce.Kajadh.SpringContext;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class Contex implements ServletContextListener {
	static {
		System.out.println("Contex Class Loaded..");
	}
	
	private  static ApplicationContext applicationContext;
//						= new AnnotationConfigApplicationContext(KajadhConfigurationClass.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		applicationContext = new AnnotationConfigApplicationContext(KajadhConfigurationClass.class);
		beansManagedApplicationContext();
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (applicationContext instanceof AnnotationConfigApplicationContext) {
			((AnnotationConfigApplicationContext) applicationContext).close();
			 AbandonedConnectionCleanupThread.checkedShutdown();
	            System.out.println("MySQL AbandonedConnectionCleanupThread shut down successfully.");
		}
	}
	
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}
	
	public static void beansManagedApplicationContext() {
		System.out.println("Beans Managed By Spring Application Context");
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name + " Bean Managed");
		}
	}
}