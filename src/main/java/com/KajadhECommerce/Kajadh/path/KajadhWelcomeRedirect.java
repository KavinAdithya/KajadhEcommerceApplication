package com.KajadhECommerce.Kajadh.path;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class KajadhWelcomeRedirect extends HttpServlet{

	private static final long serialVersionUID = -3964967169121804234L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(PagePath.HOME_PAGE.toString()).forward(request, response);;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
