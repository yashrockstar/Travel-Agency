package com.travel.agency.interfaces.impl;

import com.travel.agency.interfaces.PassengerType;
import com.travel.agency.model.Activity;

/**
 * This class represents the implementation of the PassengerType interface for
 * gold passengers.
 */
public class GoldPassengerType implements PassengerType {

    private static final double DISCOUNT_PERCENTAGE = 0.9;

    /**
     * Calculates the price paid by a gold passenger for the given activity based on
     * their balance and applies a discount.
     *
     * @param activity the activity for which the price is calculated
     * @param balance  the balance of the passenger
     * @return the price paid by the passenger
     */
    @Override
    public double calculatePricePaid(Activity activity, double balance) {
        return balance - (activity.getCost() * DISCOUNT_PERCENTAGE);
    }
}
