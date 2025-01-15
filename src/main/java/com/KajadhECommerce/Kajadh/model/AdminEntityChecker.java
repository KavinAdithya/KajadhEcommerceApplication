package com.KajadhECommerce.Kajadh.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.AdminLogin;

public class AdminEntityChecker {
	private String mail;
	private String password;
	private String query = "SELECT * FROM admin_login WHERE admin_mail = :mail";
	private Map<String, String> parameters = new HashMap<>();
	
	public AdminEntityChecker(String mail, String password) {
		this.mail = mail;
		this.password = password;
		
		parameters.put("mail", mail);
	}
	
	public boolean isAccountValid() {
		System.out.println("Validation Reached");
		
		List<AdminLogin> admin = ReadData.<AdminLogin>getViaNativeQuery(query, parameters, AdminLogin.class);
		
		System.out.println(admin);
		
		return !admin.isEmpty() && admin.get(0).getPassword().equals(password);
	}
}
