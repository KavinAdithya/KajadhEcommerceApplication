package com.KajadhECommerce.Kajadh.adminModule;

import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.business.loginValidation.Authentication;

public class AdministratorValidationEntity extends Authentication{
	
	public AdministratorValidationEntity(Administrator admin) {
		super(admin.getName(),
				admin.getAdminLogin().getMail(),
				admin.getAdminLogin().getPassword());
	}
	
	public boolean isValidAdmin() {
		return isValidData();
	}
}
