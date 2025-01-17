package com.KajadhECommerce.Kajadh.adminModule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.adminModule.abstraction.AdminExist;
import com.KajadhECommerce.Kajadh.business.loginValidation.Authentication;
import com.KajadhECommerce.Kajadh.business.loginValidation.abstraction.AuthenticateLogin;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AdministratorValidationEntity extends Authentication{
	
	private Administrator admin;
	
	@Autowired
	private AuthenticateLogin authenticateLogin;
	
	@Autowired
	private AdminExist adminExist;
	
	@Autowired
	public AdministratorValidationEntity() {
		super();
	}
	
	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
	
	public boolean isValidAdmin() {
		return isNotNullAdmin() && isValidateName() && 
				adminExist.isAdministratorExist(admin) && 
				isValidateLogin() && persistAdmin();
	}	
	
	private boolean isNotNullAdmin() {
		if (admin == null) {
			System.out.println("No Administrator Object present");
			return false;
		}
		
		return true;
	}
	
	private boolean isValidateLogin() {
		var adminLogin = admin.getAdminLogin();
		
		return authenticateLogin.isValidEmail(adminLogin.getMail()) &&
				authenticateLogin.isValidPassword(adminLogin.getPassword());
	}
	
	private boolean isValidateName() {		
		String name = admin.getName();
		
		if (name.length() < 3)
			return false;
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
		
			if ( ! (Character.isAlphabetic(ch) ||   
					Character.isWhitespace(ch))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean persistAdmin() {
		try {
			InsertData.<Administrator>persist(admin);
			return true;
		}
		catch(Exception e)  {
			System.out.println("Failed to persist Admin ! \n" + e.getMessage());
			return false;
		}
	}
}