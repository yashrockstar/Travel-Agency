package com.travel.agency.model;

import java.util.ArrayList;
import java.util.List;

import com.travel.agency.interfaces.PassengerType;

/**
 * Represents a passenger in a travel package, which contains information such
 * as name, passenger number, balance, and activities signed up.
 */
public class Passenger {
	private String name;
	private int passengerNumber;
	private double balance;
	private List<ActivityRegistration> activities;
	private PassengerType passengerType;

	/**
	 * Constructs a new Passenger with the specified name, passenger number,
	 * balance, and passenger type.
	 *
	 * @param name            the name of the passenger
	 * @param passengerNumber the passenger number
	 * @param balance         the balance of the passenger
	 * @param passengerType   the type of the passenger (Standard, Gold, or Premium)
	 */
	public Passenger(String name, int passengerNumber, double balance, PassengerType passengerType) {
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.balance = balance;
		this.activities = new ArrayList<>();
		this.passengerType = passengerType;
	}

	/**
	 * Returns the name of the passenger.
	 *
	 * @return the name of the passenger
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the passenger number.
	 *
	 * @return the passenger number
	 */
	public int getPassengerNumber() {
		return passengerNumber;
	}

	/**
	 * Returns the balance of the passenger.
	 *
	 * @return the balance of the passenger
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Returns the list of activities signed up by the passenger.
	 *
	 * @return the list of activities signed up by the passenger
	 */
	public List<ActivityRegistration> getActivities() {
		return activities;
	}

	/**
	 * Returns the passenger type.
	 *
	 * @return the passenger type
	 */
	public PassengerType getPassengerType() {
		return passengerType;
	}

	/**
	 * Signs up the passenger for the given activity.
	 *
	 * @param activity the activity to sign up for
	 */
	public void signUpForActivity(Activity activity) {
		if (activity.getCapacity() > 0) {
			// Deduct the activity cost from the passenger's balance
			double pricePaid = passengerType.calculatePricePaid(activity, balance);
			if (pricePaid > 0) {
				ActivityRegistration registration = new ActivityRegistration(activity, pricePaid);
				activities.add(registration);
				activity.decreaseCapacity();
				balance -= pricePaid;
			} else {
				System.out.println("Insufficient balance to sign up for the activity.");
			}
		} else {
			System.out.println("Activity is already full. Cannot sign up.");
		}
	}

	public void addActivity(ActivityRegistration activityRegistration) {
		activities.add(activityRegistration);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setActivities(List<ActivityRegistration> activities) {
		this.activities = activities;
	}

	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
}
