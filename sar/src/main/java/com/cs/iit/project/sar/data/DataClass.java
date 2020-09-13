package com.cs.iit.project.sar.data;

import java.util.HashMap;
import java.util.Map;

import com.cs.iit.project.sar.models.User;

public class DataClass {
	private static Map<Integer, User> usersMap = new HashMap<Integer, User>();

	public static Map<Integer, User> getUsersMap() {
		return usersMap;
	}

}
