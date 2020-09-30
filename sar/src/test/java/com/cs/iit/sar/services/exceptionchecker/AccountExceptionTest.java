package com.cs.iit.sar.services.exceptionchecker;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.models.Rating;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

@TestInstance(Lifecycle.PER_CLASS)
class AccountExceptionTest extends AccountException {

	Map<Integer, User> usersMap;
	Map<Integer, Ride> ridesMap;
	User user;
	User userUpdate;
	User userSentRating;
	Rating rating;
	
	@BeforeAll
	void init() {
		usersMap = DataClass.getUsersMap();
		ridesMap = DataClass.getRidesMap();
		
		user = new User(1, "Chintan", "Patel", "333-333-3334", "chintan.com", true);
		userUpdate = new User(2, "Chintan", "Patel", "333-333-3334", "chintan.com", false);
		userSentRating = new User(3, "Chintan", "Patel", "333-333-3334", "chintan.com", true);
		
		rating = new Rating(1, 1, 4, 3);
		Ride ride = new Ride();
				
		usersMap.put(1, user);
		usersMap.put(2, userUpdate);
		usersMap.put(3, userSentRating);
		ridesMap.put(1, ride);
	}
	
	@AfterAll
	void cleanUp() {
		usersMap.clear();
		ridesMap.clear();
	}
	
	@Test
	void validateCheckCreateAccount_UserFirstAndLastNameAndPhoneShouldBeValid_Successful() {
		AccountException.checkCreateAccount(user);
	}
	
	@Test
	void validateCheckActivateAccount_UserShouldExistWithValidFirstLastPhoneAndActive_Successful() {

		AccountException.checkActivateAccount(1, user);
	}
	
	@Test
	void validateCheckUpdateAccount_UserShouldExistWithValidNameAndNonActive_Successful() {
		
		AccountException.checkUpdateAccount(2, userUpdate);
	}
	
	@Test
	void validateCheckDeleteAccount_UserShouldExistInData_Successful() {
		
		AccountException.checkDeleteAccount(2);
	}
	
	@Test
	void validateCheckRateAccount_RatingShouldBeValid_Successful() {
		
		AccountException.checkRateAccount(1, rating);
	}
	
	@Test
	void testIsUserInvolvedInRide_UserShouldBeDriver_Successful() {
		
		AccountException.isUserInvolvedInRide(true, false, 1, 1);
	}
	
	@Test
	void testIsBothDriverOrRider_SenderShouldBeDriverReceiverShouldBeRider_Successful() {
		
		AccountException.isBothDriverOrRider(true, true);
	}
}
