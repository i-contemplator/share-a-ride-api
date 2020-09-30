package com.cs.iit.sar.data;

import java.util.HashMap;
import java.util.Map;

import com.cs.iit.sar.models.JoinRequest;
import com.cs.iit.sar.models.Message;
import com.cs.iit.sar.models.Report;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;

import lombok.Getter;
//dadfaf
public class DataClass {
	@Getter
	private static Map<Integer, User> usersMap = new HashMap<Integer, User>();
	@Getter
	private static Map<Integer, Ride> ridesMap = new HashMap<Integer, Ride>();
	@Getter
	private static Map<Integer, JoinRequest> joinRequestsMap = new HashMap<Integer, JoinRequest>();
	@Getter
	private static Map<Integer, Message> messagesMap = new HashMap<Integer, Message>();
	@Getter
	private static Map<Integer, Report> reportsMap = new HashMap<Integer, Report>();
}
