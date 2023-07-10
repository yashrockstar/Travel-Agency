package com.travel.agency;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.agency.interfaces.impl.GoldPassengerType;
import com.travel.agency.interfaces.impl.PremiumPassengerType;
import com.travel.agency.interfaces.impl.StandardPassengerType;
import com.travel.agency.model.Activity;
import com.travel.agency.model.ActivityRegistration;
import com.travel.agency.model.Passenger;

/**
 * This class contains test cases for the Passenger class.
 */
@SpringBootTest
public class PassengerTest {
	private Passenger passenger = new Passenger("John", 1, 500.0, new StandardPassengerType());

	/**
	 * Test case for getting the name of the passenger.
	 */
	@Test
	public void testGetName() {
		Assert.assertEquals("John", passenger.getName());
	}

	/**
	 * Test case for getting the passenger number.
	 */
	@Test
	public void testGetPassengerNumber() {
		Assert.assertEquals(1, passenger.getPassengerNumber());
	}

	/**
	 * Test case for getting the balance of the passenger.
	 */
	@Test
	public void testGetBalance() {
		Assert.assertEquals(500.0, passenger.getBalance(), 0.01);
	}

	/**
	 * Test case for getting the activities of the passenger when initially empty.
	 */
	@Test
	public void testGetActivitiesInitiallyEmpty() {
		Assert.assertFalse(passenger.getActivities().isEmpty());
	}

	/**
	 * Test case for signing up the passenger for an activity with sufficient balance.
	 */
	@Test
	public void testSignUpForActivitySufficientBalance() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);

		passenger.signUpForActivity(activity);

		Assert.assertEquals(2, passenger.getActivities().size());
		Assert.assertEquals(50.0, passenger.getBalance(), 0.01);
	}

	/**
	 * Test case for signing up the passenger for an activity with insufficient balance.
	 */
	@Test
	public void testSignUpForActivityInsufficientBalance() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 600.0, 10);

		passenger.signUpForActivity(activity);

		Assert.assertFalse(passenger.getActivities().isEmpty());
		Assert.assertEquals(500.0, passenger.getBalance(), 0.01);
	}

	/**
	 * Test case for signing up the passenger for an activity when the activity is full.
	 */
	@Test
	public void testSignUpForActivityActivityFull() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 0);

		passenger.signUpForActivity(activity);

		Assert.assertFalse(passenger.getActivities().isEmpty());
		Assert.assertEquals(500.0, passenger.getBalance(), 0.01);
	}

	/**
	 * Test case for adding an activity to the passenger.
	 */
	@Test
	public void testAddActivity() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		ActivityRegistration registration = new ActivityRegistration(activity, 50.0);

		passenger.addActivity(registration);

		Assert.assertEquals(1, passenger.getActivities().size());
		Assert.assertEquals(registration, passenger.getActivities().get(0));
	}

	/**
	 * Test case for calculating the price paid by a gold passenger for an activity.
	 */
	@Test
	public void testCalculatePricePaidGoldPassenger() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = new GoldPassengerType().calculatePricePaid(activity, passenger.getBalance());

		Assert.assertEquals(455.0, pricePaid, 0.01);
	}

	/**
	 * Test case for calculating the price paid by a standard passenger for an activity.
	 */
	@Test
	public void testCalculatePricePaidStandardPassenger() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = new StandardPassengerType().calculatePricePaid(activity, passenger.getBalance());

		Assert.assertEquals(450.0, pricePaid, 0.01);
	}

	/**
	 * Test case for calculating the price paid by a premium passenger for an activity.
	 */
	@Test
	public void testCalculatePricePaidPremiumPassenger() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = new PremiumPassengerType().calculatePricePaid(activity, passenger.getBalance());

		Assert.assertEquals(0.0, pricePaid, 0.01);
	}
}
