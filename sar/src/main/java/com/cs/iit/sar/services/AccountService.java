package com.cs.iit.sar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cs.iit.sar.boundaryinterfaces.AccountBoundaryInterface;
import com.cs.iit.sar.boundaryinterfaces.RatingBoundaryInterface;
import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.dto.mapper.AccountMapper;
import com.cs.iit.sar.dto.mapper.RatingMapper;
import com.cs.iit.sar.dto.request.AccountRequest;
import com.cs.iit.sar.dto.request.RateAccountRequest;
import com.cs.iit.sar.dto.response.AccountResponse;
import com.cs.iit.sar.dto.response.CreateAccountAidResponse;
import com.cs.iit.sar.dto.response.RateAccountSidResponse;
import com.cs.iit.sar.dto.response.ViewAccountsResponse;
import com.cs.iit.sar.dto.response.ViewDriverRatingsResponse;
import com.cs.iit.sar.dto.response.ViewRiderRatingsResponse;
import com.cs.iit.sar.models.Rating;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.User;
import com.cs.iit.sar.models.ViewAccounts;
import com.cs.iit.sar.services.exceptionchecker.AccountException;
import com.cs.iit.sar.utilities.DateCreated;
import com.cs.iit.sar.utilities.UniqueIdGenerator;

public class AccountService implements AccountBoundaryInterface, RatingBoundaryInterface{

	private Map<Integer, User> usersMap = DataClass.getUsersMap();
	private Map<Integer, Ride> ridesMap = DataClass.getRidesMap();

	public CreateAccountAidResponse createAccount(AccountRequest userRequest) {
		User user = AccountMapper.INSTANCE.fromCreateAccountDto(userRequest);
		
		AccountException.checkCreateAccount(user);
	
		int aid = UniqueIdGenerator.generateUniqueID();
		user.setAid(aid);
		user.setDateCreated(DateCreated.getDateOrTime("dd-MMM-yyyy, HH:mm:ss"));
		
		CreateAccountAidResponse aidResponse = AccountMapper.INSTANCE.toCreateAccountDto(user);
		
		usersMap.put(aid, user);
		return aidResponse;
	}
	
	public void activateAccount(int aid, AccountRequest userRequest) {
		User user = AccountMapper.INSTANCE.fromCreateAccountDto(userRequest);
		
		AccountException.checkActivateAccount(aid, user);
		
		String dateCreated = usersMap.get(aid).getDateCreated();
		user.setDateCreated(dateCreated);
		usersMap.put(aid, user);
	}

	public void updateAccount(int aid, AccountRequest userRequest) {
		User user = AccountMapper.INSTANCE.fromCreateAccountDto(userRequest);

		AccountException.checkUpdateAccount(aid, user);
		
		String dateCreated = usersMap.get(aid).getDateCreated();
		user.setDateCreated(dateCreated);
		usersMap.put(aid, user);
	}

	public void deleteAccount(int aid) {
		AccountException.checkDeleteAccount(aid);
		
		usersMap.remove(aid);
	}

	public List<AccountResponse> viewAllAccounts() {
		ViewAccounts users = new ViewAccounts();
		users.setAccounts(new ArrayList<User>(usersMap.values()));
		ViewAccountsResponse accounts = AccountMapper.INSTANCE.toViewAccountsDto(users);
		return new ArrayList<>(accounts.getAccounts());
	}
	
	public List<AccountResponse> searchAccounts(String key) {
		List<User> userAccountsWithMatch = new ArrayList<User>();
		String newKey = key.toLowerCase();
			for(Map.Entry<Integer, User> user : usersMap.entrySet()) {
				User userValue = user.getValue();
				if(isKeyMatch(userValue, newKey)) {
					userAccountsWithMatch.add(userValue);
				}
			}
		ViewAccounts users = new ViewAccounts();
		users.setAccounts(userAccountsWithMatch);
		ViewAccountsResponse accounts = AccountMapper.INSTANCE.toViewAccountsDto(users);
		return new ArrayList<>(accounts.getAccounts());
	}
	
	boolean isKeyMatch(User user, String key) {
		key = key.toLowerCase();
		String userAid = String.valueOf(user.getAid());
		String userFN = user.getFirstName().toLowerCase();
		String userLN = user.getLastName().toLowerCase();
		String userPN = user.getPhone();
		String userPic = user.getPicture();
		if(userAid.contains(key) ||
				userFN.contains(key) ||
				userLN.contains(key) || 
				userPN.contains(key) || 
				userPic.contains(key)) {
			return true;
		} 
		return false;
	}

	public RateAccountSidResponse rateAccount(int aid, RateAccountRequest ratingRequest) {
		
		Rating rating = RatingMapper.INSTANCE.fromRateAccountRequestDto(ratingRequest);
		
		AccountException.checkRateAccount(aid, rating);
		
		rating.setAccountToRate(aid);

		boolean isSenderDriver;
		boolean isSenderRider;
		boolean isReceiverDriver;
		boolean isReceiverRider;

		User userReceiver = usersMap.get(aid);
		User userSender = usersMap.get(rating.getSentById());
				
		Ride ride = ridesMap.get(rating.getRid());
		
		isSenderDriver = isDriver(ride.getAid(), userSender.getAid());
		isReceiverDriver = isDriver(ride.getAid(), userReceiver.getAid());
		isSenderRider = isRider(ride.getRiders(), userSender.getAid());
		isReceiverRider = isRider(ride.getRiders(), userReceiver.getAid());
		
		AccountException.isUserInvolvedInRide(isSenderDriver, isSenderRider, rating.getSentById(), rating.getRid());
		AccountException.isUserInvolvedInRide(isReceiverDriver, isReceiverRider, aid, rating.getRid());
		AccountException.isBothDriverOrRider(isSenderDriver, isReceiverRider);
		
		int sid = UniqueIdGenerator.generateUniqueID();
		rating.setSid(sid);
		rating.setDate(DateCreated.getDateOrTime("dd-MMM-yyyy"));
		rating.setFirstName(userSender.getFirstName());
		if(isReceiverDriver) {
			return addRatingForDriver(userReceiver, rating);
		} else {
			return addRatingForRider(userReceiver, rating);
		}
	}
	
	boolean isDriver(Integer rideCreatorId, Integer userId) {
		if(rideCreatorId == userId) {
			return true;
		}
		return false;
	}
	
	boolean isRider(Map<Integer, User> riders, Integer userId) {
		if(riders.containsKey(userId)) {
			return true;
		}
		return false;
	}

	RateAccountSidResponse addRatingForDriver(User user, Rating rating) {
		if(user.getDriversRating().isEmpty()) {
			List<Rating> driversRating = new ArrayList<Rating>();
			driversRating.add(rating);
			user.setDriversRating(driversRating);
			usersMap.put(user.getAid(), user);
		} else {
			user.getDriversRating().add(rating);
		}
		return RatingMapper.INSTANCE.toRateAccountResponseDto(rating);
	}
	
	RateAccountSidResponse addRatingForRider(User user, Rating rating) {
		if(user.getRidersRating().isEmpty()) {
			List<Rating> ridersRating = new ArrayList<Rating>();
			ridersRating.add(rating);
			user.setRidersRating(ridersRating);
			usersMap.put(user.getAid(), user);
		} else {
			user.getRidersRating().add(rating);
		}
		return RatingMapper.INSTANCE.toRateAccountResponseDto(rating);
	}
	
	public ViewDriverRatingsResponse viewDriverRatings(int aid) {
		User user = usersMap.get(aid);
		return RatingMapper.INSTANCE.toViewDriverRatingsDto(user);
	}
	
	public ViewRiderRatingsResponse viewRiderRatings(int aid) {
		User user = usersMap.get(aid);
		return RatingMapper.INSTANCE.toViewRiderRatingsDto(user);
	}
	
}
