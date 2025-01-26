package com.KajadhECommerce.Kajadh.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.KajadhECommerce.Kajadh.model.AdminEntityChecker;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login/Admin")
public class AdminAuthenticator extends HttpServlet{
	
	private static final long serialVersionUID = 8605827134800917681L;
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Admin Authenticator Reached");
		try {
			
			String mail = request.getParameter("email");
			String password = request.getParameter("password");
			
			System.out.println(mail + " " + password);
			
			PrintWriter out = response.getWriter();
			
			if (new AdminEntityChecker(mail, password)
					.isAccountValid())
				out.print("Successfully Login Admin : " + mail);
			else 
				out.print("Failed to log in"); 	

		}
		catch (Exception e) {
			try {
				response.getWriter().println(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("/Kajadh/jsp/login.jsp?type=Admin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}