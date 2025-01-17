package com.KajadhECommerce.Kajadh.adminModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.adminModule.abstraction.AdminExist;

@Repository
public class IsAdminExist implements AdminExist {
	
	@Override
	public boolean isAdministratorExist(Administrator admin) {
		
		String query = "SELECT * FROM admin WHERE admin_name = :name";
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("name", admin.getName());
		
		List<Administrator> admins = ReadData.<Administrator>getViaNativeQuery(query, parameters, Administrator.class);
		
		return admins.size() == 0;
	}
}
