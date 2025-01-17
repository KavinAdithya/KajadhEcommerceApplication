package com.KajadhECommerce.Kajadh.business.loginValidation.abstraction;

public interface AuthenticateLogin {
	public boolean isValidEmail(String eMail);
	public boolean isValidPassword(String password);
}
