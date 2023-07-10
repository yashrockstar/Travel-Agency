package com.travel.agency.interfaces.impl;

import com.travel.agency.interfaces.PassengerType;
import com.travel.agency.model.Activity;

public class StandardPassengerType implements PassengerType {

	@Override
	public double calculatePricePaid(Activity activity, double balance) {
		return balance - activity.getCost();
	}

}
