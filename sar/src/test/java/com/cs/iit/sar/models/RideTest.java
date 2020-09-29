package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class RideTest {
	
	Ride ride;
	
	@BeforeAll
	void init() {
		ride = new Ride();
	}

	@Test
	void testSetAid_AidShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> ride.setAid(null));
		assertTrue(e.getMessage().equals("aid appears to be null"));
	}
	
	@Test
	void testSetAid_AidShouldBeValid_NoException() {
		assertDoesNotThrow(() -> ride.setAid(2));
	}
	
	@Test
	void testSetLocationInfo_LocationInfoShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> ride.setLocationInfo(null));
		assertTrue(e.getMessage().equals("location_info appears to be null"));
	}
	
	@Test
	void testSetLocationInfo_LocationInfoShouldBeValid_NoException() {
		LocationInfo lI = new LocationInfo();
		assertDoesNotThrow(() -> ride.setLocationInfo(lI));
	}
	
	@Test
	void testSetDateTime_DateTimeShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> ride.setDateTime(null));
		assertTrue(e.getMessage().equals("date_time appears to be null"));
	}
	
	@Test
	void testSetDateTime_DateTimeShouldBeValid_NoException() {
		DateTime dT = new DateTime();
		assertDoesNotThrow(() -> ride.setDateTime(dT));
	}
	
	@Test
	void testSetCarInfo_CarInfoShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> ride.setCarInfo(null));
		assertTrue(e.getMessage().equals("car_info appears to be null"));
	}
	
	@Test
	void testSetCarInfo_CarInfoShouldBeValid_NoException() {
		Car car = new Car();
		assertDoesNotThrow(() -> ride.setCarInfo(car));
	}
	
	@Test
	void testSetMaxPassengers_MaxPassengersShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> ride.setMaxPassengers(null));
		assertTrue(e.getMessage().equals("max_passengers appears to be null"));
	}
	
	@Test
	void testSetMaxPassengers_MaxPassengersShouldBeValid_NoException() {
		assertDoesNotThrow(() -> ride.setMaxPassengers(5));
	}
	
	@Test
	void testSetAmountPerPassenger_AmountPerPassengerShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> ride.setAmountPerPassenger(null));
		assertTrue(e.getMessage().equals("amount_per_passenger appears to be null"));
	}
	
	@Test
	void testSetAmountPerPassenger_AmountPerPassengerShouldBeValid_NoException() {
		assertDoesNotThrow(() -> ride.setAmountPerPassenger(5.9));
	}
	
	@Test
	void testSetConditions_ConditionsShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> ride.setConditions(null));
		assertTrue(e.getMessage().equals("conditions appears to be null"));
	}
	
	@Test
	void testSetConditions_ConditionsShouldBeValid_NoException() {
		assertDoesNotThrow(() -> ride.setConditions("Good ride."));
	}
}
