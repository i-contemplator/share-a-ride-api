package com.cs.iit.sar.services.exceptionchecker.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.DataNotFoundException;
import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
class AccountValidationTest extends AccountValidation{
	
	Map<Integer, User> usersMap;
	
	@BeforeAll
	void init() {
		User user = new User();
		usersMap = DataClass.getUsersMap();
		usersMap.put(1, user);
	}
	
	@AfterAll
	void cleanUp() {
		usersMap.clear();
	}
	
	@Test
	void validateAid_AidOfAccountThatShouldNotExist_ExceptionThrown() {	
		
		DataNotFoundException exception = assertThrows(DataNotFoundException.class, 
				() -> AccountValidation.validateAid(2));
		assertTrue(exception.getMessage().contains("The account identified by [2] doesn't exist"));
	}
	
	@Test 
	void validateAid_AidOfAccountThatShouldExist_NoException() {

		assertDoesNotThrow(() -> AccountValidation.validateAid(1));
	}
	
	@Test
	void validateName_NameWithNumbersShouldBeInvalid_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> AccountValidation.validateName("12345", "Invalid name"));
		assertTrue(exception.getMessage().contains("Invalid name"));
	}
	
	@Test
	void validateName_NameWithoutNumbersShouldBeValid_NoException() {
		
		assertDoesNotThrow(() -> AccountValidation.validateName("John", "Invalid name"));
	}
	
	@Test
	void validatePhone_NumberWithDifferentFormatShouldBeInvalid_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> AccountValidation.validatePhoneNumber("9876543210"));
		assertTrue(exception.getMessage().contains("Invalid phone number"));
	}
	
	@Test
	void validatePhone_NumberWithCorrectFormatShouldBeValid_NoException() {
		
		assertDoesNotThrow(() -> AccountValidation.validatePhoneNumber("987-654-3210")); 
	}

	@Test
	void validateActive_ActiveShouldNotBeFalseToActivateAccount_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> AccountValidation.validateActive(false));
		assertTrue(exception.getMessage().contains("Invalid value for is_active"));
	}
	
	@Test
	void validateActive_ActiveShouldBeTrueToActivateAccount_NoException() {
		
		assertDoesNotThrow(() -> AccountValidation.validateActive(true)); 
	}
	
	@Test
	void validateActiveWhenUpdatingAccount_ActiveShouldNotBeTrueToUpdateAccount_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> AccountValidation.validateActiveWhenUpdating(true));
		assertTrue(exception.getMessage().contains("Invalid value for is_active"));
	}
	
	@Test
	void validateActiveWhenUpdatingAccount_ActiveShouldBeFalseToUpdateAccount_NoException() {
		
		assertDoesNotThrow(() -> AccountValidation.validateActiveWhenUpdating(false)); 
	}
}
