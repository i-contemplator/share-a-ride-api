package com.cs.iit.sar.services.exceptionchecker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.dto.request.JoinRequestRequest;
import com.cs.iit.sar.models.Car;
import com.cs.iit.sar.models.DateTime;
import com.cs.iit.sar.models.JoinRequest;
import com.cs.iit.sar.models.LocationInfo;
import com.cs.iit.sar.models.Message;
import com.cs.iit.sar.models.Rating;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
class RideExceptionTest extends RideException{

	Map<Integer, User> usersMap;
	Map<Integer, Ride> ridesMap;
	Map<Integer, JoinRequest> joinRequestsMap;
	User userDriver;
	User userRider;
	LocationInfo location;
	Car car;
	DateTime dateTime;
	Ride ride;
	Ride rideDelete;
	JoinRequest joinRequest;
	JoinRequestRequest joinRequestRequest;
	Message message;
	
	@BeforeAll
	void init() {
		usersMap = DataClass.getUsersMap();
		ridesMap = DataClass.getRidesMap();
		joinRequestsMap = DataClass.getJoinRequestsMap();
		
		userDriver = new User(1, "Chintan", "Patel", "333-333-3334", "chintan.com", true);
		userRider = new User(2, "Tejasvi", "Patel", "333-332-2343", "chintan.com", true);
		
		location = new LocationInfo("Chicago", "60640", "Chicago", "60616");
		dateTime = new DateTime("13-May-2020", "23:33");
		car = new Car("IL");
		ride = new Ride(1, 1, location, dateTime, car, 5, 5.0);
		
		rideDelete= new Ride();
		
		joinRequest = new JoinRequest(1, 1, 1, 4, null, null);
		joinRequestRequest = new JoinRequestRequest();
		joinRequestRequest.setAid(1);
		joinRequestRequest.setRideConfirmed(true);
		
		message = new Message(1, "Nice ride");
		
		joinRequestsMap.put(1, joinRequest);
		ridesMap.put(1, ride);
		ridesMap.put(3, rideDelete);
		usersMap.put(1, userDriver);
		usersMap.put(2, userRider);
		
	}
	
	@AfterAll
	void cleanUp() {
		usersMap.clear();
		ridesMap.clear();
		joinRequestsMap.clear();
	}
	
	@Test
	void testCheckCreateRide_RideDataAreValid_Successful() {
		
		RideException.checkCreateRide(ride);
	}
	
	@Test
	void testCheckUpdateRide_RideExistAndRideDataValid_Successful() {
		
		RideException.checkUpdateRide(1, ride);
	}
	
	@Test
	void testCheckDeleteRide_RideExistToDelete_Successful() {
		
		RideException.checkDeleteRide(3);
	}
	
	@Test
	void testGetRide_RideExistToQuery_Successful() {
		
		RideException.checkGetRide(1);
	}
	
	@Test
	void testCheckRequestToJoinRide_RideExistAndRequestDataValid_Successful() {
		
		RideException.checkRequestToJoinRide(1, joinRequest);
	}
	
	@Test
	void testCheckRespondToRideRequest_RidJidAreValidAndPatchRideRequestValid_Successful() {
		
		RideException.checkRespondToRideRequest(1, 1, joinRequestRequest);
	}
	
	@Test
	void testCheckConfirmPickup_RidJidExistAndConfirmRidePickupValid_Successful() {
		
		joinRequestRequest.setPickupConfirmed(true);
		RideException.checkConfirmPickup(1, 1, joinRequestRequest);
	}
	
	@Test
	void testCheckAddMessage_RidValidAndMessageCreatorValid_Successful() {
		
		RideException.checkAddMessage(1, message);
	}
	
	@Test
	void testCheckGetAllMessages_RidShouldBeValid_Successful() {
		
		RideException.checkGetAllMessages(1);
	}
	
}
