package com.KajadhECommerce.Kajadh.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "customer_dob")
	private DateOfBirth dateOfBirth;
	
	@Column(name = "customer_address")
	private String address;
	
	@JoinColumn(name = "customer_login")
	private CustomerLogin customerLogin;
	
	public Customer() {
		super();
	}
	
	public Customer(String name, DateOfBirth dateOfBirth, String address, CustomerLogin customerLogin) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.customerLogin = customerLogin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(DateOfBirth dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CustomerLogin getCustomerLogin() {
		return customerLogin;
	}

	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}
	

	
}
