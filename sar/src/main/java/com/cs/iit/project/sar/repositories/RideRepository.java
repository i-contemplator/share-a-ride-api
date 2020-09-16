package com.cs.iit.project.sar.repositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.data.DataClass;
import com.cs.iit.project.sar.exception.DataNotFoundException;
import com.cs.iit.project.sar.exception.FieldDataMissingException;
import com.cs.iit.project.sar.models.JoinRequest;
import com.cs.iit.project.sar.models.Message;
import com.cs.iit.project.sar.models.Ride;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class RideRepository {

	private Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	private Map<Integer, JoinRequest> joinRequestsMap = DataClass.getJoinRequestsMap();
	private Map<Integer, Message> messagesMap = DataClass.getMessagesMap();
	
	public int createRide(Ride ride) {
		
		if(ride.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(ride.getLocationInfo() == null) {
			throw new NullPointerException("The location_info appears to be uninitialized");
		}
		if(ride.getLocationInfo().getFromCity() == null) {
			throw new NullPointerException("The from_city appears to be uninitialized");
		}
		if(ride.getLocationInfo().getFromCity().isBlank()) {
			throw new FieldDataMissingException("The from_city appears to be missing");
		}
		if(ride.getLocationInfo().getToCity() == null) {
			throw new NullPointerException("The to_city to be uninitialized");
		}
		if(ride.getLocationInfo().getToCity().isBlank()) {
			throw new FieldDataMissingException("The to_city appears to be missing");
		}
		if(ride.getDateTime() == null) {
			throw new NullPointerException("The date_time appears to be uninitialized");
		}
		if(ride.getDateTime().getDate() == null) {
			throw new NullPointerException("The date appears to be uninitialized");
		}
		if(ride.getDateTime().getDate().isBlank()) {
			throw new FieldDataMissingException("The date appears to be missing");
		}
		if(ride.getDateTime().getTime() == null) {
			throw new NullPointerException("The time appears to be uninitialized");
		}
		if(ride.getDateTime().getTime().isBlank()) {
			throw new FieldDataMissingException("The time appears to be missing");
		}
		if(ride.getCarInfo() == null) {
			throw new NullPointerException("The car_info appears to be uninitialized");
		}
		if(ride.getCarInfo().getMake() == null) {
			throw new NullPointerException("The car make appears to be uninitialized");
		}
		if(ride.getCarInfo().getMake().isBlank()) {
			throw new FieldDataMissingException("The car make appears to be missing");
		}
		if(ride.getCarInfo().getModel() == null) {
			throw new NullPointerException("The car model appears to be uninitialized");
		}
		if(ride.getCarInfo().getModel().isBlank()) {
			throw new FieldDataMissingException("The car model appears to be missing");
		}
		if(ride.getCarInfo().getColor() == null) {
			throw new NullPointerException("The car color appears to be uninitialized");
		}
		if(ride.getCarInfo().getColor().isBlank()) {
			throw new FieldDataMissingException("The car color appears to be missing");
		}
		if(ride.getCarInfo().getPlateState() == null) {
			throw new NullPointerException("The car plate_slate appears to be uninitialized");
		}
		if(ride.getCarInfo().getPlateState().isBlank()) {
			throw new FieldDataMissingException("The car plate_slate appears to be missing");
		}
		if(ride.getCarInfo().getPlateSerial() == null) {
			throw new NullPointerException("The car plate_serial appears to be uninitialized");
		}
		if(ride.getCarInfo().getPlateSerial().isBlank()) {
			throw new FieldDataMissingException("The car plate_serial appears to be missing");
		}
		if(ride.getMaxPassengers() == null) {
			throw new NullPointerException("The max_passengers appears to be uninitialized");
		}
		if(ride.getAmountPerPassenger() == null) {
			throw new NullPointerException("The amount_per_passenger appears to be uninitialized");
		}
		if(ride.getConditions() == null) {
			throw new NullPointerException("The conditions appears to be uninitialized");
		}
		if(ride.getConditions().isBlank()) {
			throw new FieldDataMissingException("The conditions appears to be missing");
		}
		
		int rid = UniqueIdGenerator.generateUniqueID();
		ride.setRid(rid);
		ridesMap.put(rid, ride);
		return rid;
	}

	public void updateRide(int rid, Ride ride) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		if(ride.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(ride.getLocationInfo() == null) {
			throw new NullPointerException("The location_info appears to be uninitialized");
		}
		if(ride.getLocationInfo().getFromCity() == null) {
			throw new NullPointerException("The from_city appears to be uninitialized");
		}
		if(ride.getLocationInfo().getFromCity().isBlank()) {
			throw new FieldDataMissingException("The from_city appears to be missing");
		}
		if(ride.getLocationInfo().getToCity() == null) {
			throw new NullPointerException("The to_city to be uninitialized");
		}
		if(ride.getLocationInfo().getToCity().isBlank()) {
			throw new FieldDataMissingException("The to_city appears to be missing");
		}
		if(ride.getDateTime() == null) {
			throw new NullPointerException("The date_time appears to be uninitialized");
		}
		if(ride.getDateTime().getDate() == null) {
			throw new NullPointerException("The date appears to be uninitialized");
		}
		if(ride.getDateTime().getDate().isBlank()) {
			throw new FieldDataMissingException("The date appears to be missing");
		}
		if(ride.getDateTime().getTime() == null) {
			throw new NullPointerException("The time appears to be uninitialized");
		}
		if(ride.getDateTime().getTime().isBlank()) {
			throw new FieldDataMissingException("The time appears to be missing");
		}
		if(ride.getCarInfo() == null) {
			throw new NullPointerException("The car_info appears to be uninitialized");
		}
		if(ride.getCarInfo().getMake() == null) {
			throw new NullPointerException("The car make appears to be uninitialized");
		}
		if(ride.getCarInfo().getMake().isBlank()) {
			throw new FieldDataMissingException("The car make appears to be missing");
		}
		if(ride.getCarInfo().getModel() == null) {
			throw new NullPointerException("The car model appears to be uninitialized");
		}
		if(ride.getCarInfo().getModel().isBlank()) {
			throw new FieldDataMissingException("The car model appears to be missing");
		}
		if(ride.getCarInfo().getColor() == null) {
			throw new NullPointerException("The car color appears to be uninitialized");
		}
		if(ride.getCarInfo().getColor().isBlank()) {
			throw new FieldDataMissingException("The car color appears to be missing");
		}
		if(ride.getCarInfo().getPlateState() == null) {
			throw new NullPointerException("The car plate_slate appears to be uninitialized");
		}
		if(ride.getCarInfo().getPlateState().isBlank()) {
			throw new FieldDataMissingException("The car plate_slate appears to be missing");
		}
		if(ride.getCarInfo().getPlateSerial() == null) {
			throw new NullPointerException("The car plate_serial appears to be uninitialized");
		}
		if(ride.getCarInfo().getPlateSerial().isBlank()) {
			throw new FieldDataMissingException("The car plate_serial appears to be missing");
		}
		if(ride.getMaxPassengers() == null) {
			throw new NullPointerException("The max_passengers appears to be uninitialized");
		}
		if(ride.getAmountPerPassenger() == null) {
			throw new NullPointerException("The amount_per_passenger appears to be uninitialized");
		}
		if(ride.getConditions() == null) {
			throw new NullPointerException("The conditions appears to be uninitialized");
		}
		if(ride.getConditions().isBlank()) {
			throw new FieldDataMissingException("The conditions appears to be missing");
		}
		
		if(ridesMap.containsKey(rid)) {
			ridesMap.put(rid, ride);
		}
	}

	public void deleteRide(int rid) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		ridesMap.remove(rid);
	}

	public List<Ride> getAllRides() {
		return new ArrayList<Ride>(ridesMap.values());
	}

	public Ride getRide(int rid) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
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

	public int requestToJoinRide(int rid, JoinRequest joinRequest) {
		
		if(joinRequest.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(joinRequest.getPassengers() == null) {
			throw new NullPointerException("The passengers appears to be uninitialized");
		}
		
		int jid = UniqueIdGenerator.generateUniqueID();
		joinRequest.setJid(jid);
		joinRequestsMap.put(jid, joinRequest);
		Ride ride = ridesMap.get(rid);
		if(ride.getJoinRequests() == null) {
			Map<Integer, JoinRequest> rideJoinRequests = new HashMap<Integer, JoinRequest>();
			rideJoinRequests.put(jid, joinRequest);
			ride.setJoinRequests(rideJoinRequests);
			ridesMap.put(rid, ride);
		} else {
			ride.getJoinRequests().put(jid, joinRequest);
		}
		return jid;	
	}
	
	public void respondToRideRequest(int rid, int jid, JoinRequest patchRideRequestConfirm) {
		
		if(patchRideRequestConfirm.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(patchRideRequestConfirm.isRideConfirmed() == null) {
			throw new NullPointerException("The ride_confirmed appears to be uninitialized");
		}
		
		Ride ride = ridesMap.get(rid);
		JoinRequest joinRequest = joinRequestsMap.get(jid);
		joinRequest.setRideConfirmed(patchRideRequestConfirm.isRideConfirmed());
		joinRequestsMap.put(jid, joinRequest);
		ride.getJoinRequests().put(jid, joinRequest);
	}
	
	public void confirmPassengerPickup(int rid, int  jid, JoinRequest confirmRidePickup) {
		
		if(confirmRidePickup.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(confirmRidePickup.isPickupConfirmed() == null) {
			throw new NullPointerException("The pickup_confirmed appears to be uninitialized");
		}
		
		Ride ride = ridesMap.get(rid);
		JoinRequest joinRequest = joinRequestsMap.get(jid);
		joinRequest.setPickupConfirmed(confirmRidePickup.isPickupConfirmed());
		joinRequestsMap.put(jid, joinRequest);
		ride.getJoinRequests().put(jid, joinRequest);
	}
	
	public int addMessage(int rid, Message message) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		if(message.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(message.getMsg() == null) {
			throw new NullPointerException("The msg appears to be uninitialized");
		}
		if(message.getMsg().isBlank()) {
			throw new FieldDataMissingException("The msg appears to be missing");
		}
		
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
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		Ride ride = ridesMap.get(rid);
		return ride.getMessages();
	}
	
	public List<Ride> searchFromToDate(String from, String to, String date) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideFrom = currentRide.getLocationInfo().getFromCity();
			String currentRideTo = currentRide.getLocationInfo().getToCity();
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
			String currentRideFrom = currentRide.getLocationInfo().getFromCity();
			String currentRideTo = currentRide.getLocationInfo().getToCity();
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
			String currentRideFrom = currentRide.getLocationInfo().getFromCity();
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
			String currentRideTo = currentRide.getLocationInfo().getToCity();
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
			String currentRideFrom = currentRide.getLocationInfo().getFromCity();
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
			String currentRideTo = currentRide.getLocationInfo().getToCity();
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
