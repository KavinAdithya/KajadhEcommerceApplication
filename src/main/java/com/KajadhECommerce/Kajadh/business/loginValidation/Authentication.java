package com.KajadhECommerce.Kajadh.business.loginValidation;


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
		return isValidEmail() || isValidEmail() || isValidateName();
	}
	
	public boolean isValidEmail() {
		if (eMail == null || eMail.length() < 2)
			return true;
		return false;
	}
	
	public boolean isValidPassword() {
		return false;
	}
	
	public boolean isValidateName() {		
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
