package com.KajadhECommerce.Kajadh.SpringContext;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.KajadhECommerce.Kajadh.DataAccess.Connectivity;

@Configuration
@ComponentScan({"com.KajadhECommerce.Kajadh.DataAccess"})
public class KajadhConfigurationClass {
	@Bean
	public String url() {
		return "jdbc:mysql://localhost:3306/kajadhApplication";
	}
	
	@Bean
	public String driver() {
		return "com.mysql.cj.jdbc.Driver";
	}
	
	@Bean
	public String username() {
		return "root";
	}
	
	@Bean
	public String password() {
		return "KavinDharani@3";
	}
	
	public static ApplicationContext getContext() {
		return new AnnotationConfigApplicationContext(KajadhConfigurationClass.class);
	}
} 
