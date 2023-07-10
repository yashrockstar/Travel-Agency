package com.travel.agency.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package that contains destinations and passengers.
 */
public class TravelPackage {
	private String name;
	private int capacity;
	private List<Destination> itinerary;
	private List<Passenger> passengers;

	public TravelPackage() {
		super();
	}

	/**
	 * Constructs a new TravelPackage with the specified name and capacity.
	 *
	 * @param name     the name of the travel package
	 * @param capacity the passenger capacity of the travel package
	 */
	public TravelPackage(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.itinerary = new ArrayList<>();
		this.passengers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Destination> getItinerary() {
		return itinerary;
	}

	public void setItinerary(List<Destination> itinerary) {
		this.itinerary = itinerary;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	/**
	 * Adds a destination to the travel package's itinerary.
	 *
	 * @param destination the destination to be added
	 */
	public void addDestination(Destination destination) {
		itinerary.add(destination);
	}

	/**
	 * Adds a passenger to the travel package.
	 *
	 * @param passenger the passenger to be added
	 */
	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

	/**
	 * Prints the itinerary of the travel package, including the destinations and
	 * their activities.
	 */
	public void printItinerary() {
		System.out.println("Travel Package: " + name);
		for (Destination destination : itinerary) {
			System.out.println("Destination: " + destination.getName());
			List<Activity> activities = destination.getActivities();
			for (Activity activity : activities) {
				System.out.println("Activity: " + activity.getName());
				System.out.println("Cost: " + activity.getCost());
				System.out.println("Capacity: " + activity.getCapacity());
				System.out.println("Description: " + activity.getDescription());
				System.out.println("---------------------------");
			}
			System.out.println("===========================");
		}
	}

	/**
	 * Prints the list of passengers in the travel package.
	 */
	public void printPassengerList() {
		System.out.println("Travel Package: " + name);
		System.out.println("Capacity: " + capacity);
		System.out.println("Number of Passengers: " + passengers.size());
		for (Passenger passenger : passengers) {
			System.out.println("Passenger Name: " + passenger.getName());
			System.out.println("Passenger Number: " + passenger.getPassengerNumber());
			System.out.println("---------------------------");
		}
	}

	/**
	 * Prints the details of a specific passenger in the travel package.
	 *
	 * @param passengerNumber the number of the passenger
	 */
	public void printPassengerDetails(int passengerNumber) {
		System.out.println("Passenger Details:");
		for (Passenger passenger : passengers) {
			if (passenger.getPassengerNumber() == passengerNumber) {
				System.out.println("Name: " + passenger.getName());
				System.out.println("Passenger Number: " + passenger.getPassengerNumber());
				System.out.println("Balance: " + passenger.getBalance());
				List<ActivityRegistration> registrations = passenger.getActivities();
				System.out.println("Activities Signed Up:");
				for (ActivityRegistration registration : registrations) {
					System.out
							.println("Destination: " + (registration.getActivity() != null
									? (registration.getActivity().getDestination() != null
											? registration.getActivity().getDestination().getName()
											: null)
									: null));
					System.out.println("Activity: " + registration.getActivity().getName());
					System.out.println("Price Paid: " + registration.getPricePaid());
					System.out.println("---------------------------");
				}
				break;
			}
		}
	}

	/**
	 * Prints the details of the available activities in the travel package.
	 */
	public void printAvailableActivities() {
		System.out.println("Available Activities:");
		for (Destination destination : itinerary) {
			List<Activity> activities = destination.getActivities();
			for (Activity activity : activities) {
				if (activity.getCapacity() > 0) {
					System.out.println("Destination: " + destination.getName());
					System.out.println("Activity: " + activity.getName());
					System.out.println("Spaces Available: " + activity.getCapacity());
					System.out.println("---------------------------");
				}
			}
		}
	}
}
