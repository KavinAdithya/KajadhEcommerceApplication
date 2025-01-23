package com.KajadhECommerce.Kajadh.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.KajadhECommerce.Kajadh.Entities.AdminLogin;
import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.adminModule.AdministratorValidationEntity;

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
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		
			if (isValidAdmin(admin)) {
				redirectToLogin(response);
			}
			else {
				out.println("Invalid Admin Data");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isValidAdmin(Administrator admin) {
		var validAdmin = Contex.getContext().getBean(AdministratorValidationEntity.class);
		
		validAdmin.setAdmin(admin);	
		
		return validAdmin.isValidAdmin();
	}
	
	private void redirectToLogin(HttpServletResponse response) throws IOException {
		response.sendRedirect("/Kajadh/jsp/login.jsp?type=Admin");
	}
}
