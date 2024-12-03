package com.KajadhECommerce.Kajadh.Driver;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.KajadhECommerce.Kajadh.DataAccess.Connectivity;
import com.KajadhECommerce.Kajadh.DataAccess.DeleteData;
import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.*;
import com.KajadhECommerce.Kajadh.SpringContext.KajadhConfigurationClass;

public class Driver {
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(KajadhConfigurationClass.class)){
			@SuppressWarnings("unused")
			var connectivity = context.getBean(Connectivity.class);
						
			persist();
			
			
		}
	}
		
	private static void persist() {
		var adminLogin = new AdminLogin("kavinadithya3@gmail.com", "KDharani3", null);
		adminLogin.setId(3);
		var administrator = new Administrator("kavin", adminLogin);
		adminLogin.setAdministrator(administrator);
		administrator.setId(1);
		//		adminLogin.setId(1);
//		
//		InsertData.<Administrator>persist(administrator);
		
//		UpdateData.<Administrator>update(administrator);
		
		var admin = ReadData.<Administrator>get(1, Administrator.class);
		System.out.println(admin);
		admin.getAdminLogin().setPassword("1234555666");
//		UpdateData.<Administrator>update(administrator);
		DeleteData.<Administrator>delete(administrator);
		
		
	}
	
}
