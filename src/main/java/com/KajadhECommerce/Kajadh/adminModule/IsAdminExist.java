package com.KajadhECommerce.Kajadh.adminModule;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.AdminLogin;
import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.adminModule.abstraction.AdminExist;

@Repository
public class IsAdminExist implements AdminExist {
	
	private static final PrintStream console = System.out;
	
	@Override
	public boolean isAdminNotExist(Administrator admin) {
		
		String query = "SELECT * FROM admin_login WHERE admin_mail = :email";
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("email", admin.getAdminLogin().getMail());
		
		List<AdminLogin> admins = ReadData.<AdminLogin>getViaNativeQuery(query, parameters, AdminLogin.class);
		
		console.println("Match found for given mail is : " + admins);
		
		return admins.isEmpty();
	}
}