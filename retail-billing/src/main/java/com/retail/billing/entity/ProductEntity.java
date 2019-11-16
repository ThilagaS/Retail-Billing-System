package com.retail.billing.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Products")
@Data
public class ProductEntity {
	private String itemId;
	private String itemType;
	private double itemPrice;
	private String product;
	public ProductEntity(String itemId, String itemType, double itemPrice, String product) {
		super();
		this.itemId = itemId;
		this.itemType = itemType;
		this.itemPrice = itemPrice;
		this.product = product;
	}
	public ProductEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
