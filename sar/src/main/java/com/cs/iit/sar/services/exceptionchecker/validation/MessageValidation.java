package com.cs.iit.sar.services.exceptionchecker.validation;

import java.util.Map;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.models.User;

public class MessageValidation {

	private static Map<Integer, User> usersMap = DataClass.getUsersMap();

	public static void validateActiveAccount(Integer aid) {
		User user = usersMap.get(aid);
		if(!user.getActive()) {
			throw new FieldDataInvalidException("This account (" + aid + ") is not active, may not create a ride.");
		}
	}
}
