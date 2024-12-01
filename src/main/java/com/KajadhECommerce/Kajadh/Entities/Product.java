package com.KajadhECommerce.Kajadh.Entities;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "product_brand_name")
	private String brandName;
	
	@Column(name = "product_model_name")
	private String name;
	
	@Column(name = "product_quantity")
	private int quantity;
	
	@Column(name = "product_price")
	private double price;
	
	@ElementCollection
	@CollectionTable(name = "product_specifications",joinColumns =  @JoinColumn(name = "product_spec"))
	@MapKeyColumn(name = "specification_name")
	@Column(name = "specification_value")
	private Map<String, String> specification;
	
	
	public Product() {
		super();
	}
	
	public Product(String brandName, String name, int quantity, double price) {
		this.brandName = brandName;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Map<String, String> getSpecification() {
		return specification;
	}

	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}
}
