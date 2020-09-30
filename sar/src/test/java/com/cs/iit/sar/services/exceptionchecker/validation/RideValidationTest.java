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
import com.cs.iit.sar.models.Car;
import com.cs.iit.sar.models.DateTime;
import com.cs.iit.sar.models.LocationInfo;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
class RideValidationTest extends RideValidation{

	Map<Integer, User> usersMap;
	Map<Integer, Ride> ridesMap;
	
	@BeforeAll
	void init() {
		User user = new User();
		usersMap = DataClass.getUsersMap();
		user.setActive(true);
		usersMap.put(1, user);
		user.setActive(false);
		usersMap.put(2, user);
		Ride ride = new Ride();
		ride.setAid(1);
		ridesMap = DataClass.getRidesMap();
		ridesMap.put(1, ride);
	}
	
	@AfterAll
	void cleanUp() {
		usersMap.clear();
		ridesMap.clear();
	}
	
	@Test
	void validateAid_AidOfAccountThatShouldNotExist_ExceptionThrown() {	
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateAid(70));
		assertTrue(exception.getMessage().contains("Invalid aid"));
	}
	
	@Test 
	void validateAid_AidOfAccountThatShouldExist_NoException() {

		assertDoesNotThrow(() -> RideValidation.validateAid(1));
	}
	
	@Test
	void validateLocationInfo_FromZipToZipShouldBeValid_Successful() {
		
		LocationInfo locationInfo = new LocationInfo();
		locationInfo.setFromZip("60640");
		locationInfo.setToZip("60616");
		RideValidation.validateLocationInfo(locationInfo);
	}
	
	@Test
	void validateFromZip_FromZipShouldBeValid_Successful() {
		
		assertDoesNotThrow(() -> RideValidation.validateToZip("60640"));		
	}
	
	@Test
	void validateToZip_ToZipShouldBeValid_Successful() {
		
		assertDoesNotThrow(() -> RideValidation.validateToZip("60640"));		
	}
	
	@Test
	void validateToZip_toZipShouldBeBlank_ReturnNothing() {
		RideValidation.validateToZip("");
	}
	
	@Test
	void validateFromZip_FromZipShouldNotBeInvalid_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateFromZip("606"));
		assertTrue(exception.getMessage().contains("Invalid from_zip"));
	}
	
	@Test
	void validateToZip_ToZipShouldNotBeInvalid_ExceptionThrown() {

		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateToZip("6066666"));
		assertTrue(exception.getMessage().contains("Invalid to_zip"));
	}
	
	@Test
	void validateDateTime_DateAndTimeShouldBeValid_Successful() {
		
		DateTime dateTime = new DateTime();
		dateTime.setDate("08-May-2020");
		dateTime.setTime("20:44");
		RideValidation.validateDateTime(dateTime);
	}
	
	@Test
	void validateDate_DateShouldBeValid_Successful() {
		
		assertDoesNotThrow(() -> RideValidation.validateDate("08-May-2020"));		
	}
	
	@Test
	void validateTime_TimeShouldBeValid_Successful() {
		
		assertDoesNotThrow(() -> RideValidation.validateTime("20:44"));		
	}
	
	@Test
	void validateDate_DateShouldNotBeInValid_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateDate("606"));
		assertTrue(exception.getMessage().contains("Invalid date"));
	}
	
	@Test
	void validateTime_TimeShouldNotBeInValid_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateTime("10:1077"));
		assertTrue(exception.getMessage().contains("Invalid time"));
	}
	
	@Test
	void validateCarInfo_PlateStateShouldBeValid_NoException() {
		Car car = new Car();
		car.setPlateState("IL");
		assertDoesNotThrow(() -> RideValidation.validateCarInfo(car));
	}
	
	@Test
	void validateCarInfo_PlateStateLengthShouldNotBeMoreThanTwo_ExceptionThrown() {
		
		Car car = new Car();
		car.setPlateState("Illinois");
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateCarInfo(car));
		assertTrue(exception.getMessage().contains("Invalid plate_slate"));
	}
	
	@Test
	void validateCarInfo_PlateStateShouldNotBeLowerCase_ExceptionThrown() {
		
		Car car = new Car();
		car.setPlateState("Il");
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateCarInfo(car));
		assertTrue(exception.getMessage().contains("Invalid plate_slate"));
	}
	
	@Test
	void validateMaxPassengers_MaxPassengersShouldBeMoreThanZero_NoException() {
		
		assertDoesNotThrow(() -> RideValidation.validateMaxPassengers(5));
	}
	
	@Test
	void validateMaxPassengers_MaxPassengersShouldNotBeLessThanZero_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateMaxPassengers(-5));
		assertTrue(exception.getMessage().contains("Invalid max_passengers"));
	}
	
	@Test
	void validateAmountPerPassenger_AmountPerPassengerShouldBeMoreThanOrEqualToZero_NoException() {
		
		assertDoesNotThrow(() -> RideValidation.validateAmountPerPassenger(5.0));
	}
	
	@Test
	void validateAmountPerPassenger_AmountPerPassengerShouldNotBeLessThanZero_ExceptionThrown() {
		
		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateAmountPerPassenger(-5.0));
		assertTrue(exception.getMessage().contains("Invalid amount_per_passenger"));	
	}
	
	@Test
	void validateRid_RidOfRideThatShouldNotExist_ExceptionThrown() {
		
		DataNotFoundException exception = assertThrows(DataNotFoundException.class,
				() -> RideValidation.validateRid(80));
		assertTrue(exception.getMessage().contains("The ride identified by [80] doesn't exist"));
	}
	
	@Test
	void validateRid_RidOfRideThatShouldExist_NoException() {

		assertDoesNotThrow(() -> RideValidation.validateRid(1));
	}
	
	@Test
	void validateCreatorOfRide_CreatorOfRideShouldUpdateTheirRide_NoException() {
		
		assertDoesNotThrow(() -> RideValidation.validateCreatorOfRide(1, 1));
	}
	
	@Test
	void validateCreatorOfRide_NonCreatorOfRideShouldNotUpdateOtherRide_ExceptionThrown() {

		FieldDataInvalidException exception = assertThrows(FieldDataInvalidException.class, 
				() -> RideValidation.validateCreatorOfRide(2, 1));
		assertTrue(exception.getMessage().contains("Only the creator of the ride may change it"));
	}
}
