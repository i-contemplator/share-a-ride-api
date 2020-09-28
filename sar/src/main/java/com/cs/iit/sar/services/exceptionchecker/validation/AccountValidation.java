package com.cs.iit.sar.services.exceptionchecker.validation;

import java.util.Map;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.DataNotFoundException;
import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.models.User;

public class AccountValidation {
	
	private static Map<Integer, User> usersMap = DataClass.getUsersMap();
	
	public static void validateAid(int aid) {
		if(!usersMap.containsKey(aid)) {
			throw new DataNotFoundException("The account identified by [" + aid + "] doesn't exist");
		}
	}
	
	public static void validateName(String name, String invalidMsg) {
		char[] charArr = name.toCharArray();
		for(Character c : charArr) {
			if(!Character.isLetter(c)) {
				throw new FieldDataInvalidException(invalidMsg);
			}
		}
	}
	
	public static void validatePhoneNumber(String phone) {
		String phoneRegex = "\\d{3}-\\d{3}-\\d{4}";
		if(!phone.matches(phoneRegex)) {
			throw new FieldDataInvalidException("Invalid phone number");
		}
	}
	
	public static void validateActive(Boolean isActive) {
		if(isActive != true) {
			throw new FieldDataInvalidException("Invalid value for is_active");
		}
	}
	
	public static void validateActiveWhenUpdating(Boolean isActive) {
		if(isActive == true) {
			throw new FieldDataInvalidException("Invalid value for is_active");
		}
	}
}
