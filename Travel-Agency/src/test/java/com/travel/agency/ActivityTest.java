package com.travel.agency;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.agency.model.Activity;
import com.travel.agency.model.Destination;

@SpringBootTest
public class ActivityTest {
	private Activity activity = new Activity("Hiking", "Outdoor adventure", 50.0, 10);

	@Test
	public void testGetName() {
		Assert.assertEquals("Hiking", activity.getName());
	}

	@Test
	public void testGetDescription() {
		Assert.assertEquals("Outdoor adventure", activity.getDescription());
	}

	@Test
	public void testGetCost() {
		Assert.assertEquals(50.0, activity.getCost(), 0.01);
	}

	@Test
	public void testGetCapacity() {
		Assert.assertEquals(9, activity.getCapacity());
	}

	@Test
	public void testGetDestinationBeforeSetting() {
		Assert.assertNull(activity.getDestination());
	}

	@Test
	public void testSetDestination() {
		Destination destination = new Destination("Mountain");
		activity.setDestination(destination);
		Assert.assertEquals(destination, activity.getDestination());
	}

	@Test
	public void testDecreaseCapacity() {
		activity.decreaseCapacity();
		Assert.assertEquals(9, activity.getCapacity());
	}
}
