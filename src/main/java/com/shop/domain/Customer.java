package com.shop.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int customerId;
	private String name;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "ship_street")),
			@AttributeOverride(name = "city", column = @Column(name = "ship_city")),
			@AttributeOverride(name = "state", column = @Column(name = "ship_state")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "ship_zipCode"))

	})
	Address shippingAddress;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "bill_street")),
			@AttributeOverride(name = "city", column = @Column(name = "bill_city")),
			@AttributeOverride(name = "state", column = @Column(name = "bill_state")),
			@AttributeOverride(name = "zipCode", column = @Column(name = "bill_zipCode"))

	})
	Address billingAddress;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

}
