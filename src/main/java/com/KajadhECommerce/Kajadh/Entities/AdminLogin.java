package com.KajadhECommerce.Kajadh.Entities;

import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "admin_login")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AdminLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "admin_mail")
	private String mail;
	
	@Column(name = "admin_password")
	private String password;
	
	
	public AdminLogin() {
		super();
	}
	
	public AdminLogin(String mail, String password) {
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
	public int hashCode() {
		return Objects.hash(id, mail, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminLogin other = (AdminLogin) obj;
		return Objects.equals(mail, other.mail) && Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "AdminLogin [id=" + id + ", mail=" + mail + ", password=" + password + "]";
	}
	
	
}
