package com.cs.iit.sar.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.dto.request.AccountRequest;
import com.cs.iit.sar.dto.request.RateAccountRequest;
import com.cs.iit.sar.dto.response.AccountResponse;
import com.cs.iit.sar.dto.response.CreateAccountAidResponse;
import com.cs.iit.sar.models.Rating;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class AccountServiceTest extends AccountService {

	Map<Integer, User> usersMap = DataClass.getUsersMap();
	Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	AccountService service = new AccountService();
	
	AccountRequest accountRequest;
	RateAccountRequest ratingRequest1;
	RateAccountRequest ratingRequest2;
	Ride ride1;
	Ride ride2;
	User userActivate;
	User userDelete;
	User userUpdate;
	Map<Integer, User> riders1;
	Map<Integer, User> riders2;
	
	@BeforeAll
	void init() {
		usersMap = DataClass.getUsersMap();
		ridesMap = DataClass.getRidesMap();
		accountRequest = new AccountRequest("Chintan", "Patel", "312-394-3443", "https://chintan.com", false);
		
		userActivate = new User(2, "Tejasvi", "patel", "322-343-5345", "chintan.com", true);
		userUpdate = new User(3, "Jaag", "Patel", "322-343-5345", "chintan.com", false);
		userDelete = new User(4, "Sam", "Jackson", "322-343-5345", "chintan.com", true);
		
		usersMap.put(2, userActivate);
		usersMap.put(3, userUpdate);
		usersMap.put(4, userDelete);
		
		ride1 = new Ride();
		ride1.setAid(2);
		ride1.setRid(1);
		
		riders1 = new HashMap<>();
		riders1.put(3, userUpdate);
		ride1.setRiders(riders1);
		ridesMap.put(1, ride1);
		
		ride2 = new Ride();
		ride2.setAid(3);
		ride2.setRid(2);
		
		riders2 = new HashMap<>();
		riders2.put(2, userActivate);
		ride2.setRiders(riders2);
		ridesMap.put(2, ride2);
		
		ratingRequest1 = new RateAccountRequest(1, 3, 4);
		ratingRequest2 = new RateAccountRequest(2, 2, 4);

	}
	
	@AfterAll
	void cleanUp() {
		usersMap.clear();
		ridesMap.clear();
		riders1.clear();
		riders2.clear();
	}
	
	@Test
	@Order(1)
	void testCreateAccount_CreateAccountWithValidData_Successful() {
		
		CreateAccountAidResponse response = service.createAccount(accountRequest);
		
		assertEquals(1, response.getAid());
	}
	
	@Test
	@Order(2)
	void testActivateAccount_ActivateAccountWithValidData_Successful() {

		accountRequest.setActive(true);
		service.activateAccount(1, accountRequest);
	}
	
	@Test
	@Order(3)
	void testUpdateAccount_UpdateAccountWithValidData_Successful() {
		
		accountRequest.setActive(false);
		service.updateAccount(1, accountRequest);
	}
	
	@Test
	@Order(4)
	void testDeleteAccount_DeleteAccountWithValidData_Successful() {
		
		service.deleteAccount(4);
	}
	
	@Test
	@Order(5)
	void testViewAllAccount_Successful() {
		
		service.viewAllAccounts();
	}
	
	@Test
	@Order(6)
	void testSearchAccounts_Successful() {
		
		service.searchAccounts("Chintan");
	}
	
	@Test
	void testSearchAccounts_KeyDontMatch_UnSuccessful() {
		service.searchAccounts("343wdsfare");
	}
	
	@Test
	void testIsKeyMatch_KeyMatchSuccessfullyLastName_ReturnTrue() {
		assertTrue(service.isKeyMatch(userActivate, "patel"));
	}
	
	@Test
	void testIsKeyMatch_KeyMatchSuccessfullyFirstName_ReturnTrue() {
		assertTrue(service.isKeyMatch(userActivate, "tejasvi"));
	}
	
	@Test
	void testIsKeyMatch_KeyDoesNotMatch_ReturnFalse() {
		
		assertFalse(service.isKeyMatch(userUpdate, "ddddd"));
	}
	
	@Test
	void testIsKeyMatch_KeyDoesMatchSuccessfullyPhone_ReturnTrue() {
		boolean match = service.isKeyMatch(userActivate, "322-343-5345");
		assertTrue(match);
	}
	
	@Test
	void testIsKeyMatch_KeyMatchSuccessfullyPicture_ReturnTrue() {
		assertTrue(service.isKeyMatch(userActivate, "chintan.com"));
	}
	
	@Test
	void testIsKeyMatch_KeyMatchAidSuccessfully_ReturnTrue() {
		assertTrue(service.isKeyMatch(userActivate, "2"));
	}
	
	@Test
	@Order(7)
	void testRateAccount_RateDriverAccountWithValidData_Successful() {
		service.rateAccount(3, ratingRequest2);
	}
	
	@Test
	@Order(8)
	void testRateAccount_RateRiderAccountWithValidData_Successful() {
		ratingRequest1.setSentById(2);
		service.rateAccount(3, ratingRequest1);
	}
	
	@Test
	void testIsDriver_DriverShouldMatch_ReturnTrue() {
		service.isDriver(2, 2);
	}
	
	@Test
	void testIsDriver_DriverShouldNotMatch_ReturnFalse() {
		service.isDriver(2, 3);	
	}
	
	@Test
	void testIsRider_RiderShouldMatch_ReturnTrue() {
		service.isRider(riders1, 3);
	}
	
	@Test
	void testIsRider_RiderShouldNotMatch_ReturnFalse() {
		service.isRider(riders1, 2);
	}
	
	@Test
	@Order(9)
	void testAddRatingForDriver_AddFirstRating_Successful() {
		
		List<Rating> ratings = new ArrayList<>();
		Rating rating = new Rating(1, 1, 4, 3);
		ratings.add(rating);
		userActivate.setDriversRating(ratings);
		
		Rating rating2 = new Rating(1, 1, 3, 3);
		
		service.addRatingForDriver(userActivate, rating2);
		
	}
	
	@Test
	@Order(10)
	void testAddRatingForRider_AddFirstRating_Successful() {
		
		List<Rating> ratings = new ArrayList<>();
		Rating rating = new Rating(1, 1, 4, 2);
		ratings.add(rating);
		userUpdate.setRidersRating(ratings);
		
		Rating rating2 = new Rating(1, 1, 3, 2);
		
		service.addRatingForRider(userUpdate, rating2);
	}
	
	@Test
	void testViewDriverRatings_Successful() {
		service.viewDriverRatings(2);
	}
	
	@Test
	void testViewRiderRatings_Successful() {
		service.viewRiderRatings(3);
	}
	
}
