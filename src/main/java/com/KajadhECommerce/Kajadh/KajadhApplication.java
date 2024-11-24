package com.KajadhECommerce.Kajadh;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import javax.servlet.http.*;
@SpringBootApplication
public class KajadhApplication extends HttpServlet{

	private static final long serialVersionUID = 8298808549195723680L;


	@Override
	protected void doGet(HttpServletRequest resquest, HttpServletResponse response) {
		try {
			response.getWriter().write("Hi KavIn !!");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
