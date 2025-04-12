package com.KajadhECommerce.Kajadh.Servlets.productView;

import java.io.IOException;

import com.KajadhECommerce.Kajadh.path.PagePath;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/buy-now")
public class PlaceOrder extends HttpServlet{
		
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		try {
			if (session == null || session.getAttribute("user_mail") == null) {
				response.sendRedirect(PagePath.LOGIN_PAGE_CUSTOMER_REDIRECT.toString());			
			}
			else {
				response.getWriter().print("Welcome .. " + session.getAttribute("user_mail"));
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}	
}
