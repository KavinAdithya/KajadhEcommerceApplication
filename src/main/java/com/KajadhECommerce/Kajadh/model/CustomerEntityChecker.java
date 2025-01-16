package com.KajadhECommerce.Kajadh.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.CustomerLogin;

public class CustomerEntityChecker {
	
	private String password;
	private String query = "SELECT * FROM customer_login WHERE customer_mail = :mail";
	private Map<String, String> parameters = new HashMap<>();
	
	public CustomerEntityChecker(String mail, String password) {
		this.password = password;
		
		parameters.put("mail", mail);
	}
	
	public boolean isAccountValid() {
		List<CustomerLogin> res = ReadData.<CustomerLogin>getViaNativeQuery(query, parameters, CustomerLogin.class);
		
		System.out.println(res);
		
		return !res.isEmpty() && res.get(0).getPassword().equals(password);
	}
}
