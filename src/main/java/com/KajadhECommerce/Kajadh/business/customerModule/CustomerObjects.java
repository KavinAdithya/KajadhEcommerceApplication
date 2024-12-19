package com.KajadhECommerce.Kajadh.business.customerModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.Order;

/**
 * @author KaVin
 * @since 20/12/2024
 * Class is Used to fetch the Customer data from  the data Base.
 * The Object is Managed by Spring Context.
 * Object Creation is Lazy due to the customer mail or id needed to fetch the data.
 * Default the customer contains -1 id number.
 * Customer Object will be Captured by the Spring in the context after initialization.
 * This Class Also responsible to hold the customer order history.
 * Design Pattern of object is SINGLETON.
 */

@Component
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomerObjects {
	
	// Default customer id
	private int id = -1;
	
	// Default Customer Object
	private Customer customer = new Customer();
	
	// Order History references
	private List<Order> orders;
	
	// Mail of the Customer
	private String mail;
	
	// Default Constructor
	public CustomerObjects() {
		super();
		// Setting Customer default id as -1
		customer.setId(-1);
	}
	
	/**
	 * @author KaVin
	 * @param id
	 * On setting new Customer id it will Fetch the customer data from data base.
	 * Initialize customer object with appropriate data.
	 */
	public void setId(int id) {
		this.id = id;
	
		// Fetching Customer.
		fetch();
	}
	
	// Returning customer object.
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * @author KaVin
	 * @param mail
	 * 
	 * Method Will fetch customer data based on mail.
	 * On every time when we invoke this method based on email it will try to fetch the customer object.
	 */
	public void setMail(String mail) {
		// Assigning mail
		this.mail = mail;
		
		// Fetching customer data via email.
		fetchCustomerViaMail();
	}
	
	/**
	 * @author KaVin
	 * Method uses mail to fetch customer data.
	 * Assign the object reference to hold its reference here. 
	 */
	private void fetchCustomerViaMail() {
		// Native QUery to fetch the customer based on mail.
		String query = "SELECT * FROM customer c "
				+ "INNER JOIN customer_login cl ON c.id = cl.id WHERE c.mail = :mail";
	
		// Parameters Object for native query
		Map<String, String> parameters = new HashMap<>();
		
		// Setting parameters
		parameters.put("mail", mail);
		
		// Executing query to fetch data from database.
		List<Customer> customers = ReadData.<Customer>getViaNativeQuery(query, parameters, Customer.class);
		
		// Ensuring the customer fetched mail are valid.
		if (customers == null || customers.isEmpty()) {
			System.out.println("Invalid Mail! ");
			return;
		}
		
		// Assigning the customer
		this.customer = customers.get(0);
		
		// Indicating Console message of object fetched
		System.out.println("Fetched Customer : " + this.customer);
	}
	/**
	 * @author KaVin
	 * Fetching customer Object using customer id.
	 * It was the most optimized approach to fetch  customer data from the database.
	 */
	private void fetch() {
		// Executing Query to Fetch customer object and assigning it.
		this.customer = ReadData.<Customer>get(id, Customer.class);
		
		// Indicating Console message of object fetched
		System.out.println("Fetched Customer : " + this.customer);
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
