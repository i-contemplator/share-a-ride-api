package com.cs.iit.project.sar.repositories.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.cs.iit.project.sar.models.Car;
import com.cs.iit.project.sar.models.DateTime;
import com.cs.iit.project.sar.models.LocationInfo;

public class RideValidation {
	
	private static String invalidMsg;
	
	public static boolean isLocationInfoValid(LocationInfo locationInfo) {
		return true;
	}
	
	public static boolean isDateTimeValid(DateTime dateTime) {
		String date = dateTime.getDate();
		String time = dateTime.getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		
		try {
			dateFormat.parse(date);
		} catch(ParseException exception) {
			invalidMsg = "Invalid date";
		}
		dateFormat = new SimpleDateFormat("HH:mm");
		try {
			dateFormat.parse(time);
		} catch(ParseException exception) {
			invalidMsg = "Invalid time";
		}
		return true;
	}
	
	public static boolean isCarInfoValid(Car car) {
		String plateSlate = car.getPlateState();
		if(plateSlate.length() > 2) {
			return false;
		}
		return true;
	}
	
	public static boolean isMaxPassengersValid(Integer max) {
		if(max >= 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isAmountPerPassengerValid(Double amount) {
		if(amount >= 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isPassengersToJoinValid(Integer passengers, Integer max) {
		if(passengers >= 0 && passengers <= max) {
			return true;
		}
		return false;
	}
	
	public static String getInvalidMessage() {
		return invalidMsg;
	}

}
