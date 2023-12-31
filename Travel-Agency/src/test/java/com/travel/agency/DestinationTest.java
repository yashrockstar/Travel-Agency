package com.travel.agency;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.agency.model.Activity;
import com.travel.agency.model.Destination;

/**
 * This class contains test cases for the Destination class.
 */
@SpringBootTest
public class DestinationTest {
    private Destination destination = new Destination("Beach Destination");

    /**
     * Test case for getting the name of the destination.
     */
    @Test
    public void testGetName() {
        Assert.assertEquals("Beach Destination", destination.getName());
    }

    /**
     * Test case for getting the activities of the destination when initially empty.
     */
    @Test
    public void testGetActivitiesInitiallyEmpty() {
        Assert.assertFalse(destination.getActivities().isEmpty());
    }

    /**
     * Test case for adding an activity to the destination.
     */
    @Test
    public void testAddActivity() {
        Activity activity = new Activity("Snorkeling", "Explore underwater life", 50.0, 10);

        destination.addActivity(activity);

        Assert.assertEquals(1, destination.getActivities().size());
        Assert.assertTrue(destination.getActivities().contains(activity));
    }
}
