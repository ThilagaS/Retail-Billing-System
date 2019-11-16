package com.retail.billing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.retail.billing.model.Affiliate;
import com.retail.billing.model.Customer;
import com.retail.billing.model.Employee;
import com.retail.billing.model.Item;
import com.retail.billing.model.ItemType;
import com.retail.billing.service.impl.BillingSystem;

public class RetailBillingSystem {

	public static void main(String[] args) {

		newCustomer();// get the discount for the new customer(purchased above 100)
		oldCustomer();// get the discount for the old customer
		getEmployeeDiscount();// get the discount for the employee
		getAffildateDiscount();// get the discount for the affilidate

	}

	public static void newCustomer() {
		Customer newCustomer = new Customer("ncID", "TestNew", new Date());
		BillingSystem bill = new BillingSystem(newCustomer, getItems());
		bill.getPayableAmount();
		System.out.println(" ***********************New  Customer Payabale amount **************************"
				+ bill.getPayableAmount());
	}

	public static void oldCustomer() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		Customer oldCustomer = new Customer("ocID", "TestOld", calendar.getTime());
		BillingSystem bill = new BillingSystem(oldCustomer, getItems());
		bill.getPayableAmount();
		System.out.println(" ***********************Old  Customer Payabale amount **************************"
				+ bill.getPayableAmount());
	}

	public static void getEmployeeDiscount() {
		Employee employee = new Employee("empId", "Employee1");
		BillingSystem bill = new BillingSystem(employee, getItems());
		bill.getPayableAmount();
		System.out.println(" ***********************Employee Payabale amount **************************"
				+ bill.getPayableAmount());
	}

	public static void getAffildateDiscount() {
		Affiliate affiliate = new Affiliate("affid", "Affiliate1");
		BillingSystem bill = new BillingSystem(affiliate, getItems());
		bill.getPayableAmount();
		System.out.println(" ***********************Affiliate Payabale amount **************************"
				+ bill.getPayableAmount());
	}

	public static List<Item> getItems() {

		List<Item> items = new ArrayList<Item>();
		items.add(new Item("GI1", "Milk", 100.0, ItemType.GROCERY));
		items.add(new Item("GI2", "Butter", 100.0, ItemType.GROCERY));
		items.add(new Item("GI3", "Rice", 100.0, ItemType.GROCERY));
		items.add(new Item("GI4", "Dhaal", 100.0, ItemType.GROCERY));
		items.add(new Item("NGI1", "Phant", 100.0, ItemType.CLOTHES));
		items.add(new Item("NGI2", "Shirt", 100.0, ItemType.CLOTHES));
		items.add(new Item("NGI3", "Car", 100.0, ItemType.TOYS));
		items.add(new Item("NGI4", "Bike", 100.0, ItemType.TOYS));
		items.add(new Item("NGI5", "Mobile", 100.0, ItemType.ELECTRONIC));
		items.add(new Item("NGI6", "IPAD", 90.0, ItemType.ELECTRONIC));

		return items;
	}
}