package com.KajadhECommerce.Kajadh.business.loginValidation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.business.loginValidation.abstraction.AuthenticateLogin;

@Repository
public class Authentication implements AuthenticateLogin{
	
	@Override
	public boolean isValidEmail(String eMail) {
		if (eMail == null || eMail.length() < 2)
			return false;
		return  Pattern.matches("[a-zA-Z0-9.%+-]+@[a-zA-Z]+\\.[a-zA-Z]+", eMail);
	}
	
	@Override
	public boolean isValidPassword(String password) {
		if (password.length() < 8)
			return false;
		
		boolean caps = false;
		boolean small = false;
		boolean special = false;
		boolean digit = false;
		
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			
			if (Character.isUpperCase(ch)) {
				caps = true;
			}
			else if (Character.isLowerCase(ch)) {
				small = true;
			}
			else if (Character.isDigit(ch)) {
				digit = true;
			}
			else {
				special = true;
			}
			
			if (caps && small && digit && special)
				return true;
		}
		
		return false;
	}	
}
