package com.cs.iit.sar.services.exceptionchecker.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
class MessageValidationTest extends MessageValidation{

	Map<Integer, User> usersMap;
	
	@BeforeAll
	void init() {
		User user = new User();
		user.setActive(true);
		usersMap = DataClass.getUsersMap();
		usersMap.put(1, user);
		User inactiveUser = new User();
		inactiveUser.setActive(false);
		usersMap.put(2, inactiveUser);
		
	}
	
	@AfterAll
	void cleanUp() {
		usersMap.clear();
	}
	
	@Test
	void validateActiveAccount_ActiveAccountShouldAddMessage_NoException() {
		
		assertDoesNotThrow(() -> MessageValidation.validateActiveAccount(1));
	}
	
	@Test
	void validateActiveAccount_NonActiveAccountShouldAddMessage_ExceptionThrown() {
		
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class,
				() -> MessageValidation.validateActiveAccount(2));
		assertTrue(e.getMessage().equals("This account (2) is not active, may not create a ride."));
	}
	

}
