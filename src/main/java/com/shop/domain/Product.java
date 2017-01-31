package com.shop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int productId;
	@NotBlank
	private String productName;
	@NotBlank
	private String category;
	@NotBlank
	private String description;
	@DecimalMin("0.0")
	private double price;
	@DecimalMin("0.0")
	private double quantity;
	@OneToMany(cascade = CascadeType.ALL)
	private List<IndividualItem> itemsList;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<IndividualItem> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<IndividualItem> itemsList) {
		this.itemsList = itemsList;
	}

}
