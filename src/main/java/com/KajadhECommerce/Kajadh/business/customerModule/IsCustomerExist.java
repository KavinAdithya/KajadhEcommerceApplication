package com.KajadhECommerce.Kajadh.business.customerModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.business.customerModule.abstraction.CustomerExist;

@Repository
public class IsCustomerExist implements CustomerExist{
	
	public boolean isCustomerNotExist(Customer customer) {
		String query = "SELECT * FROM customer WHERE mail = :mail";
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("mail", customer.getMail());
		
		List<Customer> customers = ReadData.<Customer>getViaNativeQuery(query, parameters, Customer.class);
			
		return customers.isEmpty();
	}
}
