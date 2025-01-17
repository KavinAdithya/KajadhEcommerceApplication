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
@Table(name = "Admin")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Administrator {
	
	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "admin_name")
	private String name;
	
	@JoinColumn(name = "login_data")
	@OneToOne(cascade = CascadeType.ALL)
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
	
	@Override
	public int hashCode() {
		return Objects.hash(adminLogin, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrator other = (Administrator) obj;
		return Objects.equals(adminLogin, other.adminLogin)  && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", adminLogin=" + adminLogin + "]";
	}
	
}
