package com.KajadhECommerce.Kajadh.business.customerModule.abstraction;

import com.KajadhECommerce.Kajadh.Entities.Customer;

public interface CustomerExist {
	public abstract boolean isCustomerNotExist(Customer customer);
}
