package com.cs.iit.sar.services.exceptionchecker;

import com.cs.iit.sar.dto.request.JoinRequestRequest;
import com.cs.iit.sar.models.JoinRequest;
import com.cs.iit.sar.models.Message;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.services.exceptionchecker.validation.JoinRequestValidation;
import com.cs.iit.sar.services.exceptionchecker.validation.MessageValidation;
import com.cs.iit.sar.services.exceptionchecker.validation.RideValidation;

public class RideException {
		
	public static void checkCreateRide(Ride ride) {
		RideValidation.validateAid(ride.getAid());
		RideValidation.validateLocationInfo(ride.getLocationInfo());
		RideValidation.validateDateTime(ride.getDateTime());
		RideValidation.validateCarInfo(ride.getCarInfo());
		RideValidation.validateMaxPassengers(ride.getMaxPassengers());
		RideValidation.validateAmountPerPassenger(ride.getAmountPerPassenger());
	}
	
	public static void checkUpdateRide(int rid, Ride ride) {

		RideValidation.validateAid(ride.getAid());
		RideValidation.validateCreatorOfRide(ride.getAid(), rid);
		RideValidation.validateLocationInfo(ride.getLocationInfo());
		RideValidation.validateDateTime(ride.getDateTime());
		RideValidation.validateCarInfo(ride.getCarInfo());
		RideValidation.validateMaxPassengers(ride.getMaxPassengers());
		RideValidation.validateAmountPerPassenger(ride.getAmountPerPassenger());
	}
	
	public static void checkDeleteRide(int rid) {
		RideValidation.validateRid(rid);
	}
	
	public static void checkGetRide(int rid) {
		RideValidation.validateRid(rid);
	}
	
	public static void checkRequestToJoinRide(int rid, JoinRequest joinRequest) {
		RideValidation.validateRid(rid);
		RideValidation.validateAid(joinRequest.getAid());
		JoinRequestValidation.validatePassengersToJoin(joinRequest.getPassengers(), rid);
		JoinRequestValidation.validateNotNullForRideConfirmed(joinRequest.getRideConfirmed());
		JoinRequestValidation.validateNotNullForPickupPassenger(joinRequest.getPickupConfirmed());
	}
	
	public static void checkRespondToRideRequest(int rid, int jid, JoinRequestRequest patchRideRequest) {
		RideValidation.validateRid(rid);
		JoinRequestValidation.validateJid(jid);
		JoinRequestValidation.validateNullForAid(patchRideRequest.getAid());
		JoinRequestValidation.validateNullForRideConfirmed(patchRideRequest.getRideConfirmed());
		RideValidation.validateAid(patchRideRequest.getAid());
		JoinRequestValidation.validateRideCreator(rid, patchRideRequest.getAid());
	}
	
	public static void checkConfirmPickup(int rid, int jid, JoinRequestRequest confirmRidePickup) {
		RideValidation.validateRid(rid);
		JoinRequestValidation.validateJid(jid);
		JoinRequestValidation.validateNullForAid(confirmRidePickup.getAid());
		JoinRequestValidation.validatePickupConfirmed(confirmRidePickup.getPickupConfirmed());
		RideValidation.validateAid(confirmRidePickup.getAid());
		JoinRequestValidation.validateRequestor(jid, rid, confirmRidePickup.getAid());
	}
	
	public static void checkAddMessage(int rid, Message message) {
		RideValidation.validateRid(rid);
		RideValidation.validateAid(message.getAid());
		MessageValidation.validateActiveAccount(message.getAid());
	}
	
	public static void checkGetAllMessages(int rid) {
		RideValidation.validateRid(rid);
	}
	
}
