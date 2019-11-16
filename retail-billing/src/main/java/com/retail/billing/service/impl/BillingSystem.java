package com.retail.billing.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.retail.billing.model.Item;
import com.retail.billing.model.ItemType;
import com.retail.billing.model.RetailUser;

public class BillingSystem {
//general class for 
    public BillingSystem(RetailUser user, List<Item> items) {
		super();
		this.user = user;
		this.items = items;
	}

	

	



	public BillingSystem() {
		super();
		// TODO Auto-generated constructor stub
	}







	private RetailUser user;

    private List<Item> items;
    

	public RetailUser getUser() {
		return user;
	}


	public void setUser(RetailUser user) {
		this.user = user;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}
	/**
	 * 
	 * @param items
	 * @return
	 */
	//findGroceryItems Grocery Items in the bill
    private List<Item> findGroceryItems(List<Item> items){
        List<Item> groceryItems = new ArrayList<Item>();
        for(Item item : items){
            if(item.getType().equals(ItemType.GROCERY))
                groceryItems.add(item);
        }
        return groceryItems;
    }
	/**
	 * 
	 * @param items
	 * @return
	 */
    //findNonGroceryItems items in  the bill
    private List<Item> findNonGroceryItems(List<Item> items){
        List<Item> nonGroceryItems = new ArrayList<Item>();
        for(Item item : items){
            if(!item.getType().equals(ItemType.GROCERY))
                nonGroceryItems.add(item);
        }
        return nonGroceryItems;
    }
	/**
	 * 
	 * @param items
	 * @return
	 */
    //find added cost of items in a list
    private double getItemsCost(List<Item> items){
        double addedCost = 0.0;
        for(Item item : items){
            addedCost += item.getCost();
        }
        return addedCost;
    }
    /**
     * 
     * @return
     */
    //find getPayableAmount
    public double getPayableAmount(){
        double payableAmount = 0.0;
        payableAmount = getItemsCost(findGroceryItems(items));
        payableAmount += getItemsCost(findNonGroceryItems(items)) * (100 - user.getDiscount()) / 100;
        payableAmount = payableAmount * 0.95;
        return payableAmount;
    }
	
}