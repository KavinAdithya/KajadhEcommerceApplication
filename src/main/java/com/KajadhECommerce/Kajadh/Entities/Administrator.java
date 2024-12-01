package com.KajadhECommerce.Kajadh.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Administrator {
	
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "admin_name")
	private String name;
	
	@JoinColumn(name = "login_data")
	@OneToOne
	private AdminLogin adminLogin;

	public Administrator() {
		super();
	}
	
	public Administrator(String name, AdminLogin adminLogin) {
		this.name = name;
		this.adminLogin = adminLogin;
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

	public AdminLogin getAdminLogin() {
		return adminLogin;
	}

	public void setAdminLogin(AdminLogin adminLogin) {
		this.adminLogin = adminLogin;
	}
	
}
