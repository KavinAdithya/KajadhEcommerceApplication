package com.KajadhECommerce.Kajadh.path;

public enum PagePath {
	SIGNIN_PAGE_CUSTOMER("/jsp/signInCustomer.jsp"),
	SIGNIN_PAGE_ADMIN("/jsp/signInAdmin.jsp"),
	LOGIN_PAGE_CUSTOMER("/jsp/existLogin.jsp?type=Customer"),
	LOGIN_PAGE_ADMIN("/WEB-INF/jsp/login.jsp?type=Admin"),
	SIGNIN_PAGE_CUSTOMER_REDIRECT("/Kajadh/jsp/signinCustomer.jsp"),
	SIGNIN_PAGE_ADMIN_REDIRECT("/Kajadh/jsp/signinAdmin.jsp"),
	LOGIN_PAGE_CUSTOMER_REDIRECT("/Kajadh/jsp/existLogin.jsp?type=Customer"),
	LOGIN_PAGE_ADMIN_REDIRECT("/Kajadh/jsp/existLogin.jsp?type=Admin"),
	ERROR_PAGE("/jsp/exception/error.jsp"),
	UPDATE_PASSWORD("updatepassword.jsp"),
	UPDATE_PASSWORD_SERVLET("../customer/update/password"),
	HOME_PAGE_REDIRECT("/WEB-INF/jsp/welcome.jsp"),
	HOME_PAGE("jsp/welcome.jsp");
	
	private String path;
	
	private PagePath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return path;
	}
}