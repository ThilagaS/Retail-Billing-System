package com.retail.billing.model;

import java.util.Calendar;
import java.util.Date;

public class Customer extends RetailUser{

	public Customer() {
	}

	public Customer(String custId, String custName,Date joiningDate) {
		super();
		this.joiningDate = joiningDate;
		this.custId = custId;
		this.custName = custName;
	}

	private Date joiningDate;

	private String custId;
	private String custName;

	public String getCustId() {
		return custId;
	}



	public void setCustId(String custId) {
		this.custId = custId;
	}



	public String getCustName() {
		return custName;
	}



	public void setCustName(String custName) {
		this.custName = custName;
	}





	public Date getJoiningDate() {
		return joiningDate;
	}



	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}



	@Override
	public double getDiscount() {
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        calendar.add(Calendar.DATE, 1);
        Date date = calendar.getTime();
        if(joiningDate.before(date))
            return 5.0;
        else
            return 0.0;
	}

}