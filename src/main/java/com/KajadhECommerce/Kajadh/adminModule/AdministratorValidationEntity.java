package com.KajadhECommerce.Kajadh.adminModule;


import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.adminModule.abstraction.AdminExist;
import com.KajadhECommerce.Kajadh.business.loginValidation.abstraction.AuthenticateLogin;

/**
 * @author KaVin
 * Bean Resp
 */
@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AdministratorValidationEntity{
	private Administrator admin;
	
	private static final PrintStream console = System.out;
	
	@Autowired
	private AuthenticateLogin authenticateLogin;
	
	@Autowired
	private AdminExist adminExist;
	
	@Autowired
	public AdministratorValidationEntity() {
		super();
	}
	
	public void setAdmin(Administrator admin) {
		this.admin = admin;
		console.println("Admin Has been seted in AdministratorValidationEntity Class for valid data");
	}
	
	
	public boolean isValidAdmin() {
		return isNotNullAdmin() && isValidateName() && 
				adminExist.isAdminNotExist(admin) && 
				isValidateLogin() && persistAdmin();
	}	
	
	private boolean isNotNullAdmin() {
		if (admin == null) {
			console.println("No Administrator Object present");
			return false;
		}
		
		return true;
	}
	
	private boolean isValidateLogin() {
		var adminLogin = admin.getAdminLogin();
		
		console.println(authenticateLogin.isValidEmail(adminLogin.getMail()) + " " + admin.getAdminLogin().getMail());
		
		return authenticateLogin.isValidEmail(adminLogin.getMail()) &&
				authenticateLogin.isValidPassword(adminLogin.getPassword());
	}
	
	private boolean isValidateName() {		
		String name = admin.getName();
		
		if (name.length() < 3) {
			console.println("Admin name length is less than 3 and denied");
			return false;
		}
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
		
			if ( ! (Character.isAlphabetic(ch) ||   
					Character.isWhitespace(ch))) {
				console.println("Unauthorized character in admin name");
				return false;
			}
		}
		
		console.println("Valid Admin name..");
		return true;
	}
	
	private boolean persistAdmin() {
		try {
			InsertData.<Administrator>persist(admin);
			console.println("Admin Successfully persisted in Data base");
			return true;
		}
		catch(Exception e)  {
			console.println("Failed to persist Admin ! \n" + e.getMessage());
			return false;
		}
	}
}