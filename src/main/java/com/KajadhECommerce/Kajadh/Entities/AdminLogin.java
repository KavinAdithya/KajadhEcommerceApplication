package com.KajadhECommerce.Kajadh.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "admin_login")
public class AdminLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "admin_mail")
	private String mail;
	
	@Column(name = "admin_password")
	private String password;
	
	@OneToOne(mappedBy = "adminLogin", cascade = CascadeType.REMOVE)
	private Administrator administrator;
	
	public AdminLogin() {
		super();
	}
	
	public AdminLogin(String mail, String password, Administrator administrator) {
		this.mail = mail;
		this.password = password;
		this.administrator = administrator;
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

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
}
