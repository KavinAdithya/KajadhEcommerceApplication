package com.KajadhECommerce.Kajadh.business.productModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.KajadhECommerce.Kajadh.DataAccess.DeleteData;
import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.Order;
import com.KajadhECommerce.Kajadh.Entities.Product;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;
 
/**
 * 	@author KaVin
 * Its Business Logic !
 * CheckOut Class functionalities are :
 * 		Estimating the cost of the product -> estimateCost() (public)
 * 		placing the order for a product -> placeOrder() (public)
 * 		delete the product if the quantity is 0 -> deleteProduct() (Private)
 *      Spring @Service Annotation used for spring managing bean.
 *      Spring Will initialize it lazily @Lazy
 *      Scope of this bean is Singleton @Scope -> SINGLETON
 */

@Service
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CheckOut {
	
	// Customer Object
	private  Customer customer = null;
	
	// List of products
	private List<Product> products = null;
	
	// Dependency Injection by Spring Framework of customer
	@Autowired
	public CheckOut(Customer customer) {
		super();
		this.customer = customer;
	}
	
	/**
	 *  @author KaVin
	 * 	@param No parameters
	 *  @return void type
	 *  @hidden Private accessor  
	 * 	Initialize product bean from the Spring context.
	 */
	private void initCheckOutProduct() {
		products = Contex.getContext()
				.getBean(ProductOperation.class)
				.getProducts();
	}
	
	/** 
	 * @author KaVin
	 * 	@param id & quantity for estimating the cost of product and quantity for how many products.
	 *  @return double -> Estimated cost
	 *  It will calculate the cost of the product for checking out products.
	 */
	public double estimateCost(int id, int quantity) {
		
		// Ensuring valid id 
		if (id < 0) {
			System.out.println("Invalid Product Id..");
			return 0.0;
		}
		
		// Checking product bean has been initialized.
		if (products == null) {
			// Initializing the product bean from the context.
			initCheckOutProduct();
		}
		
		// Finding the actual product object using id.
		Product product = findProduct(id);
		
		System.out.println("Product found is " + product + " at Estimat Cost method of Checkout class..");
		
		// Ensuring the product found and checking availability of the product quantity
		if (product == null || product.getQuantity() < quantity)
			return 0.0;
		
		return product.getPrice() * quantity;
		
	}
	
	/**
	 * @author KaVin
	 * @param id -> Searching an product object.
	 * @return product object.
	 *  Using Binary Search Algorithm to find the product based on the id of the product.
	 */
	private Product findProduct(int id) {
		int start = 0;
		int end = products.size() - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			int midIndex = products.get(mid).getId();
			
			// returning the index of the product in the list
			if (midIndex == id) {
				return products.get(mid);
			}
			else if (midIndex > id) {
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		
		// No product id match 
		return null;
	}
	
/**
 * @author KaVin
 * @param id & quantity placing order
 * @return boolean true for successful placed order
 * Method will place order and update the order history and update the product data.
 */
	public boolean placeOrder(int id, int quantity) {
		// Ensuring a valid id
		if (id < 0) {
			System.out.println("Invalid Product Id..");
			return false;
		}
		
		// Checking product bean loaded from spring context
		if (products == null) {
			initCheckOutProduct();
		}

		// Fetching product from the list based on product id.
		Product product = findProduct(id);
		
		// Ensuring product found and availability based on requirements.
		if (product == null || product.getQuantity() < quantity)
			return false;
		
		System.out.println("Order Successfully placed!");
		
		persistOrder(product, quantity);
		
		// Changing the quantity of the product after placing the order.
		product.setQuantity(product.getQuantity() - quantity);
		
		// Checking the quantity of the product is > 0.
		if (product.getQuantity() == 0) {
			// Deleting the product from the list and DB.
			deleteProduct(product);
		}
		
		return true;
	}
	
	/**
	 * @author KaVin 
	 * @param product to delete from the DB and list.
	 * @return void
	 * Method will delete the product and appropriate data to the product.
	 * Using native query for deleting it.
	 */
	private void deleteProduct(Product product) {
		
		// Deleting the product specifications using native query.
		String query = "DELETE FROM product_specifications WHERE product_spec = :id";
		
		// Parameters for the query
		Map<String, String> parameters = new HashMap<>();
		parameters.put("id", String.valueOf(product.getId()));
		
		// Executing the Native query to delete the product specifications.
		int rows = DeleteData.<Order>deleteViaNativeQuery(query, parameters, Order.class);
		
		System.out.println(rows + " rows are deleted from the product specification");
		
		// Deleting the product from product table using native query.
		query = "DELETE FROM product WHERE id = :id";
	
		// Executing the native query to delete the product from the table.
		rows = DeleteData.<Product>deleteViaNativeQuery(query, parameters, Product.class);
		
		System.out.println(rows + " rows are deleted from the product table");

		// Removing product from the list
		products.remove(product);
	}
	
	/**
	 * @author KaVin
	 * @param product
	 * @param quantity
	 * @return void
	 * Method will persist the Order history in the database.
	 */
	
	private void persistOrder(Product product, int quantity) {
		
		// Storing the order data in the database
		var order = new Order();
		order.setCustomer(customer);
		order.setProduct(product);
		order.setQuantity(quantity);
		order.setCost(product.getPrice() * quantity);
		
		// Persisting the Data in Database
		InsertData.<Order>persist(order);
		
		System.out.println("History Recorded");
	}
}
