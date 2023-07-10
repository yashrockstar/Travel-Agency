package com.travel.agency.interfaces;

import com.travel.agency.model.Activity;

/**
 * This interface represents the type of a passenger and defines the method to
 * calculate the price paid by the passenger for an activity.
 */
public interface PassengerType {

    /**
     * Calculates the price paid by the passenger for the given activity based on
     * their balance.
     *
     * @param activity the activity for which the price is calculated
     * @param balance  the balance of the passenger
     * @return the price paid by the passenger
     */
    double calculatePricePaid(Activity activity, double balance);
}
