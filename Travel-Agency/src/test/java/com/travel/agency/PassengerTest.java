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

@SpringBootTest
public class PassengerTest {
	private Passenger passenger = new Passenger("John", 1, 500.0, new StandardPassengerType());

	@Test
	public void testGetName() {
		Assert.assertEquals("John", passenger.getName());
	}

	@Test
	public void testGetPassengerNumber() {
		Assert.assertEquals(1, passenger.getPassengerNumber());
	}

	@Test
	public void testGetBalance() {
		Assert.assertEquals(500.0, passenger.getBalance(), 0.01);
	}

	@Test
	public void testGetActivitiesInitiallyEmpty() {
		Assert.assertFalse(passenger.getActivities().isEmpty());
	}

	@Test
	public void testSignUpForActivitySufficientBalance() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);

		passenger.signUpForActivity(activity);

		Assert.assertEquals(2, passenger.getActivities().size());
		Assert.assertEquals(50.0, passenger.getBalance(), 0.01);
	}

	@Test
	public void testSignUpForActivityInsufficientBalance() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 600.0, 10);

		passenger.signUpForActivity(activity);

		Assert.assertFalse(passenger.getActivities().isEmpty());
		Assert.assertEquals(500.0, passenger.getBalance(), 0.01);
	}

	@Test
	public void testSignUpForActivityActivityFull() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 0);

		passenger.signUpForActivity(activity);

		Assert.assertFalse(passenger.getActivities().isEmpty());
		Assert.assertEquals(500.0, passenger.getBalance(), 0.01);
	}

	@Test
	public void testAddActivity() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		ActivityRegistration registration = new ActivityRegistration(activity, 50.0);

		passenger.addActivity(registration);

		Assert.assertEquals(1, passenger.getActivities().size());
		Assert.assertEquals(registration, passenger.getActivities().get(0));
	}

	@Test
	public void testCalculatePricePaidGoldPassenger() {

		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = new GoldPassengerType().calculatePricePaid(activity, passenger.getBalance());

		Assert.assertEquals(455.0, pricePaid, 0.01);
	}

	@Test
	public void testCalculatePricePaidStandardPassenger() {

		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = new StandardPassengerType().calculatePricePaid(activity, passenger.getBalance());

		Assert.assertEquals(450.0, pricePaid, 0.01);
	}

	@Test
	public void testCalculatePricePaidPremiumPassenger() {

		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = new PremiumPassengerType().calculatePricePaid(activity, passenger.getBalance());

		Assert.assertEquals(0.0, pricePaid, 0.01);
	}
}