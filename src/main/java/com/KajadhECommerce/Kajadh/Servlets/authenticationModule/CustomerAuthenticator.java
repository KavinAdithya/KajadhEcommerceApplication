package com.KajadhECommerce.Kajadh.Servlets.authenticationModule;

import java.io.IOException;
import java.io.PrintWriter;

import com.KajadhECommerce.Kajadh.model.CustomerEntityChecker;
import com.KajadhECommerce.Kajadh.path.PagePath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login/customer")
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
					.isAccountValid()) {
				out.print("Customer Sign In Success!");
				HttpSession session = request.getSession();
				
				session.setAttribute("user_mail", email);
			}
			else
				out.print("Customer Failed Sign In");
		
		} catch (IOException e) {
			out.print("Exception Throw At Customer Validation Module " + e);
			e.printStackTrace();
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(PagePath.LOGIN_PAGE_CUSTOMER.toString())
					.forward(request, response);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}
}
