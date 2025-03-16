package com.KajadhECommerce.Kajadh.Servlets.productView;

import java.io.IOException;
import java.util.List;

import com.KajadhECommerce.Kajadh.Entities.Product;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.business.productModule.ProductOperation;
import com.KajadhECommerce.Kajadh.path.PagePath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class DisplayProducts extends HttpServlet{
	
	private static final long serialVersionUID = -7237611716651499524L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = Contex.getContext()
										.getBean(ProductOperation.class)
										.getProducts();
		request.setAttribute("products", products);
		
		try {
			request.getRequestDispatcher(PagePath.PRODUCTS_VIEW.toString())
					.forward(request, response);
		}
		catch(IOException | ServletException e) {
			e.printStackTrace();
		}
	}
	
}
