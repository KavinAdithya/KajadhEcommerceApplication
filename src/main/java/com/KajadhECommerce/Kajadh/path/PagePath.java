package com.KajadhECommerce.Kajadh.path;

public enum PagePath {
	SIGNIN_PAGE_CUSTOMER("/WEB-INF/jsp/signInCustomer.jsp"),
	SIGNIN_PAGE_ADMIN("/WEB-INF/jsp/signInAdmin.jsp"),
	LOGIN_PAGE_CUSTOMER("/WEB-INF/jsp/existLogin.jsp?type=Customer"),
	LOGIN_PAGE_ADMIN("/WEB-INF/jsp/login.jsp?type=Admin"),
	SIGNIN_PAGE_CUSTOMER_REDIRECT("/Kajadh/signin/customer"),
	SIGNIN_PAGE_ADMIN_REDIRECT("/Kajadh/signin/admin"),
	LOGIN_PAGE_CUSTOMER_REDIRECT("/Kajadh/login/customer"),
	LOGIN_PAGE_ADMIN_REDIRECT("/Kajadh/login/admin"),
	ERROR_PAGE("/WEB-INF/jsp/exception/error.jsp"),
	UPDATE_PASSWORD("/WEB-INF/updatepassword.jsp"),
	UPDATE_PASSWORD_SERVLET("../customer/update/password"),
	HOME_PAGE("/WEB-INF/jsp/welcome.jsp");
	
	private String path;
	
	private PagePath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return path;
	}
}