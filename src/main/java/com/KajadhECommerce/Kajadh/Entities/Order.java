package com.KajadhECommerce.Kajadh.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderList")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne
	private Customer customer;
	
	@JoinColumn(name = "product_id")
	@ManyToOne
	private Product product;
	
	@Column(name = "order_quantity")
	private int quantity;
	
	@Column(name = "order_cost")
	private int cost;
	
	public Order() {
		super();
	}
	
	public Order(Customer customer, Product product, int quantity, int cost) {
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
