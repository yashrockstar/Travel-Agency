package com.travel.agency;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.agency.model.Activity;
import com.travel.agency.model.Destination;

/**
 * This class contains test cases for the Activity class.
 */
@SpringBootTest
public class ActivityTest {
	private Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);

	/**
	 * Test case for getting the name of the activity.
	 */
	@Test
	public void testGetName() {
		Assert.assertEquals("Hiking", activity.getName());
	}

	/**
	 * Test case for getting the description of the activity.
	 */
	@Test
	public void testGetDescription() {
		Assert.assertEquals("Outdoor adventure", activity.getDescription());
	}

	/**
	 * Test case for getting the cost of the activity.
	 */
	@Test
	public void testGetCost() {
		Assert.assertEquals(50.0, activity.getCost(), 0.01);
	}

	/**
	 * Test case for getting the capacity of the activity.
	 */
	@Test
	public void testGetCapacity() {
		Assert.assertEquals(9, activity.getCapacity());
	}

	/**
	 * Test case for getting the destination of the activity before setting.
	 */
	@Test
	public void testGetDestinationBeforeSetting() {
		Assert.assertNull(activity.getDestination());
	}

	/**
	 * Test case for setting the destination of the activity.
	 */
	@Test
	public void testSetDestination() {
		Destination destination = new Destination("Mountain");
		activity.setDestination(destination);
		Assert.assertEquals(destination, activity.getDestination());
	}

	/**
	 * Test case for decreasing the capacity of the activity.
	 */
	@Test
	public void testDecreaseCapacity() {
		activity.decreaseCapacity();
		Assert.assertEquals(9, activity.getCapacity());
	}
}
