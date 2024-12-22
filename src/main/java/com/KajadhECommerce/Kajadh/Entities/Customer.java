package com.KajadhECommerce.Kajadh.Entities;

import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "customer")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerLogin customerLogin;
	
	@Column(name = "secret_pin")
	private int secretPin;
	
	@Column(name = "mail")
	private String mail;
	
	public Customer() {
		super();
	}
	
	public Customer(String name, DateOfBirth dateOfBirth, String address, String mail, int secretPin, CustomerLogin customerLogin) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.customerLogin = customerLogin;
		this.secretPin = secretPin;
		this.mail = mail;
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

	public int getSecretPin() {
		return secretPin;
	}

	public void setSecretPin(int secretPin) {
		this.secretPin = secretPin;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, customerLogin, dateOfBirth, id, mail, name, secretPin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(customerLogin, other.customerLogin)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(mail, other.mail)
				&& Objects.equals(name, other.name) && secretPin == other.secretPin;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
				+ ", customerLogin=" + customerLogin + ", secretPin=" + secretPin + "]";
	}
}
