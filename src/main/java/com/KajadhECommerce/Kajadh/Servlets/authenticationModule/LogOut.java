package com.KajadhECommerce.Kajadh.Servlets.authenticationModule;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/log-out")
public class LogOut extends HttpServlet{

	private static final long serialVersionUID = 1994172800671005669L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		Object mail = null;
		if (session != null) {
			mail = session.getAttribute("user_mail");
			session.invalidate();
		}
		
		try {
			response.getWriter().println("Logged out  " + mail);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
