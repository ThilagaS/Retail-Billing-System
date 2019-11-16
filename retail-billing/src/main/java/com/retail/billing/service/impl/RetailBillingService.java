package com.retail.billing.service.impl;

import com.retail.billing.model.BillingResponse;

public interface RetailBillingService {
	
	public  BillingResponse  payableAmount(String type) throws Exception;

}