package com.KajadhECommerce.Kajadh.adminModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.business.loginValidation.Authentication;

public class AdministratorValidationEntity extends Authentication{
	
	private Administrator admin;
	
	public AdministratorValidationEntity(Administrator admin) {
		super(admin.getName(),
				admin.getAdminLogin().getMail(),
				admin.getAdminLogin().getPassword());
		this.admin = admin;
	}
	
	public boolean isValidAdmin() {
		if (isValidData() || isExistAdministrator())
			return true;
		
		try {
			InsertData.<Administrator>persist(admin);
			return false;
		}
		catch(Exception e)  {
			return true;
		}
	}
	
	private boolean isExistAdministrator() {
		String query = "SELECT * FROM admin WHERE admin_name = :name";
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("name", admin.getName());
		
		List<Administrator> admins = ReadData.<Administrator>getViaNativeQuery(query, parameters, Administrator.class);
		
		return admins == null || 
				(!admins.isEmpty() && 
				admins.get(0).equals(admin));
	}
}
