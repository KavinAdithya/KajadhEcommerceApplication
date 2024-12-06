package com.KajadhECommerce.Kajadh.SpringContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Contex {
	{
		System.out.println("Contex Class Loaded..");
	}
	private final static ApplicationContext applicationContext = 
			new AnnotationConfigApplicationContext(KajadhConfigurationClass.class);
	public static ApplicationContext getContext() {
		return applicationContext;
	}
}