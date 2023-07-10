package com.travel.agency.interfaces.impl;

import com.travel.agency.interfaces.PassengerType;
import com.travel.agency.model.Activity;

public class GoldPassengerType implements PassengerType {
	
	private static final double DISCOUNT_PERCENTAGE = 0.9;

	@Override
	public double calculatePricePaid(Activity activity, double balance) {
		return balance - (activity.getCost() * DISCOUNT_PERCENTAGE);
	}

}
