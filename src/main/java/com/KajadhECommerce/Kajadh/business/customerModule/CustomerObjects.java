package com.KajadhECommerce.Kajadh.business.customerModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.Order;

@Component
@Lazy
public class CustomerObjects {
	private int id = -1;
	private Customer customer = new Customer();
	private List<Order> orders;
	private String mail;
	
	public CustomerObjects() {
		super();
		customer.setId(-1);
	}
	
	public void setId(int id) {
		this.id = id;
		fetch();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
		fetchCustomerViaMail();
	}
	
	private void fetchCustomerViaMail() {
		String query = "SELECT * FROM customer c "
				+ "INNER JOIN customer_login cl ON c.id = cl.id WHERE c.mail = :mail";
		Map<String, String> parameters = new HashMap<>();
		
		parameters.put("mail", mail);
		
		List<Customer> customers = ReadData.<Customer>getViaNativeQuery(query, parameters, Customer.class);
		
		if (customers == null || customers.isEmpty()) {
			System.out.println("Invalid Mail! ");
			return;
		}
		
		this.customer = customers.get(0);
	}
	
	private void fetch() {
		this.customer = ReadData.<Customer>get(id, Customer.class);
	}
	
	/**
	 * @author KaVin
	 * @param No parameters
	 * @return List<Order> list of order history
	 *  Method responsible to fetch order history from DataBase.
	 */
	public List<Order> orderList() {
		// Ensuring the orders is already initialized.
		if (orders == null) {
			fetchOrders();
		}
		
		// Returning the order
		return orders;
	}
	
	/**
	 * @author KaVin
	 * @param No parameters
	 * @return void
	 * Method will fetch order history from database using Native Query.
	 */
	private void fetchOrders() {
		// Native Query to fetch order history
		String query =  "SELECT * FROM orderList Where customer_id = :id";
		
		// Parameters for query
		Map<String, String> parameters = new HashMap<>();
		parameters.put("id", String.valueOf(customer.getId()));
		
		// Fetching and assigning order history list object.
		this.orders = ReadData.<Order>getViaNativeQuery(query, parameters, Order.class);
	}
}
