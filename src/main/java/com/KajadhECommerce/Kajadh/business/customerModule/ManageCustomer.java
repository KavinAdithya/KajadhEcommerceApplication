package com.KajadhECommerce.Kajadh.business.customerModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.Order;
import com.KajadhECommerce.Kajadh.Exception.CustomerNotFoundException;

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

@Service
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ManageCustomer {
	
	// Default Constructor
	public ManageCustomer() {
		super();
	}
	
	// Returning customer object.
	public Customer getCustomer(int id , String mail) throws CustomerNotFoundException {
		return mail == null && id == -1 ? null : mail != null ? fetchCustomerViaMail(mail) : fetch(id);
	}
		
	/**
	 * @author KaVin
	 * Method uses mail to fetch customer data.
	 * Assign the object reference to hold its reference here. 
	 * @throws CustomerNotFoundException 
	 */
	private Customer fetchCustomerViaMail(String mail) throws CustomerNotFoundException {
		// Native QUery to fetch the customer based on mail.
		String query = "SELECT c.* FROM customer c "
				+ "INNER JOIN customer_login cl ON c.customer_login = cl.id WHERE cl.customer_mail = :mail";
	
		// Parameters Object for native query
		Map<String, String> parameters = new HashMap<>();
		
		// Setting parameters
		parameters.put("mail", mail);
		
		// Executing query to fetch data from database.
		List<Customer> customers = ReadData.<Customer>getViaNativeQuery(query, parameters, Customer.class);
		
		// Ensuring the customer fetched mail are valid.
		if (customers == null || customers.isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found...");
		}
		
		// Assigning the customer
		Customer customer = customers.get(0);
		
		// Indicating Console message of object fetched
		System.out.println("Fetched Customer : " + customer);
		
		return customer;
	}
	/**
	 * @author KaVin
	 * Fetching customer Object using customer id.
	 * It was the most optimized approach to fetch  customer data from the database.
	 */
	private Customer fetch(int id) {
		// Executing Query to Fetch customer object and assigning it.
		Customer customer = ReadData.<Customer>get(id, Customer.class);
		
		// Indicating Console message of object fetched
		System.out.println("Fetched Customer : " + customer);
		
		return customer;
	}
	
	/**
	 * @author KaVin
	 * @param No parameters
	 * @return List<Order> list of order history
	 *  Method responsible to fetch order history from DataBase.
	 */
	public List<Order> orderList(int id) {
		// Returning the order
		return fetchOrders(id);
	}
	
	/**
	 * @author KaVin
	 * @param No parameters
	 * @return void
	 * Method will fetch order history from database using Native Query.
	 */
	private List<Order> fetchOrders(int id) {
		// Native Query to fetch order history
		String query =  "SELECT * FROM orderList Where customer_id = :id";
		
		// Parameters for query
		Map<String, String> parameters = new HashMap<>();
		parameters.put("id", String.valueOf(id));
		
		// Fetching and assigning order history list object.
		List<Order> orders = ReadData.<Order>getViaNativeQuery(query, parameters, Order.class);
		
		return orders;
	}
}