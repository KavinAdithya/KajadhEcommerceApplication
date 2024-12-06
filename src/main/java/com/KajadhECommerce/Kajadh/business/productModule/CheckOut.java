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
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.Order;
import com.KajadhECommerce.Kajadh.Entities.Product;
import com.KajadhECommerce.Kajadh.SpringContext.Contex;

@Service
@Lazy
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CheckOut {
	private  Customer customer = null;
	
	private List<Product> products = null;
	
	private List<Order> orders = null;
	
	@Autowired
	public CheckOut(Customer customer) {
		super();
		this.customer = customer;
	}
	
	private void initCheckOutProduct() {
		products = Contex.getContext()
				.getBean(ProductOperation.class)
				.getProducts();
	}
	
	public double estimateCost(int id, int quantity) {
		if (id < 0) {
			System.out.println("Invalid Product Id..");
			return 0.0;
		}
		
		if (products == null) {
			initCheckOutProduct();
		}
		
		Product product = findProduct(id);
		System.out.println(product);
		
		if (product == null || product.getQuantity() < quantity)
			return 0.0;
		
		return product.getPrice() * quantity;
		
	}
	
	private Product findProduct(int id) {
		int start = 0;
		int end = products.size() - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			int midIndex = products.get(mid).getId();
			
			if (midIndex == id) {
				return products.get(mid);
			}
			else if (midIndex > id) {
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		
		return null;
	}
	
	public boolean placeOrder(int id, int quantity) {
		if (id < 0) {
			System.out.println("Invalid Product Id..");
			return false;
		}
		
		if (products == null) {
			initCheckOutProduct();
		}

		Product product = findProduct(id);
		
		if (product == null || product.getQuantity() < quantity)
			return false;
		
		product.setQuantity(product.getQuantity() - quantity);
		
		if (product.getQuantity() == 0) {
			String query = "DELETE FROM product_specifications WHERE product_spec = :id";
			Map<String, String> parameters = new HashMap<>();
			parameters.put("id", String.valueOf(product.getId()));
			
			int rows = DeleteData.<Order>deleteViaNativeQuery(query, parameters, Order.class);
			
			System.out.println(rows + " rows are deleted from the product specification");
			
			query = "DELETE FROM product WHERE id = :id";
		
			rows = DeleteData.<Product>deleteViaNativeQuery(query, parameters, Product.class);
			
			System.out.println(rows + " rows are deleted from the product table");

			products.remove(product);
		}
		
		return true;
	}
	
	public List<Order> orderList() {
		if (orders == null) {
			fetchOrders();
		}
		
		return orders;
	}
	
	private void fetchOrders() {
		String query =  "SELECT * FROM orderList Where customer_id = :id";
		
		String id = String.valueOf(customer.getId());
		String name = "id";
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put(name, id);
		
		this.orders = ReadData.<Order>getViaNativeQuery(query, parameters, Order.class);
	}
}
