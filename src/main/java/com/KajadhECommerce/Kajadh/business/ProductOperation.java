package com.KajadhECommerce.Kajadh.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.KajadhECommerce.Kajadh.DataAccess.DeleteData;
import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.Product;

import jakarta.annotation.PostConstruct;


@Service
public class ProductOperation {
	private  List<Product> products;
	
	public ProductOperation() {
		super();
	}
	@PostConstruct
	public void init(){
		String query = "SELECT * FROM product";
		products = ReadData.<Product>getViaHQLOrJPQL(query, new HashMap<>(), Product.class);
	}
	
	private boolean isValidateString(String name) {
		return name == null;
	}
	
	private boolean isValidateNumber(double number) {
		return number < 1.0;
	}
	
	public boolean addProduct(Product product) {
		if (isValidateString(product.getName()) || 
				isValidateString(product.getBrandName()) ||
				isValidateNumber(product.getQuantity()) ||
				isValidateNumber(product.getPrice())) {
			return false;
		}
		
		try {
			InsertData.<Product>persist(product);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public boolean deleteProduct(String name, String brandName) {
		if (name == null || brandName == null)
			return false;
		
		Product product = null;
		
		for (Product prod : products) {
			if (prod.getBrandName().equalsIgnoreCase(brandName) && 
					prod.getName().equalsIgnoreCase(name)) {
				product = prod;
				break;
			}
		}
		
		if (product == null)
			return false;
		
		try {
			DeleteData.<Product>delete(product);
			products.remove(product);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean updateProduct(String name, String brandName, Map<String, String> parameters) {
		if (name == null || brandName == null || parameters == null)
			return false;
		
		for (Product prod : products) {
			if (prod.getBrandName().equalsIgnoreCase(brandName) && 
					prod.getName().equalsIgnoreCase(name)) {
				
				for (Map.Entry<String, String> para : parameters.entrySet()) {
					prod.getSpecification().put(para.getKey(), para.getValue());
				}
				try {
					UpdateData.update(prod);
				}
				catch(Exception e) {
					return false;
				}
				
				return true;
			}
		}
		
		return false;
	}
}
