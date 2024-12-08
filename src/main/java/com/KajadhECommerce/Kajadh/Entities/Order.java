package com.KajadhECommerce.Kajadh.Entities;

import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "orderList")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;
	
	@JoinColumn(name = "product_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
	
	@Column(name = "order_quantity")
	private int quantity;
	
	@Column(name = "order_cost")
	private double cost;
	
	public Order() {
		super();
	}
	
	public Order(Customer customer, Product product, int quantity, double cost) {
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, customer, id, product, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(customer, other.customer) && id == other.id && Objects.equals(product, other.product)
				&& quantity == other.quantity;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", product=" + product + ", quantity=" + quantity
				+ ", cost=" + cost + "]";
	}	
}
