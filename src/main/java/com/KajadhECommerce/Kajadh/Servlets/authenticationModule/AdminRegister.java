package com.KajadhECommerce.Kajadh.Servlets.authenticationModule;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import com.KajadhECommerce.Kajadh.Entities.AdminLogin;
import com.KajadhECommerce.Kajadh.Entities.Administrator;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.adminModule.AdministratorValidationEntity;
import com.KajadhECommerce.Kajadh.path.PagePath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signin/admin")
public class AdminRegister extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static final PrintStream console = System.out;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		console.println("Admin Register Servlet Reached");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		var admin = new Administrator(name, new AdminLogin(email, password));
		
		PrintWriter out = null;
		
		try {
			out = response.getWriter();
		
			if (isValidAdmin(admin)) {
				redirectToLogin(response);
				console.println("Admin Data Validate and moved to redirect");
			}
			else {
				out.println("Invalid Admin Data");
				console.println("Failed Login due to invalid admin data");
			}
		}
		catch (IOException e) {
			console.println("Some thing went wrong in admin validation in adminregister servlet");
			e.printStackTrace();
		}
	}
	
	private boolean isValidAdmin(Administrator admin) {
		var validAdmin = Contex.getContext().getBean(AdministratorValidationEntity.class);
		
		validAdmin.setAdmin(admin);	
		
		return validAdmin.isValidAdmin();
	}
	
	private void redirectToLogin(HttpServletResponse response) throws IOException {
		console.println("Redirected to Admin Login");
		response.sendRedirect(PagePath.LOGIN_PAGE_ADMIN_REDIRECT.toString());
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		console.println("Redirected to Admin Login");
		try {
			request.getRequestDispatcher(PagePath.SIGNIN_PAGE_ADMIN.toString())
			.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
