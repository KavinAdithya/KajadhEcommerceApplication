package com.KajadhECommerce.Kajadh.Entities;

import javax.persistence.*;

@Entity
@Table(name = "customer_login")
public class CustomerLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "customer_mail") 
	private String mail;
	
	@Column(name = "customer_password")
	private String password;
	
	@OneToOne(mappedBy = "customerLogin", cascade = CascadeType.REMOVE)
	private Customer customer;
	
	public CustomerLogin() {
		super();
	}
	
	public CustomerLogin(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
