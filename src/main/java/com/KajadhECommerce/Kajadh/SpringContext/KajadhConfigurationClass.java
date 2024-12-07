package com.KajadhECommerce.Kajadh.SpringContext;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.Order;
import com.KajadhECommerce.Kajadh.business.customerModule.CustomerObjects;

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
	@Lazy
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Customer customer(CustomerObjects customerObjects) {
		return customerObjects.getCustomer();
	}
	
	@Bean
	@Lazy
	public List<Order> order(CustomerObjects customerObjects) {
		return customerObjects.orderList();
	}
} 
