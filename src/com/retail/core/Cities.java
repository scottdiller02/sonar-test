package com.retail.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cities {
	public static List<String> cities = new ArrayList<String>();
	public static Map<String,String> distanceMap;
	
	static {
		cities.add("Atlanta");
		cities.add("Seattle");
		cities.add("Tampa");
	}
	
	public static List<String> getCities(){
			
		return cities;
		
	}
	
	public static Map<String,String> getDistanceMap() {
		distanceMap = new HashMap<String, String>();
		
		distanceMap.put("Atlanta-Tampa", "456");
		distanceMap.put("Atlanta-Seattle", "2636");
		distanceMap.put("Seattle-Tampa", "3090");
		
		return distanceMap;
		
	}
	
	

}
