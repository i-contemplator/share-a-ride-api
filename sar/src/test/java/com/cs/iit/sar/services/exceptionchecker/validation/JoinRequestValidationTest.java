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
import com.cs.iit.sar.models.JoinRequest;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
class JoinRequestValidationTest extends JoinRequestValidation{

	Map<Integer, Ride> ridesMap;
	Map<Integer, JoinRequest> joinRequestsMap;
	
	@BeforeAll
	void init() {
		Ride ride = new Ride();
		ride.setAid(1);
		ride.setMaxPassengers(5);
		ridesMap = DataClass.getRidesMap();
		ridesMap.put(1, ride);
		joinRequestsMap = DataClass.getJoinRequestsMap();
		JoinRequest joinRequest = new JoinRequest();
		joinRequest.setAid(1);
		joinRequestsMap.put(1, joinRequest);
	}
	
	@AfterAll
	void cleanUp() {
		ridesMap.clear();
		joinRequestsMap.clear();
	}
	
	@Test
	void validatePassengersToJoin_PassengersShouldBeBetweenZeroAndMaxPassengers_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validatePassengersToJoin(4, 1));
	}

	@Test
	void validatePassengersToJoin_PassengersShouldNotBeLessThanZero_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> JoinRequestValidation.validatePassengersToJoin(-2, 1));
		assertTrue(exception.getMessage().equals("Invalid passengers amount"));
	}
	
	@Test
	void validatePassengersToJoin_PassengersShouldNotBeMoreThanMaxPassengers_ExceptionThrown() {

		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> JoinRequestValidation.validatePassengersToJoin(6, 1));
		assertTrue(exception.getMessage().equals("Invalid passengers amount"));
	}
	
	@Test
	void validateJid_JidOfJoinRequestThatShouldNotExist_ExceptionThrown() {
		
		DataNotFoundException exception = assertThrows(DataNotFoundException.class,
				() -> JoinRequestValidation.validateJid(120));
		assertTrue(exception.getMessage().contains("Join Request does not exist"));
	}
	
	@Test
	void validateJid_JidOfJoinRequestThatShouldExist_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validateJid(1));
	}
	
	@Test
	void validateNullForAid_AidShouldNotBeNull_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validateNullForAid(5));
	}
	
	@Test
	void validateNullForAid_AidShouldBeNull_ExceptionThrown() {
		
		NullPointerException exception = assertThrows(NullPointerException.class,
				() -> JoinRequestValidation.validateNullForAid(null));
		assertTrue(exception.getMessage().equals("aid appears to be null"));
	}
	
	@Test
	void validateNullForRideConfirmed_RideConfirmedShouldNotBeNull_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validateNullForRideConfirmed(true));
	}
	
	@Test
	void validateNotNullForRideConfirmed_RideConfirmedShouldBeNull_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validateNotNullForRideConfirmed(null));
	}
	
	@Test
	void validateNotNullForRideConfirmed_RideConfirmedShouldBeNotNull_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> JoinRequestValidation.validateNotNullForRideConfirmed(false));
		assertTrue(exception.getMessage().equals("Invalid value for ride_confirmed"));
	}
	
	@Test
	void validateNotNullForPickupConfirmed_PickupConfirmedShouldBeNull_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validateNotNullForPickupPassenger(null));
	}
	
	@Test
	void validateNotNullForPickupConfirmed_PickupConfirmedShouldBeNotNull_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> JoinRequestValidation.validateNotNullForPickupPassenger(false));
		assertTrue(exception.getMessage().equals("Invalid value for pickup_confirmed"));
	}
	
	@Test
	void validateNullForRideConfirmed_RideConfirmedShouldBeNull_ExceptionThrown() {
		
		NullPointerException exception = assertThrows(NullPointerException.class,
				() -> JoinRequestValidation.validateNullForRideConfirmed(null));
		assertTrue(exception.getMessage().equals("Invalid value for ride_confirmed"));
	}
	
	@Test
	void validateRideCreator_RideCreatorShouldOnlyRespondToJoinRequest_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validateRideCreator(1, 1));
	}
	
	@Test
	void validateRideCreator_NonRideCreatorShouldRespondToJoinRequest_ExceptionThrown() {

		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> JoinRequestValidation.validateRideCreator(1, 5));
		assertTrue(exception.getMessage().contains("This account (5) didn't create the ride (1)"));
	}
	
	@Test
	void validatePickupConfirmed_PickupConfirmedShouldNotBeFalse_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validatePickupConfirmed(true));
	}
	
	@Test
	void validatePickupConfirmed_PickupConfirmedShouldBeFalse_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class,
				() -> JoinRequestValidation.validatePickupConfirmed(false));
		assertTrue(exception.getMessage().equals("Invalid value for pickup_confirmed"));
	}
	
	@Test
	void validateRequestor_OnlyRideRequestorShouldConfirmPassengerPickup_NoException() {
		
		assertDoesNotThrow(() -> JoinRequestValidation.validateRequestor(1, 1, 1));
	}
	
	@Test
	void validateRequestor_NonRideRequestorShouldConfirmPassengerPickup_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> JoinRequestValidation.validateRequestor(1, 1, 5));
		assertTrue(exception.getMessage().contains("This account (5) has not requested to join this ride (1)"));
	}
	
}
