package com.KajadhECommerce.Kajadh.Entities;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "customer_login")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CustomerLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "customer_mail") 
	private String mail;
	
	@Column(name = "customer_password")
	private String password;
	

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
	
	@Override
	public String toString() {
		return "CustomerLogin [id=" + id + ", mail=" + mail + ", password=" + password + "]";
	}
}
