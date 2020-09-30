package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.exception.FieldDataMissingException;

@TestInstance(Lifecycle.PER_CLASS)

class DateTimeTest {

	DateTime dateTime;
	
	@BeforeAll
	void init() {
		dateTime = new DateTime();
	}
	
	@Test
	void testSetDate_DateShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class,
				() -> dateTime.setDate(null));
		assertTrue(e.getMessage().equals("date appears to be null"));
	}
	
	@Test
	void testSetDate_DateShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> dateTime.setDate(""));
		assertTrue(e.getMessage().equals("date appears to be missing"));
	}
	
	@Test
	void testSetDate_DateShouldBeValid_NoException() {
		assertDoesNotThrow(() -> dateTime.setDate("22-Apr-2020"));
	}
	
	@Test
	void testSetTime_TimeShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class,
				() -> dateTime.setTime(null));
		assertTrue(e.getMessage().equals("time appears to be null"));
	}
	
	@Test
	void testSetTime_TimeShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> dateTime.setTime(""));
		assertTrue(e.getMessage().equals("time appears to be missing"));
	}
	
	@Test
	void testSetTime_TimeShouldBeValid_NoException() {
		assertDoesNotThrow(() -> dateTime.setTime("22:34"));
	}

}
