package com.KajadhECommerce.Kajadh.business.loginValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AuthenticationTest {

	@Test
	void test() {
		var authent = new Authentication("kavin", "Kavinadithya3@gmail.com", "KavinJava@3");
		
		assertFalse(authent.isValidData());
	}

}
