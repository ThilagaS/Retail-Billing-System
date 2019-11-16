package com.retail.billing.model;

import lombok.Data;

@Data
public class Employee  extends RetailUser{
	@Override
    public double getDiscount(){
        return 30.0;
    }
	private String id;
	private String empName;
	
	
	    public Employee(String id, String empName) {
		super();
		this.id = id;
		this.empName = empName;
	}


}
