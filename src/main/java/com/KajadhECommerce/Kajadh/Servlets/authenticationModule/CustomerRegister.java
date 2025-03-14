package com.KajadhECommerce.Kajadh.Servlets.authenticationModule;

import static java.lang.Byte.parseByte;
import static java.lang.Short.parseShort;

import java.io.IOException;
import java.util.Arrays;

import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.CustomerLogin;
import com.KajadhECommerce.Kajadh.Entities.DateOfBirth;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
import com.KajadhECommerce.Kajadh.business.customerModule.CustomerValidationEntity;
import com.KajadhECommerce.Kajadh.path.PagePath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signin/customer")
public class CustomerRegister extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		
		System.out.println("Reached Admin Register Servlet");
		
		var customer = getCustomer(request);
		
		var cusValid = Contex.getContext()
				.getBean(CustomerValidationEntity.class);
		cusValid.setCustomer(customer);
		
		try {
			if (cusValid.isValidCustomer())  redirectToLogin(response);
			else  printMessageFailed(response);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(PagePath.SIGNIN_PAGE_CUSTOMER.toString())
					.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private Customer getCustomer(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int secretPin = Integer.parseInt(request.getParameter("secretPin"));
		String address = request.getParameter("address");
		String[] dateTime = request.getParameter("datetime").split("-");
		
		System.out.println(Arrays.toString(dateTime));
		
		var customer = new Customer();
		customer.setCustomerLogin(new CustomerLogin(email, password));
		customer.setName(name);
		customer.setDateOfBirth(
				new DateOfBirth(
						parseByte(dateTime[2]), 
						parseByte(dateTime[1]), 
						parseShort(dateTime[0])));
		customer.setAddress(address);
		customer.setSecretPin(secretPin);
		
		
		return customer;
	}
	
	private void redirectToLogin(HttpServletResponse response) throws IOException {
		response.sendRedirect(PagePath.LOGIN_PAGE_CUSTOMER_REDIRECT.toString());
	}
	
	private void printMessageFailed(HttpServletResponse response) throws IOException {
		response.getWriter().print("Failed to login due to invalid customer data");
	}
}
