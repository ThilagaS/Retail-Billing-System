package com.retail.billing.model;

import lombok.Data;

@Data
public class BillingResponse {
	
	private double payableamount;
	private String userType;

}
