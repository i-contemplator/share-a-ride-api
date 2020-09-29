package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.exception.FieldDataInvalidException;

@TestInstance(Lifecycle.PER_CLASS)
class JoinRequestTest {

	JoinRequest joinRequest;
	
	@BeforeAll
	void init() {
		joinRequest = new JoinRequest();
	}
	
	@Test
	void testSetAid_AidShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> joinRequest.setAid(null));
		assertTrue(e.getMessage().equals("aid appears to be null"));
	}
	
	@Test
	void testSetAid_AidShouldBeValid_NoException() {
		assertDoesNotThrow(() -> joinRequest.setAid(2));
	}
	
	@Test
	void testSetPassengers_PassengersShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class, 
				() -> joinRequest.setPassengers(null));
		assertTrue(e.getMessage().equals("passengers appears to be null"));
	}
	
	@Test
	void testSetPassengers_PassengersShouldBeValid_NoException() {
		assertDoesNotThrow(() -> joinRequest.setPassengers(2));
	}

}
