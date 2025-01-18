package com.KajadhECommerce.Kajadh.business.loginValidation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.KajadhECommerce.Kajadh.SpringContext.Contex;

class AuthenticationTest {

	Authentication authentication = Contex
			.getContext()
			.getBean(Authentication.class);
	
	@Test
	void testIsValidEmail() {
		assertFalse(authentication.isValidEmail("KavinAdithya3@gmail1com"));
		assertTrue(authentication.isValidEmail("KavinAdithya3@gmail.com"));
	}

	@Test
	void testIsValidPassword() {
		assertTrue(authentication.isValidPassword("Java21@3"));
		assertFalse(authentication.isValidPassword("Java3"));
	}
}
