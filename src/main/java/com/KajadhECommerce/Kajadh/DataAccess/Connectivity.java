package com.KajadhECommerce.Kajadh.DataAccess;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.Entities.*;

import jakarta.annotation.PostConstruct;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class Connectivity {
	private final String driver;
	private final String url;
	private final String username;
	private final String password;
	private final Configuration configuration = new Configuration();
	private  SessionFactory sessionfactory;
	
	@Autowired
	public Connectivity(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	@PostConstruct
	public void initialize() {
		configuration.setProperty("hibernate.connection.Driver_class", driver);
		configuration.setProperty("hibernate.connection.url", url);
		configuration.setProperty("hibernate.connection.username", username);
		configuration.setProperty("hiberante.connection.password", password);
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		configuration.setProperty("hibernate.cache.use_second_level_cache", "true");
		configuration.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
		configuration.setProperty("hibernate.cache.use_query_level_cache", "true");
		configureEntity();
	}
	
	private void configureEntity() {
		configuration.addAnnotatedClass(Administrator.class);
		configuration.addAnnotatedClass(AdminLogin.class);
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(CustomerLogin.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(Product.class);
//		configuration.configure();
		buildSessionFactory();
	}
	
	private void buildSessionFactory() {
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
		this.sessionfactory = configuration.buildSessionFactory(serviceRegistry);
	}
	public Configuration getConfiguration() {
		return configuration;
	}
}
