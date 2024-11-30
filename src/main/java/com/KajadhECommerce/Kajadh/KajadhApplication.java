package com.KajadhECommerce.Kajadh;


import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SpringBootApplication
@WebServlet("/home")
public class KajadhApplication extends HttpServlet{

	private static final long serialVersionUID = 8298808549195723680L;


	@Override
	protected void doGet(HttpServletRequest resquest, HttpServletResponse response) {
		try {
			System.out.println("Reached Ecommerce Application By Tomcat..");
			response.getWriter().write("<h1>Hi KavIn !!</h1>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
