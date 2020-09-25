package com.cs.iit.project.sar.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.data.DataClass;
import com.cs.iit.project.sar.dto.mapper.JoinRequestMapper;
import com.cs.iit.project.sar.dto.mapper.MessageMapper;
import com.cs.iit.project.sar.dto.mapper.RideMapper;
import com.cs.iit.project.sar.dto.request.JoinRequestRequest;
import com.cs.iit.project.sar.dto.request.MessageRequest;
import com.cs.iit.project.sar.dto.request.RideRequest;
import com.cs.iit.project.sar.dto.response.AddMessageMidResponse;
import com.cs.iit.project.sar.dto.response.CreateRideRidResponse;
import com.cs.iit.project.sar.dto.response.JoinRequestJidResponse;
import com.cs.iit.project.sar.dto.response.MessageResponse;
import com.cs.iit.project.sar.dto.response.RideDetailResponse;
import com.cs.iit.project.sar.dto.response.RideResponse;
import com.cs.iit.project.sar.dto.response.ViewMessagesResponse;
import com.cs.iit.project.sar.dto.response.ViewRidesResponse;
import com.cs.iit.project.sar.exception.DataNotFoundException;
import com.cs.iit.project.sar.exception.FieldDataInvalidException;
import com.cs.iit.project.sar.exception.FieldDataMissingException;
import com.cs.iit.project.sar.models.JoinRequest;
import com.cs.iit.project.sar.models.Message;
import com.cs.iit.project.sar.models.Ride;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.models.ViewRides;
import com.cs.iit.project.sar.services.validation.RideValidation;
import com.cs.iit.project.sar.utilities.DateCreated;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class RideService {

	private Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	private Map<Integer, JoinRequest> joinRequestsMap = DataClass.getJoinRequestsMap();
	private Map<Integer, Message> messagesMap = DataClass.getMessagesMap();
	private Map<Integer, User> usersMap = DataClass.getUsersMap();
	
	public CreateRideRidResponse createRide(RideRequest rideRequest) {
		
		Ride ride = RideMapper.INSTANCE.fromRideRequestDto(rideRequest);
		
		if(ride.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(!usersMap.containsKey(ride.getAid())) {
			throw new FieldDataInvalidException("Invalid aid");
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
		if(!RideValidation.isLocationInfoValid(ride.getLocationInfo())) {
			if(RideValidation.getInvalidMessage() != null) {
				throw new FieldDataInvalidException(RideValidation.getInvalidMessage());
			}
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
		if(!RideValidation.isDateTimeValid(ride.getDateTime())) {
			String invalidMsg = RideValidation.getInvalidMessage();
			if(invalidMsg != null) {
				throw new FieldDataInvalidException(invalidMsg);
			}
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
		if(!RideValidation.isCarInfoValid(ride.getCarInfo())) {
			String invalidMsg = RideValidation.getInvalidMessage();
			if(invalidMsg != null) {
				throw new FieldDataInvalidException(invalidMsg);
			}
		}
		if(ride.getMaxPassengers() == null) {
			throw new NullPointerException("The max_passengers appears to be uninitialized");
		}
		if(!RideValidation.isMaxPassengersValid(ride.getMaxPassengers())) {
			throw new FieldDataInvalidException("Invalid max_passengers");
		}
		if(ride.getAmountPerPassenger() == null) {
			throw new NullPointerException("The amount_per_passenger appears to be uninitialized");
		}
		if(!RideValidation.isAmountPerPassengerValid(ride.getAmountPerPassenger())) {
			throw new FieldDataInvalidException("Invalid amount_per_passenger");
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
		return RideMapper.INSTANCE.toCreateRideResponseDto(ride);
	}

	public void updateRide(int rid, RideRequest rideRequest) {
		
		Ride ride = RideMapper.INSTANCE.fromRideRequestDto(rideRequest);
		Ride existingRide = ridesMap.get(rid);
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		if(ride.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(!usersMap.containsKey(ride.getAid())) {
			throw new FieldDataInvalidException("Invalid aid");
		}
		if(ride.getAid() != existingRide.getAid()) {
			throw new FieldDataInvalidException("Only the creator of the ride may change it");
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
		if(!RideValidation.isLocationInfoValid(ride.getLocationInfo())) {
			if(RideValidation.getInvalidMessage() != null) {
				throw new FieldDataInvalidException(RideValidation.getInvalidMessage());
			}
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
		if(!RideValidation.isDateTimeValid(ride.getDateTime())) {
			String invalidMsg = RideValidation.getInvalidMessage();
			if(invalidMsg != null) {
				throw new FieldDataInvalidException(invalidMsg);
			}
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
		if(!RideValidation.isCarInfoValid(ride.getCarInfo())) {
			String invalidMsg = RideValidation.getInvalidMessage();
			if(invalidMsg != null) {
				throw new FieldDataInvalidException(invalidMsg);
			}
		}
		if(ride.getMaxPassengers() == null) {
			throw new NullPointerException("The max_passengers appears to be uninitialized");
		}
		if(!RideValidation.isMaxPassengersValid(ride.getMaxPassengers())) {
			throw new FieldDataInvalidException("Invalid max_passengers");
		}
		if(ride.getAmountPerPassenger() == null) {
			throw new NullPointerException("The amount_per_passenger appears to be uninitialized");
		}
		if(!RideValidation.isAmountPerPassengerValid(ride.getAmountPerPassenger())) {
			throw new FieldDataInvalidException("Invalid amount_per_passenger");
		}
		if(ride.getConditions() == null) {
			throw new NullPointerException("The conditions appears to be uninitialized");
		}
		if(ride.getConditions().isBlank()) {
			throw new FieldDataMissingException("The conditions appears to be missing");
		}
		
		ridesMap.put(rid, ride);
		
	}

	public void deleteRide(int rid) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		ridesMap.remove(rid);
	}

	public List<RideResponse> getAllRides() {
		ViewRides viewRides = new ViewRides();
		List<Ride> rides = new ArrayList<>(ridesMap.values());
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
		
		System.out.println("Junior 1");
		if(!ridesMap.containsKey(rid)) {
			System.out.println("Junior 2");
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		System.out.println("Junior 3");
		Ride ride = ridesMap.get(rid);
		if(!usersMap.containsKey(ride.getAid())) {
			System.out.println("Junior 4");
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		System.out.println("Junior 5");
		User user = usersMap.get(ride.getAid());
		System.out.println("Junior 6");
		return RideMapper.INSTANCE.toRideDetailDto(ride, user);
	}
	
	public JoinRequestJidResponse requestToJoinRide(int rid, JoinRequestRequest joinRequestReq) {
		
		if(joinRequestReq.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("Ride id is invalid");
		}
		if(!usersMap.containsKey(joinRequestReq.getAid())) {
			throw new FieldDataInvalidException("Invalid account id");
		}
		
		Ride ride = ridesMap.get(rid);
		if(joinRequestReq.getPassengers() == null) {
			throw new NullPointerException("The passengers appears to be uninitialized");
		}
		if(!RideValidation.isPassengersToJoinValid(joinRequestReq.getPassengers(), ride.getMaxPassengers())) {
			throw new FieldDataInvalidException("Invalid passengers amount");
		}
		if(joinRequestReq.getRideConfirmed() != null) {
			throw new FieldDataInvalidException("Invalid value for ride_confirmed");
		}
		if(joinRequestReq.getPickupConfirmed() != null) {
			throw new FieldDataInvalidException("Invalid value for pickup_confirmed");
		}
		
		int jid = UniqueIdGenerator.generateUniqueID();
		JoinRequest joinRequest = JoinRequestMapper.INSTANCE.fromJoinRequestDto(joinRequestReq);
		
		joinRequest.setRid(rid);
		joinRequest.setJid(jid);
		
		joinRequestsMap.put(jid, joinRequest);
		
		if(ride.getJoinRequests() == null) {
			Map<Integer, JoinRequest> rideJoinRequests = new HashMap<Integer, JoinRequest>();
			rideJoinRequests.put(jid, joinRequest);
			ride.setJoinRequests(rideJoinRequests);
			ridesMap.put(rid, ride);
		} else {
			ride.getJoinRequests().put(jid, joinRequest);
		}
		return JoinRequestMapper.INSTANCE.toJoinResponseDto(joinRequest);	
	}
	
	public void respondToRideRequest(int rid, int jid, JoinRequestRequest patchRideRequestConfirm) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("Ride does not exist");
		}
		if(!joinRequestsMap.containsKey(jid)) {
			throw new DataNotFoundException("Join Request does not exist");
		}
		if(!usersMap.containsKey(patchRideRequestConfirm.getAid())) {
			throw new DataNotFoundException("The account does not exist");
		}
		int aid = patchRideRequestConfirm.getAid();
		Ride ride = ridesMap.get(rid);
		if(ride.getAid() != aid) {
			throw new FieldDataInvalidException("This account (" + aid + ") didn't create the ride (" + rid + ")");
		}
		if(patchRideRequestConfirm.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		
		JoinRequest joinRequest = joinRequestsMap.get(jid);
		joinRequest.setRideConfirmed(patchRideRequestConfirm.getRideConfirmed());
		joinRequestsMap.put(jid, joinRequest);
		ride.getJoinRequests().put(jid, joinRequest);
	}
	
	public void confirmPassengerPickup(int rid, int  jid, JoinRequestRequest confirmRidePickup) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("Ride does not exist");
		}
		if(!joinRequestsMap.containsKey(jid)) {
			throw new DataNotFoundException("Join Request does not exist");
		}
		if(!usersMap.containsKey(confirmRidePickup.getAid())) {
			throw new DataNotFoundException("The account does not exist");
		}
		int aid = confirmRidePickup.getAid();
		JoinRequest joinRequest = joinRequestsMap.get(jid);
		Ride ride = ridesMap.get(rid);
		if(joinRequest.getAid() != aid) {
			throw new FieldDataInvalidException("This account (" + aid + ") has not requested to join this ride (" + rid + ")");
		}
		if(confirmRidePickup.getAid() == null) {
			throw new NullPointerException("The aid appears to be uninitialized");
		}
		if(confirmRidePickup.getPickupConfirmed() == false) {
			throw new FieldDataInvalidException("Invalid value for pickup_confirmed");
		}
		
		User rider = usersMap.get(aid);
		User driver = usersMap.get(ride.getAid());
		int totalRides = rider.getTotalRidesAsRider();
		rider.setTotalRidesAsRider(totalRides + 1);
		totalRides = driver.getTotalRidesAsDriver();
		driver.setTotalRidesAsDriver(totalRides+1);
		System.out.println(driver.getTotalRidesAsDriver() + "  " + rider.getTotalRidesAsRider());
		
		joinRequest.setPickupConfirmed(confirmRidePickup.getPickupConfirmed());
		joinRequestsMap.put(jid, joinRequest);
		if(ride.getRiders() == null) {
			System.out.println("Riders null");
			Map<Integer, User> riders = new HashMap<>();
			riders.put(aid, rider);
			ride.setRiders(riders);
		} else {
			System.out.println("Riders not null");
			ride.getRiders().put(aid, rider);
		}
		ride.getJoinRequests().put(jid, joinRequest);
		ride.setTripCompleted(true);
	}
	
	public AddMessageMidResponse addMessage(int rid, MessageRequest messageRequest) {
		
		Message message = MessageMapper.INSTANCE.fromMessageDto(messageRequest);
		
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
		if(!usersMap.containsKey(message.getAid())) {
			throw new DataNotFoundException("User does not exist");
		}
		User user = usersMap.get(message.getAid());
		if(!user.getActive()) {
			throw new FieldDataInvalidException("Account is not active");
		}
		
		int mid = UniqueIdGenerator.generateUniqueID();
		message.setMid(mid);
		message.setDate(DateCreated.getDateOrTime("dd-MMM-yyyy, HH:mm:ss"));
		
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
		return MessageMapper.INSTANCE.toMessageMidDto(message);
	}

	public List<MessageResponse> getAllMessages(int rid) {
		
		if(!ridesMap.containsKey(rid)) {
			throw new DataNotFoundException("The ride identified by [" + rid + "] doesn't exist");
		}
		Ride ride = ridesMap.get(rid);
		ViewMessagesResponse messagesResponse = MessageMapper.INSTANCE.toAllMessagesDto(ride);
		return new ArrayList<>(messagesResponse.getMessages());
	}
	
	public List<RideResponse> searchFromToDate(String from, String to, String date) {
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
	
	public List<RideResponse> searchFromTo(String from, String to) {
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
	
	public List<RideResponse> searchFromDate(String from, String date) {
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
	
	public List<RideResponse> searchToDate(String to, String date) {
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
	
	public List<RideResponse> searchFrom(String from) {
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

	public List<RideResponse> searchTo(String to) {
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
	
	public List<RideResponse> searchDate(String date) {
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
