package com.KajadhECommerce.Kajadh.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.KajadhECommerce.Kajadh.model.CustomerEntityChecker;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Login/Customer")
public class CustomerAuthenticator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email + " " + password);
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
			
			if (new CustomerEntityChecker(email, password)
					.isAccountValid())
				out.print("Customer Sign In Success!");
			else
				out.print("Customer Failed Sign In");
		
		} catch (IOException e) {
			out.print("Exception Throw At Customer Validation Module " + e);
			e.printStackTrace();
		}
	}
}
