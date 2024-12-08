package com.KajadhECommerce.Kajadh.business.productModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.KajadhECommerce.Kajadh.DataAccess.DeleteData;
import com.KajadhECommerce.Kajadh.DataAccess.InsertData;
import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.DataAccess.UpdateData;
import com.KajadhECommerce.Kajadh.Entities.Product;

/**
 * @author KaVin
 * @since 08/12/2024
 * 
 * Class Responsible for CRUD operation on products:
 * addProduct() -> Method Will add product to application and the DataBase.
 * {@link -> isValidString() and isValidNumber()} -> For validating string and the number.
 * listProduct() -> Method will return the list of products in our application.
 * deleteProduct() -> Method will delete the product from the application and the Database.
 * updateProduct() -> Method will Update the product from the application and the Database.
 */
@Service
public class ProductOperation {
	
	// List of products references
	private  List<Product> products = null;
	
	// Default Constructor
	public ProductOperation() {
		super();
		System.out.println("Product Bean Created");
	}

	/**
	 * @author KaVin
	 * @param No parameters
	 * @return void
	 * Method will fetch all the product data from the database and it will store the reference here.
	 * Using Native Query to retrieve data from database.
	 * After Fetching it will sort the products based on id in natural order.
	 */
	private void init(){
		System.out.println("Post Constructing init");
		
		// Native Query to fetch data
		String query = "SELECT * FROM product";
		
		// Executing Native Query
		products = ReadData.<Product>getViaNativeQuery(query, new HashMap<>(), Product.class);
		
		// On fetching the product sort in ascending order for efficient search for products.
		products.sort((a, b) -> a.getId() - b.getId());
	}
	
	/**
	 * @author KaVin
	 * @param String name of the product or brand Name.
	 * @return boolean false if given string is valid.
	 *  Method will check the String reference is not null.
	 */
	private boolean isValidateString(String name) {
		return name == null;
	}
	
	/**
	 * @author KaVin
	 * @param double Number
	 * @return boolean
	 * Checking the given number is non negative.
	 * If satisfy the condition it will return false.
	 */
	private boolean isValidateNumber(double number) {
		return number < 1.0;
	}
	
	/**
	 * @author KaVin
	 * @param product
	 * @return boolean
	 * Method responsible to check the given product details are correct.
	 * After Ensuring product values it will persist the product object in the database and in application.
	 */
	public boolean addProduct(Product product) {
		// Ensuring Products Loaded from the DataBase.
		if (products == null)
			init();
		
		// Checking the name , brandName, quantity and price are valid. 
		if (isValidateString(product.getName()) || 
				isValidateString(product.getBrandName()) ||
				isValidateNumber(product.getQuantity()) ||
				isValidateNumber(product.getPrice())) {
			return false;
		}
		
		try {
			// Persisting product in the DataBase.
			InsertData.<Product>persist(product);
			// Adding product in the list.
			products.add(product);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * @author KaVin
	 * @param No parameters
	 * @return list -> list of products.
	 * Method will return the list of products.
	 */
	public List<Product> getProducts() {
		// Ensuring the products are loaded from the database.
		if (products == null)
			init();
		
		return products;
	}
	
	/**
	 * @author KaVin
	 * @param brandName -> brand name of the product.
	 * @param name -> name of the product.
	 * @return boolean -> after successful deletion it will return true.
	 * Method will delete the product from the Database and list .
	 */
	public boolean deleteProduct(String brandName, String name) {
		// Ensuring that products are loaded from the database.
		if (products == null)
			init();
		
		// Ensuring the brand name and the name is not null.
		if (name == null || brandName == null)
			return false;
		
		// Initializing product reference to hold the actual product object to delete.
		Product product = null;
		
		// Iterating the products to match the name and brand name of the product.
		for (Product prod : products) {
			
			// Checking is it matching name and brand name.
			if (prod.getBrandName().equalsIgnoreCase(brandName) && 
					prod.getName().equalsIgnoreCase(name)) {
				
				// Capturing its reference and breaking the loop.
				product = prod;
				break;
			}
		}
	
		// Ensuring product object is found in the list.
		if (product == null)
			return false;
		
		try {
			// Deleting product from the database.
			DeleteData.<Product>delete(product);
			// Deleting product from the list.
			products.remove(product);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	/**
	 * @author KaVin
	 * @param brandName
	 * @param name
	 * @param parameters
	 * @return boolean after successful updation of the product.
	 * Method will updated the existing product data.
	 * It will make changes on list and database.
	 */
	public boolean updateProduct(String brandName, String name, Map<String, String> parameters) {
		// Ensuring product objects are loaded 
		if (products == null)
			init();
		
		// Ensuring name , brandName and parameters are not null and empty.
		if (name == null || brandName == null || parameters == null || parameters.isEmpty())
			return false;
		
		// Iterating products to find the product object which match brand name and name.
		for (Product prod : products) {
			
			// Checking is the product object matches.
			if (prod.getBrandName().equalsIgnoreCase(brandName) && 
					prod.getName().equalsIgnoreCase(name)) {
				
				// Updating with new values.
				for (Map.Entry<String, String> para : parameters.entrySet()) {
					prod.getSpecification().put(para.getKey(), para.getValue());
				}
				try {
					// Updating the product in the database.
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