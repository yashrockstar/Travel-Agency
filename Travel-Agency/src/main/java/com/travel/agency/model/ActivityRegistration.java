package com.travel.agency.model;

/**
 * Represents a registration for an activity in a travel package.
 */
public class ActivityRegistration {
    private Activity activity;
    private double pricePaid;

    /**
     * Constructs a new ActivityRegistration with the specified activity and price paid.
     *
     * @param activity   the activity being registered
     * @param pricePaid  the price paid for the activity registration
     */
    public ActivityRegistration(Activity activity, double pricePaid) {
        this.activity = activity;
        this.pricePaid = pricePaid;
    }

    /**
     * Returns the activity associated with this registration.
     *
     * @return the activity associated with this registration
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * Returns the price paid for this activity registration.
     *
     * @return the price paid for this activity registration
     */
    public double getPricePaid() {
        return pricePaid;
    }
}
