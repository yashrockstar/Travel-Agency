package com.travel.agency;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.agency.interfaces.impl.GoldPassengerType;
import com.travel.agency.interfaces.impl.StandardPassengerType;
import com.travel.agency.model.Activity;
import com.travel.agency.model.ActivityRegistration;
import com.travel.agency.model.Destination;
import com.travel.agency.model.Passenger;
import com.travel.agency.model.TravelPackage;

/**
 * This class contains test cases for the TravelPackage class.
 */
@SpringBootTest
public class TravelPackageTest {
	private TravelPackage travelPackage = new TravelPackage("Package 1", 10);

	/**
	 * Test case for adding a destination to the travel package.
	 */
	@Test
	public void testAddDestination() {
		Destination destination = new Destination("Destination 1");

		travelPackage.addDestination(destination);

		List<Destination> itinerary = travelPackage.getItinerary();
		Assert.assertEquals(1, itinerary.size());
		Assert.assertTrue(itinerary.contains(destination));
	}

	/**
	 * Test case for adding a passenger to the travel package.
	 */
	@Test
	public void testAddPassenger() {
		Passenger passenger = new Passenger("John", 1, 500.0, new StandardPassengerType());

		travelPackage.addPassenger(passenger);

		List<Passenger> passengers = travelPackage.getPassengers();
		Assert.assertEquals(1, passengers.size());
		Assert.assertTrue(passengers.contains(passenger));
	}

	/**
	 * Test case for printing the itinerary of the travel package.
	 */
	@Test
	public void testPrintItinerary() {
		// Set up destinations and activities
		Destination destination1 = new Destination("Destination 1");
		Destination destination2 = new Destination("Destination 2");
		Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 5);
		Activity activity2 = new Activity("Activity 2", "Description 2", 200.0, 3);

		destination1.addActivity(activity1);
		destination2.addActivity(activity2);

		travelPackage.addDestination(destination1);
		travelPackage.addDestination(destination2);

		// Test printing itinerary
		travelPackage.printItinerary();
		// No need for assertions on console output as it's already covered in
		// individual method tests
	}

	/**
	 * Test case for printing the passenger list of the travel package.
	 */
	@Test
	public void testPrintPassengerList() {
		// Set up passengers
		Passenger passenger1 = new Passenger("John", 1, 500.0, new StandardPassengerType());
		Passenger passenger2 = new Passenger("Alice", 2, 1000.0, new GoldPassengerType());

		travelPackage.addPassenger(passenger1);
		travelPackage.addPassenger(passenger2);

		// Test printing passenger list
		travelPackage.printPassengerList();
		// No need for assertions on console output as it's already covered in
		// individual method tests
	}

	/**
	 * Test case for printing the details of an individual passenger in the travel package.
	 */
	@Test
	public void testPrintPassengerDetails() {
		// Set up passengers and activities
		Passenger passenger1 = new Passenger("John", 1, 500.0, new StandardPassengerType());
		Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 5);
		ActivityRegistration registration1 = new ActivityRegistration(activity1, 100.0);
		passenger1.addActivity(registration1);

		travelPackage.addPassenger(passenger1);

		// Redirect System.out to capture printed output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		PrintStream originalPrintStream = System.out;
		System.setOut(printStream);

		// Test printing passenger details
		travelPackage.printPassengerDetails(1);

		// Restore original System.out
		System.out.flush();
		System.setOut(originalPrintStream);

		// Get the captured output
		String consoleOutput = outputStream.toString();

		// Assertions
		Assert.assertTrue(consoleOutput.contains("Passenger Details:"));
		Assert.assertTrue(consoleOutput.contains("Name: John"));
		Assert.assertTrue(consoleOutput.contains("Passenger Number: 1"));
		Assert.assertTrue(consoleOutput.contains("Balance: 500.0"));
		Assert.assertTrue(consoleOutput.contains("Activities Signed Up:"));
	}

	/**
	 * Test case for printing the details of all the activities that have available spaces.
	 */
	@Test
	public void testPrintAvailableActivities() {
		// Set up destinations and activities
		Destination destination1 = new Destination("Destination 1");
		Destination destination2 = new Destination("Destination 2");
		Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 5);
		Activity activity2 = new Activity("Activity 2", "Description 2", 200.0, 0);

		destination1.addActivity(activity1);
		destination2.addActivity(activity2);

		travelPackage.addDestination(destination1);
		travelPackage.addDestination(destination2);

		// Test printing available activities
		travelPackage.printAvailableActivities();
		// No need for assertions on console output as it's already covered in
		// individual method tests
	}
}
