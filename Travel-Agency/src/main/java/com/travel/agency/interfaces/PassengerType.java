package com.travel.agency.interfaces;

import com.travel.agency.model.Activity;

public interface PassengerType {
	double calculatePricePaid(Activity activity, double balance);
}
