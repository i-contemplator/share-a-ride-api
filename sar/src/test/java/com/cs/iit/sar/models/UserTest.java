package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.exception.FieldDataMissingException;

@TestInstance(Lifecycle.PER_CLASS)
class UserTest {
	
	User user;
	
	@BeforeAll
	void init() {
		user = new User();
	}

	@Test
	void testSetFirstName_NameShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> user.setFirstName(null));
		assertTrue(e.getMessage().equals("First name appears to be null"));
	}
	
	@Test
	void testSetFirstName_NameShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> user.setFirstName(""));
		assertTrue(e.getMessage().equals("First name appears to be empty"));
	}

	@Test
	void testSetFirstName_NameShouldBeValid_NoException() {
		assertDoesNotThrow(() -> user.setFirstName("Chintan"));
	}
	
	@Test
	void testSetLastName_NameShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> user.setLastName(null));
		assertTrue(e.getMessage().equals("The last name appears to be null"));
	}
	
	@Test
	void testSetLastName_NameShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> user.setLastName(""));
		assertTrue(e.getMessage().equals("The last name appears to be empty"));
	}

	@Test
	void testSetLastName_NameShouldBeValid_NoException() {
		assertDoesNotThrow(() -> user.setLastName("Patel"));
	}
	
	@Test
	void testSetPhone_PhoneShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> user.setPhone(null));
		assertTrue(e.getMessage().equals("The phone number appears to be uninitialized"));
	}
	
	@Test
	void testSetPhone_PhoneShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> user.setPhone(""));
		assertTrue(e.getMessage().equals("The phone number appears to be missing"));
	}

	@Test
	void testSetPhone_PhoneShouldBeValid_NoException() {
		assertDoesNotThrow(() -> user.setPhone("312-333-3333"));
	}
	
	@Test
	void testSetPicture_PictureShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> user.setPicture(null));
		assertTrue(e.getMessage().equals("The picture appears to be uninitialized"));
	}
	
	@Test
	void testSetPicture_PictureShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> user.setPicture(""));
		assertTrue(e.getMessage().equals("The picture appears to be missing"));
	}

	@Test
	void testSetPicture_PictureShouldBeValid_NoException() {
		assertDoesNotThrow(() -> user.setPicture("http://iit.edu"));
	}
	
	@Test
	void testSetActive_ActiveShouldBeNull_ExceptionThrown() {
		NullPointerException e = assertThrows(NullPointerException.class,
				() -> user.setActive(null));
		assertTrue(e.getMessage().equals("is_active appears to be uninitialized"));
	}

	@Test
	void testSetActive_ActiveShouldBeValid_NoException() {
		assertDoesNotThrow(() -> user.setActive(false));
	}
	
}
