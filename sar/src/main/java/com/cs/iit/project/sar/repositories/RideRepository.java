package com.cs.iit.project.sar.repositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.models.JoinRequest;
import com.cs.iit.project.sar.models.Message;
import com.cs.iit.project.sar.models.Ride;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class RideRepository {

	static Map<Integer, Ride> ridesMap = new HashMap<Integer, Ride>();
	static Map<Integer, JoinRequest> joinRequestsMap = new HashMap<Integer, JoinRequest>();
	static Map<Integer, Message> messagesMap = new HashMap<Integer, Message>();
	
	public int createRide(Ride ride) {
		for(User u: users) {
			if ()
		}
		int rid;
		rid = UniqueIdGenerator.generateUniqueID();
		ride.setRid(rid);
		ridesMap.put(rid, ride);
		return rid;
	}

	public void updateRide(int rid, Ride ride) {
		ridesMap.put(rid, ride);
	}

	public void deleteRide(int rid) {
		ridesMap.remove(rid);
	}

	public List<Ride> getAllRides() {
		return new ArrayList<Ride>(ridesMap.values());
	}

	public Ride getRide(int rid) {
		return ridesMap.get(rid);
	}

	public int requesetToJoinRide(int rid, JoinRequest joinRequest) {
		int jid;
		jid = UniqueIdGenerator.generateUniqueID();
		joinRequest.setJid(jid);
		joinRequestsMap.put(jid, joinRequest);
		Ride ride = ridesMap.get(rid);
		ride.setJoinRequests(new ArrayList<JoinRequest>(joinRequestsMap.values()));
		ridesMap.put(rid, ride);
		return jid;	
	}

	public int addMessage(int rid, Message message) {
		int mid;
		mid = UniqueIdGenerator.generateUniqueID();
		message.setMid(mid);
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		message.setDate(date);
		messagesMap.put(mid, message);
		Ride ride = ridesMap.get(rid);
		ride.setMessages(new ArrayList<Message>(messagesMap.values()));
		ridesMap.put(rid, ride);
		return mid;
	}

	public List<Message> getAllMessages(int rid) {
		Ride ride = ridesMap.get(rid);
		return ride.getMessages();
	}

}
