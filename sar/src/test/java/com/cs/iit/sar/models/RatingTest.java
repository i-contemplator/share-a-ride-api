package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class RatingTest {

	Rating rating;
	
	@BeforeAll
	void init() {
		rating = new Rating();
	}
	
	@Test
	void testSetRid_RidShouldBeNull_ExceptionThrown() {
		
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> rating.setRid(null));
		assertTrue(e.getMessage().equals("rid appears to be null"));
	}
	
	@Test
	void testSetRid_RidShouldBeValid_NoException() {
		assertDoesNotThrow(() -> rating.setRid(4));
	}

	@Test
	void testSetSentById_SentByIdShouldBeNull_ExceptionThrown() {
		
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> rating.setSentById(null));
		assertTrue(e.getMessage().equals("sent_by_id appears to be null"));
	}
	
	@Test
	void testSetSentById_SentByIdShouldBeValid_NoException() {
		assertDoesNotThrow(() -> rating.setSentById(4));
	}
	
	@Test
	void testSetRating_RatingShouldBeNull_ExceptionThrown() {
		
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> rating.setRating(null));
		assertTrue(e.getMessage().equals("rating appears to be null"));
	}
	
	@Test
	void testSetRating_RatingShouldBeValid_NoException() {
		assertDoesNotThrow(() -> rating.setRating(4));
	}
	
	@Test
	void testGetAccountToRate_AccountToRateValid_Successful() {
		rating.getAccountToRate();
	}
	
}
