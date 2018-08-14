package com.retail.core;

import java.util.ArrayList;
import java.util.List;

public  class Products {

	
	
	public  static List<Item> getItems(){
		
		List<Item> items = new ArrayList<Item>();
		
		items.add(Item.createItem("567321101987", "CD - PinkFloyd, Dark Side Of The Moon", 19.99, 0.58, "AIR"));
		items.add(Item.createItem("567321101986", "CD - Beatles, Abbey Road             ", 17.99, 0.61, "GROUND"));
		items.add(Item.createItem("567321101985", "CD - Queen, A Night At The Opera     ", 20.49, 0.55, "AIR"));
		items.add(Item.createItem("567321101984", "CD - Michael Jackson, Thriller       ", 23.88, 0.50, "GROUND"));
		items.add(Item.createItem("467321101899", "iPhone - Waterproof Case              ", 9.75, 0.73, "AIR"));
		items.add(Item.createItem("477321101878", "iPhone -  Headphones                 ", 17.25, 3.21, "GROUND"));

		return items;
		
	}
}
