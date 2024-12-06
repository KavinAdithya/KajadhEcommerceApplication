package com.KajadhECommerce.Kajadh.SpringContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.KajadhECommerce.Kajadh.Entities.Customer;

@Configuration
@ComponentScan({"com.KajadhECommerce.Kajadh.DataAccess", "com.KajadhECommerce.Kajadh.business"})
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
	
	@Bean
	public Customer customer() {
		var customer = new Customer();
		customer.setId(1);
		return customer;
	}
} 
