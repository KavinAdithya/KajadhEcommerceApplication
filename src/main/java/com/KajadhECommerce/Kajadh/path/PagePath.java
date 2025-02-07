package com.KajadhECommerce.Kajadh.path;

public enum PagePath {
	SIGNIN_PAGE_CUSTOMER("/jsp/signInCustomer.jsp"),
	SIGNIN_PAGE_ADMIN("/jsp/signInAdmin.jsp"),
	LOGIN_PAGE_CUSTOMER("/jsp/login.jsp?type=Customer"),
	LOGIN_PAGE_ADMIN("/jsp/login.jsp?type=Admin"),
	SIGNIN_PAGE_CUSTOMER_REDIRECT("/Kajadh/jsp/signInCustomer.jsp"),
	SIGNIN_PAGE_ADMIN_REDIRECT("/Kajadh/jsp/signInAdmin.jsp"),
	LOGIN_PAGE_CUSTOMER_REDIRECT("/Kajadh/jsp/login.jsp?type=Customer"),
	LOGIN_PAGE_ADMIN_REDIRECT("/Kajadh/jsp/login.jsp?type=Admin"),
	ERROR_PAGE("/jsp/exception/error.jsp"),
	UPDATE_PASSWORD("/customer/update/password");
	private String path;

	
	private PagePath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return path;
	}
}
