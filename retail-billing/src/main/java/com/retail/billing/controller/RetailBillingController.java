package com.retail.billing.controller;

import java.util.Arrays;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.retail.billing.constants.Constants;
import com.retail.billing.model.BillingResponse;
import com.retail.billing.service.impl.RetailBillingService;



@RestController
@RequestMapping("v1")

public class RetailBillingController {
	@Autowired
	 RetailBillingService billingService;
	
	/**
	 * 
	 * @param headers
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/discounts")
	public BillingResponse getBillling(@RequestHeader HttpHeaders headers,
			@PathVariable(Constants.TYPE) String type) throws Exception {
		   return billingService.payableAmount(type);
		}
}


















