package com.retail.core;

class GroundItem extends Item {

	private static final long serialVersionUID = 1L;

	GroundItem(String upc, String description, double price, double weight, String shippingType) {
		super(upc, description, price, weight, shippingType);
	}

	/**
	 * @see com.retail.core.Shipment#calculateShippingCost()
	 * Note this calls super class to calculate tariff and then adds the tariff to 
	 * the ground shipping algorithm
	 */
	@Override
	public double calculateShippingCost() {
		double groundShippingAmt = super.getWeight() * 2.5;
		return Math.round(groundShippingAmt * 100) / 100.0;
	}



}
