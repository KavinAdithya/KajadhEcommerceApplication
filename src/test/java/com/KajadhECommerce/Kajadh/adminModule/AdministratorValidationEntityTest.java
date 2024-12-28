package com.KajadhECommerce.Kajadh.adminModule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.KajadhECommerce.Kajadh.Entities.AdminLogin;
import com.KajadhECommerce.Kajadh.Entities.Administrator;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdministratorValidationEntityTest extends Object{
	private Administrator admin = new Administrator();
	private AdministratorValidationEntity valid ;
	
	public AdministratorValidationEntityTest() {
		super();
		
	}
	@BeforeAll
	void loadData() {
		admin.setName("Kavin");
		var adminLogin = new AdminLogin("KavinAdithya543673733@gmail.com", "KavinAdithya@3");
		admin.setAdminLogin(adminLogin);
		valid = new AdministratorValidationEntity(admin);
	}
	
	@Test
	void test() {
		assertFalse(valid.isValidAdmin());
	}
}
