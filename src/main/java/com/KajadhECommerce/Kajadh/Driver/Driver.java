package com.KajadhECommerce.Kajadh.Driver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KajadhECommerce.Kajadh.DataAccess.Connectivity;
import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;

public class Driver {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(KajadhConfigurationClass.class)){
			var connectivity = context.getBean(Connectivity.class);
		}
	}
}
