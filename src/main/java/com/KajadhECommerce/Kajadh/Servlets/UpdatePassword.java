package com.KajadhECommerce.Kajadh.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.KajadhECommerce.Kajadh.Exception.CustomerNotFoundException;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.business.customerModule.CustomerUpdation;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer/update/password")
public class UpdatePassword extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int secretPin = Integer.parseInt(request.getParameter("secretPin"));
		
		var customerUpdation = Contex.getContext()
				.getBean(CustomerUpdation.class);
		PrintWriter out = null; 
		
		System.out.println(email + " " + password);
		try {
			out = response.getWriter();
			customerUpdation.updatePassword(email, password, secretPin);
			redirectToLogin(response);
		}
		catch( CustomerNotFoundException | IOException e) {
			out.println("Customer Not Found Exception " + e);
		}
		catch(Exception e) {
			out.println(e);
		}
	}
	
	private void redirectToLogin(HttpServletResponse response) throws IOException {
		response.sendRedirect("/Kajadh/jsp/login.jsp?type=Customer");
	}
}
