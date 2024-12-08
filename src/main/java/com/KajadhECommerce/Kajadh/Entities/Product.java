package com.KajadhECommerce.Kajadh.Entities;

import java.util.Map;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "product")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "product_specifications",joinColumns =  @JoinColumn(name = "product_spec"))
	@MapKeyColumn(name = "specification_name")
	@Column(name = "specification_value")
	private Map<String, String> specification;
	
	
	public Product() {
		super();
	}
	
	public Product(String brandName, String name, int quantity, double price, Map<String, String> specification) {
		this.brandName = brandName;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.specification = specification;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(brandName, id, name, price, quantity, specification);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(brandName, other.brandName) && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && quantity == other.quantity
				&& Objects.equals(specification, other.specification);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brandName=" + brandName + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + ", specification=" + specification + "]";
	}
}