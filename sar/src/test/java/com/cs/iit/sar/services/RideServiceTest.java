package com.cs.iit.sar.services;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.dto.request.JoinRequestRequest;
import com.cs.iit.sar.dto.request.MessageRequest;
import com.cs.iit.sar.dto.request.RideRequest;
import com.cs.iit.sar.dto.response.CarResponse;
import com.cs.iit.sar.dto.response.DateTimeResponse;
import com.cs.iit.sar.dto.response.LocationInfoResponse;
import com.cs.iit.sar.models.JoinRequest;
import com.cs.iit.sar.models.Message;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class RideServiceTest extends RideService{

	Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	Map<Integer, JoinRequest> joinRequestsMap = DataClass.getJoinRequestsMap();
	Map<Integer, Message> messagesMap = DataClass.getMessagesMap();
	Map<Integer, User> usersMap = DataClass.getUsersMap();	
	RideService service = new RideService();
	
	User userDriver;
	User userRider;
	User userExtra;
	LocationInfoResponse location;
	LocationInfoResponse location2;
	CarResponse car;
	DateTimeResponse dateTime;
	RideRequest ride;
	RideRequest rideDelete;
	RideRequest rideSecond;
	JoinRequest joinRequest;
	JoinRequestRequest joinRequestRequest;
	JoinRequestRequest joinRequestRequest2;
	MessageRequest message;
	MessageRequest message2;
	
	@BeforeAll
	void init() {
		ridesMap = DataClass.getRidesMap();
		joinRequestsMap = DataClass.getJoinRequestsMap();
		messagesMap = DataClass.getMessagesMap();
		usersMap = DataClass.getUsersMap();	
		
		userDriver = new User(1, "Chintan", "Patel", "333-333-3334", "chintan.com", true);
		userRider = new User(2, "Tejasvi", "Patel", "333-332-2343", "chintan.com", true);
		userExtra = new User(3, "Sam", "Manuel", "333-332-2343", "chintan.com", true);
		
		location = new LocationInfoResponse("Chicago", "60640", "Chicago", "60616");
		dateTime = new DateTimeResponse("13-May-2020", "23:33");
		car = new CarResponse("Audi", "A4", "Gray", "IL", "COVID19");
		ride = new RideRequest(2, location, dateTime, car, 5, 5.0, "Be safe");
		location2 = new LocationInfoResponse("Los", "60640", "Springfield", "60616");
		rideSecond = new RideRequest(2, location2, dateTime, car, 4, 4.0, "Hello");
		rideDelete= new RideRequest(3, location, dateTime, car, 5, 5.0, "Be good");
		
		joinRequestRequest = new JoinRequestRequest(2, 4, null, null);
		joinRequestRequest2 = new JoinRequestRequest(2, 3, null, null);
		
		message = new MessageRequest(1, "Nice ride");
		message2 = new MessageRequest(2, "Didn't like the ride");
				
		usersMap.put(1, userDriver);
		usersMap.put(2, userRider);
		usersMap.put(3, userExtra);
	}
	
	@AfterAll
	void cleanUp() {
		
		ridesMap.clear();
		joinRequestsMap.clear();
		messagesMap.clear();
		usersMap.clear();
	}
	
	@Test
	@Order(1)
	void testCreateRide_RideCreatedWithValidRequest_Successful() {
		
		
		service.createRide(ride);
		service.createRide(rideSecond);
		System.out.println("First: " + rideSecond.getAid() + " " + rideSecond.getRid());
	}
	
	@Test
	@Order(2)
	void testUpdateRide_UpdateRideWithValidRequest_Successful() {
		
		service.updateRide(2, rideSecond);
	}
	
	@Test
	@Order(3)
	void testDeleteRide_DeleteExistingRide_Successful() {
	
		service.createRide(rideDelete);

		service.deleteRide(3);

	}
	
	@Test
	@Order(4)
	void testGetAllRides_Successful() {
		service.getAllRides();
	}

	@Test
	void testGetRide_RidExist_Successful() {
		service.getRide(1);
	}
	
	@Test
	@Order(5)
	void testRequestToJoinRide_ValidData_Successful() {
		
		service.requestToJoinRide(1, joinRequestRequest);
	}
	
	@Test
	@Order(6)
	void testAddRequestToRide_ValidData_Successful() {
		
		service.requestToJoinRide(1, joinRequestRequest2);
	}
	
	@Test
	@Order(7)
	void testRespondToRideRequest_Successful() {
		joinRequestRequest2.setRideConfirmed(true);
		joinRequestRequest.setRideConfirmed(true);
		service.respondToRideRequest(1, 4, joinRequestRequest2);
		service.respondToRideRequest(1, 4, joinRequestRequest);
	}
	
	@Test
	@Order(8) 
	void testConfirmPassengerPickup_Successful() {
		joinRequestRequest2.setPickupConfirmed(true);
		service.confirmPassengerPickup(1, 4, joinRequestRequest2);
		joinRequestRequest.setPickupConfirmed(true);
		service.confirmPassengerPickup(1, 4, joinRequestRequest);
	}
	
	@Test
	@Order(9)
	void testGetAllMessages_EmptyMessages_Successful() {
		service.getAllMessages(1);
	}
	
	@Test
	@Order(10)
	void testAddMessage_Successful() {
		service.addMessage(1, message);
	}
	
	@Test
	@Order(10)
	void testGetAllMessages_NonEmptyMessages_Successful() {
		service.addMessage(1, message2);
		service.getAllMessages(1);
	}
	
	@Test
	@Order(10)
	void testSearchRides_FromToDateNotBlank_Successful() {
		service.searchRides("Chicago", "Chicago", "13-May-2020");
	}
	@Test
	@Order(10)
	void testSearchRides_FromToDateNotBlankAndToNotMatch_Successful() {
		service.searchRides("Chicago", "CCC", "13-May-2020");
	}
	@Test
	@Order(10)
	void testSearchRides_FromToDateNotBlankAndDateNotMatch_Successful() {
		service.searchRides("Chicago", "Chicago", "13-May-2017");
	}
	@Test
	@Order(10)
	void testSearchRides_FromToNotBlank_Successful() {
		service.searchRides("Chicago", "Chicago", "");
	}
	@Test
	@Order(10)
	void testSearchRides_FromToNotBlankNotMatch_Successful() {
		service.searchRides("Chicago", "Chi", "");
	}
	@Test
	@Order(10)
	void testSearchRides_FromDateNotBlank_Successful() {
		service.searchRides("Chicago", "", "13-May-2020");
	}
	@Test
	@Order(10)
	void testSearchRides_FromNotBlank_Successful() {
		service.searchRides("Chicago", "", "");
	}
	@Test
	@Order(10)
	void testSearchRides_ToDateNotBlank_Successful() {
		service.searchRides("", "Chicago", "13-May-2020");
	}
	@Test
	@Order(10)
	void testSearchRides_ToNotBlank_Successful() {
		service.searchRides("", "Chicago", "");
	}
	@Test
	@Order(10)
	void testSearchRides_DateNotBlank_Successful() {
		service.searchRides("", "", "13-May-2020");
	}
	@Test
	@Order(10)
	void testSearchRides_FromDateNotMatch_Successful() {
		service.searchRides("Chicago", "", "13-May-2019");	
	}
	@Test
	@Order(10)
	void testSearchRides_ToDateNotMatch_Successful() {
		service.searchRides("", "Chicago", "13-May-2019");	
	}
	@Test
	@Order(10)
	void testSearchRides_DateNotMatch_Successful() {
		service.searchRides("", "", "13-May-2019");	
	}

}
