package com.travel.agency;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.agency.model.Activity;
import com.travel.agency.model.ActivityRegistration;

/**
 * This class contains test cases for the ActivityRegistration class.
 */
@SpringBootTest
public class ActivityRegistrationTest {
    private Activity activity = new Activity("Activity 1", "Description 1", 100.0, 5);
    private ActivityRegistration activityRegistration = new ActivityRegistration(activity, 90.0);

    /**
     * Test case for getting the activity associated with the registration.
     */
    @Test
    public void testGetActivity() {
        Assert.assertEquals(activity, activityRegistration.getActivity());
    }

    /**
     * Test case for getting the price paid for the activity registration.
     */
    @Test
    public void testGetPricePaid() {
        Assert.assertEquals(90.0, activityRegistration.getPricePaid(), 0.01);
    }
}
