package com.retail.core;

class AirItem extends Item {

	private static final long serialVersionUID = 1L;
	

	AirItem(String upc, String description, double price, double weight, String shippingType) {
		super(upc, description, price, weight, shippingType);

	}

	@Override
	public double calculateShippingCost() {
		double airCostWithoutRounding = super.getWeight() * Character.getNumericValue(super.getUpc().charAt(10));
		return Math.round((airCostWithoutRounding) * 100) / 100.0;
	}

}
