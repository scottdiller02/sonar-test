package com.retail.core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Shipment { // abstract ONLY to get use of calculateShippingCost

	private List<Item> aShipment = new ArrayList<Item>();

	boolean addItemToShipment(Item anItem) {
		return aShipment.add(anItem);
	}

	List<Item> getShipment() {
		return aShipment;
	}

	void shipmentReport() {
		System.out.println("****SHIPMENT REPORT**** \t\t\t" + "Date:" + LocalDateTime.now() + "\n\n");
		System.out.println(Item.ITEM_HEADER);
		
		double total = 0;
	
		Collections.sort(aShipment);
	    
		for (Item item : aShipment) {
			total += item.calculateShippingCost();
			System.out.println(item.toString() + "\t");
		}
		
		System.out.println("\nTOTAL SHIPPING COST:\t\t\t\t\t\t\t\t\t" + total);

	}

}
