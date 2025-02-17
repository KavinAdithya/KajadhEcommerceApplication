package com.KajadhECommerce.Kajadh.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.KajadhECommerce.Kajadh.Exception.OperationFailed;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.business.customerModule.CustomerUpdation;
import com.KajadhECommerce.Kajadh.path.PagePath;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer/update/password")
public class UpdatePassword extends HttpServlet{

	private static final long serialVersionUID = 2396762421671639649L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int secretPin = Integer.parseInt(request.getParameter("secretPin"));
		
		var customerUpdation = Contex.getContext()
				.getBean(CustomerUpdation.class);
		PrintWriter out = null; 
		
		System.out.println(email + " " + password);
		try {
			out = response.getWriter();
			if (customerUpdation.updatePassword(email, password, secretPin))
				redirectToLogin(response);
			else
				throw new OperationFailed("Invalid Data Provided by User...");
		}
		catch(Exception e) {
			request.setAttribute("exception", e);
			RequestDispatcher r = request.getRequestDispatcher(PagePath.ERROR_PAGE.toString());
			try {
				r.forward(request, response);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void redirectToLogin(HttpServletResponse response) throws IOException {
		response.sendRedirect(PagePath.LOGIN_PAGE_CUSTOMER.toString());
	}
}

//http://localhost:8080/Kajadh/customer/update/password
