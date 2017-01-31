package com.shop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IndividualItem {
	@Id
	@GeneratedValue
	private int itemId;
	private String isAvailable;

	public int getItemId() {
		return itemId;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	
}
