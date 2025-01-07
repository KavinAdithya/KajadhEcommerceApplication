package com.KajadhECommerce.Kajadh.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login/Customer")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Login() {
        super();
    }
    
	@Override 
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("Customer");
	}

}
