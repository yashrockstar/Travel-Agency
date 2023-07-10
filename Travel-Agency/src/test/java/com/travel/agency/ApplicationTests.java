package com.travel.agency;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {

	@Test
	public void runAllTests() {

		testTravelPackage();
		testDestination();
		testActivity();
		testPassenger();
		testActivityRegistration();
	}

	private void testTravelPackage() {
		TravelPackageTest travelPackageTest = new TravelPackageTest();
		travelPackageTest.testAddDestination();
		travelPackageTest.testAddPassenger();
		travelPackageTest.testPrintAvailableActivities();
		travelPackageTest.testPrintItinerary();
		travelPackageTest.testPrintPassengerDetails();
		travelPackageTest.testPrintPassengerList();
	}

	private void testDestination() {
		DestinationTest destinationTest = new DestinationTest();
		destinationTest.testAddActivity();
		destinationTest.testGetActivitiesInitiallyEmpty();
		destinationTest.testGetName();
	}

	private void testActivity() {
		ActivityTest activityTest = new ActivityTest();
		activityTest.testDecreaseCapacity();
		activityTest.testGetCapacity();
		activityTest.testGetCost();
		activityTest.testGetDescription();
		activityTest.testGetDestinationBeforeSetting();
		activityTest.testGetName();
		activityTest.testSetDestination();
	}

	private void testPassenger() {
		PassengerTest passengerTest = new PassengerTest();
		passengerTest.testAddActivity();
		passengerTest.testCalculatePricePaidGoldPassenger();
		passengerTest.testCalculatePricePaidPremiumPassenger();
		passengerTest.testCalculatePricePaidStandardPassenger();
		passengerTest.testGetActivitiesInitiallyEmpty();
		passengerTest.testGetBalance();
		passengerTest.testGetName();
		passengerTest.testGetPassengerNumber();
		passengerTest.testSignUpForActivityActivityFull();
		passengerTest.testSignUpForActivityInsufficientBalance();
		passengerTest.testSignUpForActivitySufficientBalance();
	}

	private void testActivityRegistration() {
		ActivityRegistrationTest activityRegistrationTest = new ActivityRegistrationTest();
		activityRegistrationTest.testGetActivity();
		activityRegistrationTest.testGetPricePaid();
	}

}
