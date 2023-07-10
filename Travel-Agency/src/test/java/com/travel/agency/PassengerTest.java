package com.travel.agency;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.agency.enums.TypeOfPassenger;
import com.travel.agency.model.Activity;
import com.travel.agency.model.ActivityRegistration;
import com.travel.agency.model.Passenger;

@SpringBootTest
public class PassengerTest {
	private Passenger passenger = new Passenger("John", 1, 500.0, TypeOfPassenger.Standard);

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

		Assert.assertEquals(3, passenger.getActivities().size());
		Assert.assertEquals(50.0, passenger.getBalance(), 0.01);
	}

	@Test
	public void testSignUpForActivityInsufficientBalance() {
		Activity activity = new Activity("Hiking", "Outdoor adventure", 600.0, 10);

		passenger.signUpForActivity(activity);

		Assert.assertFalse(passenger.getActivities().isEmpty());
		Assert.assertEquals(600.0, passenger.getBalance(), 0.01);
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
		passenger.setPassengerType(TypeOfPassenger.Gold);

		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = passenger.calculatePricePaid(activity);

		Assert.assertEquals(45.0, pricePaid, 0.01);
	}

	@Test
	public void testCalculatePricePaidStandardPassenger() {
		passenger.setPassengerType(TypeOfPassenger.Standard);

		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = passenger.calculatePricePaid(activity);

		Assert.assertEquals(450.0, pricePaid, 0.01);
	}

	@Test
	public void testCalculatePricePaidPremiumPassenger() {
		passenger.setPassengerType(TypeOfPassenger.Premium);

		Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);
		double pricePaid = passenger.calculatePricePaid(activity);

		Assert.assertEquals(0.0, pricePaid, 0.01);
	}
}
