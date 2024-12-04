package com.KajadhECommerce.Kajadh.SpringContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Contex {
	public static ApplicationContext getContext() {
		return new AnnotationConfigApplicationContext(KajadhConfigurationClass.class);
	}
}