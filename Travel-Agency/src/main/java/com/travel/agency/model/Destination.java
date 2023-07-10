package com.travel.agency.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination in a travel package, which contains a name and a list of activities.
 */
public class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Constructs a new Destination with the specified name.
     *
     * @param name the name of the destination
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    /**
     * Adds an activity to the destination.
     *
     * @param activity the activity to be added
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Returns the name of the destination.
     *
     * @return the name of the destination
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of activities in the destination.
     *
     * @return the list of activities in the destination
     */
    public List<Activity> getActivities() {
        return activities;
    }
}
