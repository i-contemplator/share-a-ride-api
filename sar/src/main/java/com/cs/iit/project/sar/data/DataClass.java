package com.cs.iit.project.sar.data;

import java.util.HashMap;
import java.util.Map;

import com.cs.iit.project.sar.models.JoinRequest;
import com.cs.iit.project.sar.models.Message;
import com.cs.iit.project.sar.models.Report;
import com.cs.iit.project.sar.models.Ride;
import com.cs.iit.project.sar.models.User;

public class DataClass {
	
	private static Map<Integer, User> usersMap = new HashMap<Integer, User>();
	private static Map<Integer, Ride> ridesMap = new HashMap<Integer, Ride>();
	private static Map<Integer, JoinRequest> joinRequestsMap = new HashMap<Integer, JoinRequest>();
	private static Map<Integer, Message> messagesMap = new HashMap<Integer, Message>();
	private static Map<Integer, Report> reportsMap = new HashMap<Integer, Report>();
	
	public static Map<Integer, User> getUsersMap() {
		return usersMap;
	}

	public static Map<Integer, Ride> getRidesMap() {
		return ridesMap;
	}

	public static Map<Integer, JoinRequest> getJoinRequestsMap() {
		return joinRequestsMap;
	}

	public static Map<Integer, Message> getMessagesMap() {
		return messagesMap;
	}
	
	public static Map<Integer, Report> getReportsMap() {
		return reportsMap;
	}

}
