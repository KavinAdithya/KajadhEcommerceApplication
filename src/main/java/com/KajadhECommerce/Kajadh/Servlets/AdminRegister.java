package com.KajadhECommerce.Kajadh.Servlets;

import com.KajadhECommerce.Kajadh.Entities.AdminLogin;
import com.KajadhECommerce.Kajadh.Entities.Administrator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignIn/Admin")
public class AdminRegister extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		var admin = new Administrator(name, new AdminLogin(email, password));
		
	}
}