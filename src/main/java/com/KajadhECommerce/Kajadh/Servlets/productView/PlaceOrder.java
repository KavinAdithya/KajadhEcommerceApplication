package com.KajadhECommerce.Kajadh.Servlets.productView;

import java.io.IOException;

import com.KajadhECommerce.Kajadh.Entities.Product;
import com.KajadhECommerce.Kajadh.Exception.OperationFailed;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.business.productModule.ProductOperation;
import com.KajadhECommerce.Kajadh.path.PagePath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/buy-now")
public class PlaceOrder extends HttpServlet{
		
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		try {
			if (session == null || session.getAttribute("user_mail") == null) {
				response.sendRedirect(PagePath.LOGIN_PAGE_CUSTOMER_REDIRECT.toString());			
			}
			else {
				response.getWriter().print("Welcome .. " + session.getAttribute("user_mail"));
				int id = Integer.parseInt(request.getParameter("productId"));
			
				Product p = Contex.getContext()
						.getBean(ProductOperation.class)
						.findProductById(id);
				
				request.setAttribute("product", p);
				
				request.getRequestDispatcher(PagePath.BUY_NOW_CONFRIMATION_PAGE.toString())
				.forward(request, response);;
			}
		}
		catch(IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		catch(OperationFailed e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect(PagePath.PRODUCTS_VIEW_REDIRECT.toString());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
