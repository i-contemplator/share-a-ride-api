package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.exception.FieldDataMissingException;

@TestInstance(Lifecycle.PER_CLASS)
class LocationInfoTest {

	LocationInfo location;
	
	@BeforeAll
	void init() {
		location = new LocationInfo();
	}
	
	@Test
	void testSetFromCity_FromCityShouldBeNull_ExceptionThrown() {
		
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> location.setFromCity(null));
		assertTrue(e.getMessage().equals("from_city appears to be null"));
	}
	
	@Test
	void testSetFromCity_FromCityShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> location.setFromCity(""));
		assertTrue(e.getMessage().equals("from_city appears to be empty"));
	}
	
	@Test
	void testSetFromCity_FromCityShouldBeValid_NoException() {
		assertDoesNotThrow(() -> location.setFromCity("Chicago"));
	}
	
	@Test
	void testSetToCity_ToCityShouldBeNull_ExceptionThrown() {
		
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> location.setToCity(null));
		assertTrue(e.getMessage().equals("to_city appears to be null"));
	}
	
	@Test
	void testSetToCity_ToCityShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> location.setToCity(""));
		assertTrue(e.getMessage().equals("to_city appears to be empty"));
	}
	
	@Test
	void testSetToCity_ToCityShouldBeValid_NoException() {
		assertDoesNotThrow(() -> location.setToCity("Houston"));
	}

}
