package com.retail.billing.model;

import lombok.Data;

@Data
public class ItemsModel {

	
	private String itemId;
	private String itemType;
	private double itemPrice;
	private String product;
	public ItemsModel(String itemId, String itemType, double itemPrice, String product) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.product = product;
	}
	public ItemsModel() {
		// TODO Auto-generated constructor stub
	}
	
	
}
