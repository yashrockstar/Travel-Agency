package com.travel.agency.model;

/**
 * Represents an activity available at a destination in a travel package.
 */
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;

    /**
     * Constructs a new Activity with the specified name, description, cost, and capacity.
     *
     * @param name        the name of the activity
     * @param description the description of the activity
     * @param cost        the cost of the activity
     * @param capacity    the capacity of the activity
     */
    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
    }

    /**
     * Returns the name of the activity.
     *
     * @return the name of the activity
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the activity.
     *
     * @return the description of the activity
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the cost of the activity.
     *
     * @return the cost of the activity
     */
    public double getCost() {
        return cost;
    }

    /**
     * Returns the capacity of the activity.
     *
     * @return the capacity of the activity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the destination where the activity is available.
     *
     * @return the destination of the activity
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Sets the destination where the activity is available.
     *
     * @param destination the destination of the activity
     */
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /**
     * Decreases the capacity of the activity by 1.
     */
    public void decreaseCapacity() {
        capacity--;
    }
}
