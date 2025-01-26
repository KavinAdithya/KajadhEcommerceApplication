package com.KajadhECommerce.Kajadh.business.customerModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.KajadhECommerce.Kajadh.DataAccess.ReadData;
import com.KajadhECommerce.Kajadh.Entities.Customer;
import com.KajadhECommerce.Kajadh.Entities.CustomerLogin;
import com.KajadhECommerce.Kajadh.business.customerModule.abstraction.CustomerExist;

@Repository
public class IsCustomerExist implements CustomerExist{
	
	public boolean isCustomerNotExist(Customer customer) {
		String query = "SELECT * FROM customer_login WHERE customer_mail = :mail";
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("mail", customer.getCustomerLogin().getMail());
		
		List<CustomerLogin> customers = ReadData.<CustomerLogin>getViaNativeQuery(query, parameters, CustomerLogin.class);
			
		return customers.isEmpty();
	}
}
