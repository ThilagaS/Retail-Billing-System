package com.retail.billing.model;

import lombok.Data;

@Data
public class Affiliate  extends RetailUser{
	private String id;
	private String name;

    public Affiliate(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
    public double getDiscount(){
        return 10.0;
    }
}
