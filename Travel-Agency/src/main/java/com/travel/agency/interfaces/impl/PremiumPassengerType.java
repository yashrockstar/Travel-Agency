package com.travel.agency.interfaces.impl;

import com.travel.agency.interfaces.PassengerType;
import com.travel.agency.model.Activity;

/**
 * This class represents the implementation of the PassengerType interface for
 * premium passengers.
 */
public class PremiumPassengerType implements PassengerType {

    /**
     * Calculates the price paid by a premium passenger for the given activity.
     * Premium passengers have a price of 0 for all activities.
     *
     * @param activity the activity for which the price is calculated
     * @param balance  the balance of the passenger (not used for premium passengers)
     * @return the price paid by the passenger (always 0 for premium passengers)
     */
    @Override
    public double calculatePricePaid(Activity activity, double balance) {
        return 0;
    }
}
