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
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class RideRepository {

	static Map<Integer, Ride> ridesMap = new HashMap<Integer, Ride>();
	static Map<Integer, JoinRequest> joinRequestsMap = new HashMap<Integer, JoinRequest>();
	static Map<Integer, Message> messagesMap = new HashMap<Integer, Message>();
	
	public int createRide(Ride ride) {
		int rid = UniqueIdGenerator.generateUniqueID();
		ride.setRid(rid);
		ridesMap.put(rid, ride);
		return rid;
	}

	public void updateRide(int rid, Ride ride) {
		if(ridesMap.containsKey(rid)) {
			ridesMap.put(rid, ride);
		}
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
	
	public List<Ride> searchRides(String from, String to, String date) {
		if(!from.isBlank()) {
			if(!to.isBlank()) {
				if(!date.isBlank()) {
					return searchFromToDate(from, to, date);
				}
				return searchFromTo(from, to);
			}
			if(!date.isBlank()) {
				return searchFromDate(from, date);
			}
			return searchFrom(from);
		}
		if(!to.isBlank()) {
			if(!date.isBlank()) {
				return searchToDate(to, date);
			}
			return searchTo(to);
		}
		return searchDate(date);
	}	

	public int requesetToJoinRide(int rid, JoinRequest joinRequest) {
		int jid = UniqueIdGenerator.generateUniqueID();
		joinRequest.setJid(jid);
		System.out.println("Hello before!");
		joinRequestsMap.put(jid, joinRequest);
		System.out.println("Hello after!");
		Ride ride = ridesMap.get(rid);
		if(ride.getJoinRequests() == null) {
			List<JoinRequest> rideJoinRequests = new ArrayList<JoinRequest>();
			rideJoinRequests.add(joinRequest);
			ride.setJoinRequests(rideJoinRequests);
			ridesMap.put(rid, ride);
		} else {
			ride.getJoinRequests().add(joinRequest);
		}
		return jid;	
	}

	public int addMessage(int rid, Message message) {
		int mid = UniqueIdGenerator.generateUniqueID();
		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		message.setMid(mid);
		message.setDate(date);
		messagesMap.put(mid, message);
		Ride ride = ridesMap.get(rid);
		if(ride.getMessages() == null) {
			List<Message> rideMessages = new ArrayList<Message>();
			rideMessages.add(message);
			ride.setMessages(rideMessages);
			ridesMap.put(rid, ride);
		} else {
			ride.getMessages().add(message);
		}
		return mid;
	}

	public List<Message> getAllMessages(int rid) {
		Ride ride = ridesMap.get(rid);
		return ride.getMessages();
	}
	
	public List<Ride> searchFromToDate(String from, String to, String date) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideFrom = currentRide.getLocationInfo().getFrom_city();
			String currentRideTo = currentRide.getLocationInfo().getTo_city();
			String currentRideDate = currentRide.getDateTime().getDate();
			if(from.equalsIgnoreCase(currentRideFrom) &&
					to.equalsIgnoreCase(currentRideTo) &&
					date.equalsIgnoreCase(currentRideDate)) {
				matchedRides.add(currentRide);
			}
		}
		return matchedRides;
	}
	
	public List<Ride> searchFromTo(String from, String to) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideFrom = currentRide.getLocationInfo().getFrom_city();
			String currentRideTo = currentRide.getLocationInfo().getTo_city();
			if(from.equalsIgnoreCase(currentRideFrom) &&
					to.equalsIgnoreCase(currentRideTo)) {
				matchedRides.add(currentRide);
			}
		}
		return matchedRides;
	}
	
	public List<Ride> searchFromDate(String from, String date) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideFrom = currentRide.getLocationInfo().getFrom_city();
			String currentRideDate = currentRide.getDateTime().getDate();
			if(from.equalsIgnoreCase(currentRideFrom) &&
					date.equalsIgnoreCase(currentRideDate)) {
				matchedRides.add(currentRide);
			}
		}
		return matchedRides;
	}
	
	public List<Ride> searchToDate(String to, String date) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideTo = currentRide.getLocationInfo().getTo_city();
			String currentRideDate = currentRide.getDateTime().getDate();
			if(to.equalsIgnoreCase(currentRideTo) &&
					date.equalsIgnoreCase(currentRideDate)) {
				matchedRides.add(currentRide);
			}
		}
		return matchedRides;
	}
	
	public List<Ride> searchFrom(String from) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideFrom = currentRide.getLocationInfo().getFrom_city();
			if(from.equalsIgnoreCase(currentRideFrom)) {
				matchedRides.add(currentRide);
			}
		}
		return matchedRides;
	}

	public List<Ride> searchTo(String to) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideTo = currentRide.getLocationInfo().getTo_city();
			if(to.equalsIgnoreCase(currentRideTo)) {
				matchedRides.add(currentRide);
			}
		}
		return matchedRides;
	}
	
	public List<Ride> searchDate(String date) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideDate = currentRide.getDateTime().getDate();
			if(date.equalsIgnoreCase(currentRideDate)) {
				matchedRides.add(currentRide);
			}
		}
		return matchedRides;
	}

}
