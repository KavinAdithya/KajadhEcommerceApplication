package com.KajadhECommerce.Kajadh.business.loginValidation;

import java.util.regex.Pattern;

public class Authentication {
	private String name;
	
	private String eMail;
	
	private String password;
	
	public Authentication(String name, String eMail, String password) {
		this.name = name;
		this.eMail = eMail;
		this.password = password;
	}
	
	public boolean isValidData() {
		return isValidEmail() || isValidPassword() || isValidateName();
	}
	
	private boolean isValidEmail() {
		if (eMail == null || eMail.length() < 2)
			return true;
		return ! Pattern.matches("[a-zA-Z0-9.%+-]+@[a-zA-Z]+\\.[a-zA-Z]+", eMail);
	}
	
	private boolean isValidPassword() {
		if (password.length() < 8)
			return true;
		
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
				return false;
		}
		
		return true;
	}
	
	private boolean isValidateName() {		
		if (name.length() < 3)
			return true;
		
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
		
			if ( ! (Character.isAlphabetic(ch) ||   
					Character.isWhitespace(ch))) {
				return true;
			}
		}
		return false;
	}
}
