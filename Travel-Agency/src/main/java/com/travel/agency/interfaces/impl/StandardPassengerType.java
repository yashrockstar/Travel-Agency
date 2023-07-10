package com.travel.agency.interfaces.impl;

import com.travel.agency.interfaces.PassengerType;
import com.travel.agency.model.Activity;

/**
 * This class represents the implementation of the PassengerType interface for
 * standard passengers.
 */
public class StandardPassengerType implements PassengerType {

    /**
     * Calculates the price paid by a standard passenger for the given activity based
     * on their balance.
     *
     * @param activity the activity for which the price is calculated
     * @param balance  the balance of the passenger
     * @return the price paid by the passenger
     */
    @Override
    public double calculatePricePaid(Activity activity, double balance) {
        return balance - activity.getCost();
    }
}
