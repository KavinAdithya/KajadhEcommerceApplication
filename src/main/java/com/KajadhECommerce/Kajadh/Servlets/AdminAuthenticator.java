package com.KajadhECommerce.Kajadh.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.context.ApplicationContext;

import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.model.AdminEntityChecker;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Login/Admin")
public class AdminAuthenticator extends HttpServlet{
	
	private static final long serialVersionUID = 8605827134800917681L;
	
	@Override
	public void init() {
		ApplicationContext context = Contex.getContext();
	}

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
				out.print("Successfully Login Admin " + mail);
			else 
				out.print("Failed to log in"); 	
			
			
			out.println("Log In Sucessfull");
		}
		catch (Exception e) {
			try {
				response.getWriter().println(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}