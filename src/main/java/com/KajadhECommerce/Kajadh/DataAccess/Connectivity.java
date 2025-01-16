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

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public final class Connectivity {
	
	private final String driver;
	private final String url;
	private final String username;
	private final String password;
	
	private final Configuration configuration = new Configuration();
	private  SessionFactory sessionfactory;
	
	static {
		System.out.println("Connectivity class loaded...");
	}
	
	@Autowired
	public Connectivity(String driver, String url, String username, String password) {
		System.out.println("Bean Loaded...");
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		initialize();
	}

	public void initialize() {
		configuration.setProperty("hibernate.connection.driver_class", driver);
		configuration.setProperty("hibernate.connection.url", url);
		configuration.setProperty("hibernate.connection.username", username);
		configuration.setProperty("hibernate.connection.password", password);
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		configuration.setProperty("hibernate.cache.use_second_level_cache", "true");
		configuration.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
		configuration.setProperty("hibernate.cache.use_query_cache", "true");
		configuration.setProperty("hibernate.format_sql", "true");
		configuration.setProperty("hibernate.use_sql_comments", "true");
		configuration.setProperty("hibernate.generate_statistics", "true");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		configureEntity();
	}
	
	private void configureEntity() {
		configuration.addAnnotatedClass(Administrator.class);
		configuration.addAnnotatedClass(AdminLogin.class);
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(CustomerLogin.class);
		configuration.addAnnotatedClass(Order.class);
		configuration.addAnnotatedClass(Product.class);
		System.out.println("Configuration loaded...");
		buildSessionFactory();
	}
	
	public void buildSessionFactory() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
		this.sessionfactory =  configuration.buildSessionFactory(serviceRegistry);
		System.out.println("Session Factory builded...");
	}
	
	public Configuration getConfiguration() {
		return configuration;
	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}	
}
