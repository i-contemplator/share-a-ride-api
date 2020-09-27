package com.cs.iit.sar.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.iit.sar.boundaryinterfaces.JoinRequestBoundaryInterface;
import com.cs.iit.sar.boundaryinterfaces.MessageBoundaryInterface;
import com.cs.iit.sar.boundaryinterfaces.RideBoundaryInterface;
import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.dto.mapper.JoinRequestMapper;
import com.cs.iit.sar.dto.mapper.MessageMapper;
import com.cs.iit.sar.dto.mapper.RideMapper;
import com.cs.iit.sar.dto.request.JoinRequestRequest;
import com.cs.iit.sar.dto.request.MessageRequest;
import com.cs.iit.sar.dto.request.RideRequest;
import com.cs.iit.sar.dto.response.AddMessageMidResponse;
import com.cs.iit.sar.dto.response.CreateRideRidResponse;
import com.cs.iit.sar.dto.response.JoinRequestJidResponse;
import com.cs.iit.sar.dto.response.MessageResponse;
import com.cs.iit.sar.dto.response.RideDetailResponse;
import com.cs.iit.sar.dto.response.RideResponse;
import com.cs.iit.sar.dto.response.ViewMessagesResponse;
import com.cs.iit.sar.dto.response.ViewRidesResponse;
import com.cs.iit.sar.models.JoinRequest;
import com.cs.iit.sar.models.Message;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;
import com.cs.iit.sar.models.ViewRides;
import com.cs.iit.sar.services.exceptionchecker.RideException;
import com.cs.iit.sar.utilities.DateCreated;
import com.cs.iit.sar.utilities.UniqueIdGenerator;

public class RideService implements RideBoundaryInterface, 
									JoinRequestBoundaryInterface, 
									MessageBoundaryInterface {

	private Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	private Map<Integer, JoinRequest> joinRequestsMap = DataClass.getJoinRequestsMap();
	private Map<Integer, Message> messagesMap = DataClass.getMessagesMap();
	private Map<Integer, User> usersMap = DataClass.getUsersMap();
	
	public CreateRideRidResponse createRide(RideRequest rideRequest) {
		Ride ride = RideMapper.INSTANCE.fromRideRequestDto(rideRequest);

		RideException.checkCreateRide(ride);
		
		int rid = UniqueIdGenerator.generateUniqueID();
		ride.setRid(rid);
		
		ridesMap.put(rid, ride);
		return RideMapper.INSTANCE.toCreateRideResponseDto(ride);
	}

	public void updateRide(int rid, RideRequest rideRequest) {
		Ride ride = RideMapper.INSTANCE.fromRideRequestDto(rideRequest);
		
		RideException.checkUpdateRide(rid, ride);
		
		ridesMap.put(rid, ride);
	}

	public void deleteRide(int rid) {
		RideException.checkDeleteRide(rid);
		ridesMap.remove(rid);
	}

	public List<RideResponse> getAllRides() {
		List<Ride> rides = new ArrayList<>(ridesMap.values());

		ViewRides viewRides = new ViewRides();
		viewRides.setRides(rides);
		
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(viewRides);
		return new ArrayList<>(ridesResponse.getRides());
	}
	
	public List<RideResponse> searchRides(String from, String to, String date) {
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
	
	public RideDetailResponse getRide(int rid) {
		RideException.checkGetRide(rid);
		
		Ride ride = ridesMap.get(rid);
		User user = usersMap.get(ride.getAid());
		return RideMapper.INSTANCE.toRideDetailDto(ride, user);
	}
	
	public JoinRequestJidResponse requestToJoinRide(int rid, JoinRequestRequest joinRequestReq) {
		
		JoinRequest joinRequest = JoinRequestMapper.INSTANCE.fromJoinRequestDto(joinRequestReq);

		RideException.checkRequestToJoinRide(rid, joinRequest);
		
		int jid = UniqueIdGenerator.generateUniqueID();
		
		joinRequest.setRid(rid);
		joinRequest.setJid(jid);
		
		joinRequestsMap.put(jid, joinRequest);
		
		Ride ride = ridesMap.get(rid);

		return addRequestToRide(ride, joinRequest);	
	}
	
	private JoinRequestJidResponse addRequestToRide(Ride ride, JoinRequest joinRequest) {
		if(ride.getJoinRequests() == null) {
			Map<Integer, JoinRequest> rideJoinRequests = new HashMap<Integer, JoinRequest>();
			rideJoinRequests.put(joinRequest.getJid(), joinRequest);
			ride.setJoinRequests(rideJoinRequests);
			ridesMap.put(ride.getRid(), ride);
		} else {
			ride.getJoinRequests().put(joinRequest.getJid(), joinRequest);
		}
		return JoinRequestMapper.INSTANCE.toJoinResponseDto(joinRequest);	
	}
	
	public void respondToRideRequest(int rid, int jid, JoinRequestRequest patchRideRequestConfirm) {
		RideException.checkRespondToRideRequest(rid, jid, patchRideRequestConfirm);
		
		JoinRequest joinRequest = joinRequestsMap.get(jid);
		joinRequest.setRideConfirmed(patchRideRequestConfirm.getRideConfirmed());
		joinRequestsMap.put(jid, joinRequest);
		
		Ride ride = ridesMap.get(rid);
		ride.getJoinRequests().put(jid, joinRequest);
	}
	
	public void confirmPassengerPickup(int rid, int  jid, JoinRequestRequest confirmRidePickup) {
		RideException.checkConfirmPickup(rid, jid, confirmRidePickup);
		
		int aid = confirmRidePickup.getAid();
		
		JoinRequest joinRequest = joinRequestsMap.get(jid);
		User rider = usersMap.get(aid);
		Ride ride = ridesMap.get(rid);
		User driver = usersMap.get(ride.getAid());
		
		int totalRides = rider.getTotalRidesAsRider();
		rider.setTotalRidesAsRider(++totalRides);
		
		totalRides = driver.getTotalRidesAsDriver();
		driver.setTotalRidesAsDriver(++totalRides);
		
		joinRequest.setPickupConfirmed(confirmRidePickup.getPickupConfirmed());
		joinRequestsMap.put(jid, joinRequest);
		
		addRidersToRide(ride, rider);
		
		ride.getJoinRequests().put(jid, joinRequest);
		ride.setTripCompleted(true);
	}
	
	private void addRidersToRide(Ride ride, User rider) {
		if(ride.getRiders() == null) {
			Map<Integer, User> riders = new HashMap<>();
			riders.put(rider.getAid(), rider);
			ride.setRiders(riders);
			ridesMap.put(ride.getRid(), ride);
		} else {
			ride.getRiders().put(rider.getAid(), rider);
		}
	}
	
	public AddMessageMidResponse addMessage(int rid, MessageRequest messageRequest) {
		Message message = MessageMapper.INSTANCE.fromMessageDto(messageRequest);

		RideException.checkAddMessage(rid, message);
		
		int mid = UniqueIdGenerator.generateUniqueID();
		
		message.setMid(mid);
		message.setDate(DateCreated.getDateOrTime("dd-MMM-yyyy, HH:mm:ss"));
		
		messagesMap.put(mid, message);
		Ride ride = ridesMap.get(rid);
		
		return addMessageToRide(ride, message);
	}
	
	private AddMessageMidResponse addMessageToRide(Ride ride, Message message) {
		if(ride.getMessages() == null) {
			List<Message> rideMessages = new ArrayList<Message>();
			rideMessages.add(message);
			ride.setMessages(rideMessages);
			ridesMap.put(ride.getRid(), ride);
		} else {
			ride.getMessages().add(message);
		}
		return MessageMapper.INSTANCE.toMessageMidDto(message);
	}

	public List<MessageResponse> getAllMessages(int rid) {
		RideException.checkGetAllMessages(rid);
		
		Ride ride = ridesMap.get(rid);
		ViewMessagesResponse messagesResponse = MessageMapper.INSTANCE.toAllMessagesDto(ride);
		return new ArrayList<>(messagesResponse.getMessages());
	}
	
	private List<RideResponse> searchFromToDate(String from, String to, String date) {
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
		ViewRides rides = new ViewRides();
		rides.setRides(matchedRides);
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(rides);
		return new ArrayList<>(ridesResponse.getRides());
	}
	
	private List<RideResponse> searchFromTo(String from, String to) {
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
		ViewRides rides = new ViewRides();
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(rides);
		return new ArrayList<>(ridesResponse.getRides());
	}
	
	private List<RideResponse> searchFromDate(String from, String date) {
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
		ViewRides rides = new ViewRides();
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(rides);
		return new ArrayList<>(ridesResponse.getRides());
	}
	
	private List<RideResponse> searchToDate(String to, String date) {
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
		ViewRides rides = new ViewRides();
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(rides);
		return new ArrayList<>(ridesResponse.getRides());
	}
	
	private List<RideResponse> searchFrom(String from) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideFrom = currentRide.getLocationInfo().getFromCity();
			if(from.equalsIgnoreCase(currentRideFrom)) {
				matchedRides.add(currentRide);
			}
		}
		ViewRides rides = new ViewRides();
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(rides);
		return new ArrayList<>(ridesResponse.getRides());
	}

	private List<RideResponse> searchTo(String to) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideTo = currentRide.getLocationInfo().getToCity();
			if(to.equalsIgnoreCase(currentRideTo)) {
				matchedRides.add(currentRide);
			}
		}
		ViewRides rides = new ViewRides();
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(rides);
		return new ArrayList<>(ridesResponse.getRides());
	}
	
	private List<RideResponse> searchDate(String date) {
		List<Ride> matchedRides = new ArrayList<Ride>();
		for(Map.Entry<Integer, Ride> ride : ridesMap.entrySet()) {
			Ride currentRide = ride.getValue();
			String currentRideDate = currentRide.getDateTime().getDate();
			if(date.equalsIgnoreCase(currentRideDate)) {
				matchedRides.add(currentRide);
			}
		}
		ViewRides rides = new ViewRides();
		ViewRidesResponse ridesResponse = RideMapper.INSTANCE.toViewRidesDto(rides);
		return new ArrayList<>(ridesResponse.getRides());
	}

}
