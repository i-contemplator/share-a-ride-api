package com.cs.iit.sar.services.exceptionchecker;

import com.cs.iit.sar.models.Rating;
import com.cs.iit.sar.models.User;
import com.cs.iit.sar.services.exceptionchecker.validation.AccountValidation;
import com.cs.iit.sar.services.exceptionchecker.validation.RatingValidation;

public class AccountException {
	
	public static void checkCreateAccount(User user) {
		AccountValidation.validateName(user.getFirstName(), "Invalid first name");
		AccountValidation.validateName(user.getLastName(), "Invalid last name");
		AccountValidation.validatePhoneNumber(user.getPhone());
	}
	
	public static void checkActivateAccount(int aid, User user) {
		AccountValidation.validateAid(aid);
		AccountValidation.validateName(user.getFirstName(), "Invalid first name");
		AccountValidation.validateName(user.getLastName(), "Invalid last name");
		AccountValidation.validatePhoneNumber(user.getPhone());
		AccountValidation.validateActive(user.getActive());
	}
	
	public static void checkUpdateAccount(int aid, User user) {
		AccountValidation.validateAid(aid);
		AccountValidation.validateActiveWhenUpdating(user.getActive());
		AccountValidation.validateName(user.getFirstName(), "Invalid first name");
		AccountValidation.validateName(user.getLastName(), "Invalid last name");
		AccountValidation.validatePhoneNumber(user.getPhone());
	}
	
	public static void checkDeleteAccount(int aid) {
		AccountValidation.validateAid(aid);
	}
	
	public static void checkRateAccount(int aid, Rating rating) {
		RatingValidation.validateRateSameAccount(aid, rating.getSentById());
		RatingValidation.validateRid(rating.getRid());
		RatingValidation.validateAid(aid);
		RatingValidation.validateSentById(rating.getSentById());
		RatingValidation.validateRatingAmount(rating.getRating());
	}
	
	public static void isUserInvolvedInRide(boolean isDriver, boolean isRider, Integer userId, Integer rid) {
		RatingValidation.validateUserPartOfRide(isDriver, isRider, userId, rid);
	}
	
	public static void isBothDriverOrRider(boolean isSenderDriver, boolean isReceiverRider) {
		RatingValidation.validateBothDriverOrRider(isSenderDriver, isReceiverRider);
	}
}
