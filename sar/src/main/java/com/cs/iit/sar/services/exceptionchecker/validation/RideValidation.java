package com.cs.iit.sar.services.exceptionchecker.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.DataNotFoundException;
import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.models.Car;
import com.cs.iit.sar.models.DateTime;
import com.cs.iit.sar.models.LocationInfo;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

public class RideValidation {
	
	private static Map<Integer, User> usersMap = DataClass.getUsersMap();
	private static Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	
	public static void validateAid(Integer aid) {
		if(!usersMap.containsKey(aid)) {
			throw new FieldDataInvalidException("Invalid aid");
		}
	}
	
	public static void validateLocationInfo(LocationInfo locationInfo) {
		validateFromZip(locationInfo.getFromZip());
		validateToZip(locationInfo.getToZip());
	}
	
	private static void validateFromZip(String fromZip) {
		if(fromZip.length() != 5) {
			throw new FieldDataInvalidException("Invalid from_zip");
		}
	}
	
	private static void validateToZip(String toZip) {
		if(toZip.length() != 5) {
			throw new FieldDataInvalidException("Invalid to_zip");
		}
	}
	
	public static void validateDateTime(DateTime dateTime) {
		validateDate(dateTime.getDate());
		validateTime(dateTime.getTime());
	}
	
	private static void validateDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
		} catch(ParseException exception) {
			throw new FieldDataInvalidException("Invalid date");
		}
	}
	
	private static void validateTime(String time) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(time);
		} catch(ParseException exception) {
			throw new FieldDataInvalidException("Invalid time");
		}
	}
	
	public static void validateCarInfo(Car car) {
		String plateSlate = car.getPlateState();
		if(plateSlate.length() > 2) {
			throw new FieldDataInvalidException("Invalid plate_slate");
		}
	}
	
	public static void validateMaxPassengers(Integer max) {
		if(max < 0) {
			throw new FieldDataInvalidException("Invalid max_passengers");
		}
	}
	
	public static void validateAmountPerPassenger(Double amount) {
		if(amount < 0) {
			throw new FieldDataInvalidException("Invalid amount_per_passenger");
		}
	}
	
	public static void validateRid(Integer rid) {
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
	}
	
	public static void validateCreatorOfRide(Integer updatorOfRide, Integer rid) {
		Ride existingRide = ridesMap.get(rid);
		if(updatorOfRide != existingRide.getAid()) {
			throw new FieldDataInvalidException("Only the creator of the ride may change it");
		}
	}
}
