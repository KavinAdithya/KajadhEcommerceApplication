package com.KajadhECommerce.Kajadh.Servlets;

import java.io.IOException;

import com.KajadhECommerce.Kajadh.path.PagePath;

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
//		RequestDispatcher dispatchRequest = request.getRequestDispatcher(PagePath.HOME_PAGE_REDIRECT.toString());
//		
//		try {
//			dispatchRequest.forward(request, response);
//		} catch (ServletException | IOException e) {
//			e.printStackTrace();
//		}
		
		try {
//			response.g(PagePath.HOME_PAGE_REDIRECT.toString());
			request.getRequestDispatcher(PagePath.HOME_PAGE_REDIRECT.toString()).forward(request, response);;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
