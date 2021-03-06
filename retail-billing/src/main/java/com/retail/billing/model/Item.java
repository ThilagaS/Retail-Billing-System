package com.retail.billing.model;
public class Item {
	//Item class with 4 fields id, name, cost and type.
	   private String id;
	    private String name;
	    private double cost;
	    private ItemType type;

	    public Item() {
	    }

	    public Item(String id, String name, double cost, ItemType type) {
	        this.id = id;
	        this.name = name;
	        this.cost = cost;
	        this.type = type;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getCost() {
	        return cost;
	    }

	    public void setCost(double cost) {
	        this.cost = cost;
	    }

	    public ItemType getType() {
	        return type;
	    }

	    public void setType(ItemType type) {
	        this.type = type;
	    }
}
