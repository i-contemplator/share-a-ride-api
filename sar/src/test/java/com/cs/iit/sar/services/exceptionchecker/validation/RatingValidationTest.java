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
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
class RatingValidationTest extends RatingValidation{

	Map<Integer, User> usersMap;
	Map<Integer, Ride> ridesMap;
	
	@BeforeAll
	void init() {
		User user = new User();
		usersMap = DataClass.getUsersMap();
		usersMap.put(1, user);
		usersMap.put(2, user);
		Ride ride = new Ride();
		ridesMap = DataClass.getRidesMap();
		ridesMap.put(1, ride);
	}
	
	@AfterAll
	void cleanUp() {
		usersMap.clear();
		ridesMap.clear();
	}
	
	@Test
	void validateRateSameAccount_UserShouldNotRateTheirOwnAccount_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateRateSameAccount(5, 5));
		assertTrue(exception.getMessage().contains("Cannot rate the same account"));
	}
	
	@Test
	void validateRateSameAccount_UserShouldRateDifferentAccount_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateRateSameAccount(5, 6));
	}
	
	@Test
	void validateRid_RidOfRideThatShouldNotExist_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> RatingValidation.validateRid(20));
		assertTrue(exception.getMessage().contains("Invalid value for rid"));
	}
	
	@Test
	void validateRid_RidOfRideThatShouldExist_NoException() {
		
		Ride ride = new Ride();
		Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
		ridesMap.put(5, ride);
		assertDoesNotThrow(() -> RatingValidation.validateRid(1));
	}
	
	@Test
	void validateAid_AidOfAccountThatShouldNotExist_ExceptionThrown() {	
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateAid(30));
		assertTrue(exception.getMessage().contains("Invalid value for aid"));
	}
	
	@Test 
	void validateAid_AidOfAccountThatShouldExist_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateAid(1));
	}
	
	@Test
	void validateSentById_AidOfAccountThatShouldNotExist_ExceptionThrown() {	
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateSentById(50));
		assertTrue(exception.getMessage().contains("Invalid value for sent_by_id"));
	}
	
	@Test 
	void validateSentById_AidOfAccountThatShouldExist_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateSentById(2));
	}
	
	@Test
	void validateRatingAmount_RatingShouldNotBeLessThanZero_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateRatingAmount(-10));
		assertTrue(exception.getMessage().contains("Invalid rating amount"));
	}
	
	@Test
	void validateRatingAmount_RatingShouldNotBeGreaterThanFive_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateRatingAmount(10));
		assertTrue(exception.getMessage().contains("Invalid rating amount"));
	}
	
	@Test
	void validateRatingAmount_RatingShouldBeBetweenZeroAndFive_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateRatingAmount(3));
	}
	
	@Test
	void validateUserPartOfRide_UserNotRiderNorDriver_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateUserPartOfRide(false, false, 5, 2));
		assertTrue(exception.getMessage().contains("This account (5) didn't create this ride (2) nor was it a passenger"));
	}
	
	@Test
	void validateUserPartOfRide_UserIsRider_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateUserPartOfRide(true, false, 5, 2));
	}
	
	@Test
	void validateUserPartOfRide_UserIsRiderUserIsDriver_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateUserPartOfRide(true, true, 5, 2));
	}
	
	@Test
	void validateUserPartOfRide_SenderIsDriverReceiverIsRider_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateBothRider(true, true));
	}
	
	@Test
	void validateBothDriver_BothUsersDriver_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateBothDriver(true, false));
		assertTrue(exception.getMessage().contains("Both users cannot be a driver. Invalid data."));
	}
	
	@Test
	void validateBothDriver_SenderIsNotDriverReceiverIsNotDriver_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateBothDriver(false, true));
	}
	
	@Test
	void validateBothDriver_SenderIsRiderReceiverIsDriver_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateBothDriver(false, false));
	}
	
	@Test
	void validateBothDriver_BothUsersNotDriver_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateBothDriver(true, true));
	}
	
	@Test
	void validateBothRider_BothUsersRider_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RatingValidation.validateBothRider(false, true));
		assertTrue(exception.getMessage().contains("A rider cannot rate another rider. Invalid data."));
	}
	
	@Test
	void validateBothRider_SenderIsRiderReceiverIsNotRider_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateBothRider(false, false));
	}
	
	@Test
	void validateBothRider_BothUsersNotRider_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateBothRider(true, false));
	}
	
	@Test
	void validateBothRider_SenderIsNotRiderReceiverIsRider_NoException() {
		
		assertDoesNotThrow(() -> RatingValidation.validateBothRider(true, true));
	}

}
