package com.retail.billing.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.retail.billing.model.Affiliate;
import com.retail.billing.model.Customer;
import com.retail.billing.model.Employee;
import com.retail.billing.model.Item;
import com.retail.billing.model.ItemType;
import com.retail.billing.service.impl.BillingSystem;

import junit.framework.Assert;

//The class contains unit tests for class bill.
//The tests are mainly to check the logic of getPayableAmount() method.
public class BillingTest {

    Customer newCustomer, oldCustomer;
    Employee employee;
    Affiliate affiliate;
    List<Item> items;

    @Before
    //Initializing method create instances of customers, employee,
    //affiliate and initialize list of items
    public void init(){

        newCustomer = new Customer("nc1", "newcust", new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -2);
        oldCustomer = new Customer("oc1", "oldcust", calendar.getTime());
        employee = new Employee("EmpId", "EmpName");
        affiliate = new Affiliate("AffiliateId", "AffiliateName");

        items = new ArrayList<Item>();
        items.add(new Item("gi1", "milk", 10.0, ItemType.GROCERY));
        items.add(new Item("gi2", "butter", 20.0, ItemType.GROCERY));
        items.add(new Item("gi3", "rice", 30.0, ItemType.GROCERY));
        items.add(new Item("gi4", "sandwich", 40.0, ItemType.GROCERY));
        items.add(new Item("gi5", "skrit", 10.0, ItemType.CLOTHES));
        items.add(new Item("gi6", "phant", 20.0, ItemType.CLOTHES));
        items.add(new Item("gi7", "mobile", 30.0, ItemType.ELECTRONIC));

    }

    @Test
    public void billConstructorTest(){
    	BillingSystem bill = new BillingSystem(employee, items);
        Assert.assertEquals(bill.getUser(), employee);
        Assert.assertEquals(bill.getItems(), items);
    }

    @Test
    public void billSettersTest(){
        BillingSystem bill = new BillingSystem();
        bill.setUser(employee);
        bill.setItems(items);
        Assert.assertEquals(bill.getUser(), employee);
        Assert.assertEquals(bill.getItems(), items);
    }

    @Test
    public void newCustomerPayableAmountTest(){
    	BillingSystem bill = new BillingSystem(newCustomer, items);
    	Assert.assertEquals(bill.getPayableAmount(), (100.0 + 60.0) * 0.95);
    }



    @Test
    public void affiliatePayableAmountTest(){
    	BillingSystem bill = new BillingSystem(affiliate, items);
    	Assert.assertEquals(bill.getPayableAmount(), (100.0 + 60.0) * 0.95);
    }

    @Test
    public void employeePayableAmountTest(){
    	BillingSystem bill = new BillingSystem(employee, items);
    	Assert.assertEquals(bill.getPayableAmount(), (100.0 + 42.0) * 0.95);
    }

}