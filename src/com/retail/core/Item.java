package com.retail.core;

import java.io.Serializable;

public abstract class Item implements Comparable<Item>, Serializable{
	 
	
	private static final long serialVersionUID = 1L;
	private String upc;
	private String description;
	private double price;
	private double weight;
	private ShippingType shippingType;
    static final String ITEM_HEADER = "UPC\t\t\t" + "Description\t\t\t" + "Price\t" + "Weight\t" + "Ship Method\t" +
    									"Shipping Cost\n";
	
	public ShippingType getShippingType() {
		return shippingType;
	}

	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}




	private enum ShippingType {
		AIR,
		GROUND
		
	}
	
	static Item createItem(String upc, String description, double price, double weight, String shippingType) {
		Item anItem = null;
		if("AIR".equals(shippingType)) {
			anItem =  new AirItem(upc,description,price,weight,shippingType);
		}else if("GROUND".equals(shippingType)) {
			anItem =  new GroundItem(upc,description,price,weight,shippingType);
		}else {
			throw new IllegalArgumentException("Shipping Type must be either 'AIR' or 'GROUND'");
		}
		
		return anItem;
	}
	
	Item(String upc, String description, double price, double weight, String shippingType){
		this.upc = upc;
		this.description = description;
		this.price = price;
		this.weight = weight;
		this.shippingType = ShippingType.valueOf(shippingType);
	}
	
	
	public String getUpc() {
		return upc;
	}

	public String getDescription() {
		return description;
	}
	
	

	public double getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}
	
	public abstract double calculateShippingCost();
	
	@Override
	public int compareTo(Item anItem) {
		return this.getUpc().compareTo(anItem.getUpc());
	}
	

	

/**
 * UPC	Description	Price	Weight	Shipping Method
 */
	@Override
	public String toString() {
		
		StringBuilder sbItem = new StringBuilder(		 		
		    this.getUpc() +  "\t" + this.getDescription() + "\t" + this.getPrice() +
		   "\t  " + this.getWeight() + "\t" + this.shippingType + "\t\t" + this.calculateShippingCost());
		
		return sbItem.toString();
	}
	


}
