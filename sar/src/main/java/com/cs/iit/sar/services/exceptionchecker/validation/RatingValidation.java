package com.cs.iit.sar.services.exceptionchecker.validation;

import java.util.Map;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

public class RatingValidation {

	private static Map<Integer, User> usersMap = DataClass.getUsersMap();
	private static Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	
	
	public static void validateRateSameAccount(int aid, Integer sentById) {
		if(sentById == aid) {
			throw new FieldDataInvalidException("Cannot rate the same account");
		}
	}
	
	public static void validateRid(Integer rid) {
		if(!ridesMap.containsKey(rid)) {
			throw new FieldDataInvalidException("Invalid value for rid");
		}
	}
	
	public static void validateAid(Integer aid) {
		if(!usersMap.containsKey(aid)) {
			throw new FieldDataInvalidException("Invalid value for aid");
		}
	}
	
	public static void validateSentById(Integer sentById) {
		if(!usersMap.containsKey(sentById)) {
			throw new FieldDataInvalidException("Invalid value for sent_by_id");
		}
	}
	
	public static void validateRatingAmount(Integer rating) {
		if(rating < 0 || rating > 5) {
			throw new FieldDataInvalidException("Invalid rating amount");
		}
	}
	
	public static void validateUserPartOfRide(boolean isRider, boolean isDriver, Integer userId, Integer rid) {
		if(!isDriver && !isRider) {
			throw new FieldDataInvalidException("This account (" + userId + ") didn't create this ride (" + rid + ") nor was it a passenger");
		}
	}
	
	public static void validateBothDriver(boolean isSenderDriver, boolean isReceiverRider) {
		if((isSenderDriver == !isReceiverRider) && (isSenderDriver)) {
			throw new FieldDataInvalidException("Both users cannot be a driver. Invalid data.");
		}	
	}
	
	public static void validateBothRider(boolean isSenderDriver, boolean isReceiverRider) {
		if((isSenderDriver == !isReceiverRider) && (!isSenderDriver)) {
			throw new FieldDataInvalidException("A rider cannot rate another rider. Invalid data.");
		}
	}
}
