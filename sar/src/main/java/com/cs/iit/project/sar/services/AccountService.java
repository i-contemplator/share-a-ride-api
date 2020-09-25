package com.cs.iit.project.sar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.data.DataClass;
import com.cs.iit.project.sar.dto.mapper.RatingMapper;
import com.cs.iit.project.sar.dto.mapper.AccountMapper;
import com.cs.iit.project.sar.dto.request.AccountRequest;
import com.cs.iit.project.sar.dto.request.RateAccountRequest;
import com.cs.iit.project.sar.dto.response.AccountResponse;
import com.cs.iit.project.sar.dto.response.CreateAccountAidResponse;
import com.cs.iit.project.sar.dto.response.RateAccountSidResponse;
import com.cs.iit.project.sar.dto.response.ViewAccountsResponse;
import com.cs.iit.project.sar.dto.response.ViewDriverRatingsResponse;
import com.cs.iit.project.sar.dto.response.ViewRiderRatingsResponse;
import com.cs.iit.project.sar.exception.DataNotFoundException;
import com.cs.iit.project.sar.exception.FieldDataInvalidException;
import com.cs.iit.project.sar.exception.FieldDataMissingException;
import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.Ride;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.models.ViewAccounts;
import com.cs.iit.project.sar.services.validation.AccountValidation;
import com.cs.iit.project.sar.utilities.DateCreated;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class AccountService {

	private Map<Integer, User> usersMap = DataClass.getUsersMap();
	private Map<Integer, Ride> ridesMap = DataClass.getRidesMap();

	public CreateAccountAidResponse createAccount(AccountRequest userRequest) {
		
		if(userRequest.getFirstName() == null){
			throw new NullPointerException("The first name appears to be uninitialized.");
		}
		if(userRequest.getFirstName().isBlank()) {
			throw new FieldDataMissingException("The first name appears to be missing");
		}
		if(!AccountValidation.isNameValid(userRequest.getFirstName())) {
			throw new FieldDataInvalidException("Invalid first name");
		}
		if(userRequest.getLastName() == null){
			throw new NullPointerException("The last name appears to be uninitialized");
		}
		if(userRequest.getLastName().isBlank()) {
			throw new FieldDataMissingException("The last name appears to be missing");
		}
		if(!AccountValidation.isNameValid(userRequest.getLastName())) {
			throw new FieldDataInvalidException("Invalid last name");
		}
		if(userRequest.getPhone() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		if(userRequest.getPhone().isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		if(!AccountValidation.isPhoneValid(userRequest.getPhone())) {
			throw new FieldDataInvalidException("Invalid phone number");
		}
		if(userRequest.getPicture() == null) {
			throw new NullPointerException("The picture appears to be uninitialized");
		}
		if(userRequest.getPicture().isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
		if(userRequest.getActive() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		int aid = UniqueIdGenerator.generateUniqueID();
		userRequest.setAid(aid);
		userRequest.setDateCreated(DateCreated.getDateOrTime("dd-MMM-yyyy, HH:mm:ss"));
		
		User user = AccountMapper.INSTANCE.fromCreateAccountDto(userRequest);
		CreateAccountAidResponse aidResponse = AccountMapper.INSTANCE.toCreateAccountDto(user);
		
		usersMap.put(aid, user);
		return aidResponse;
	}
	
	public void activateAccount(int aid, AccountRequest userRequest) {
		
		if(!usersMap.containsKey(aid)) {
			throw new DataNotFoundException("The account identified by [" + aid + "] doesn't exist");
		}
		if(userRequest.getFirstName() == null){
			throw new NullPointerException("The first name appears to be uninitialized.");
		}
		if(userRequest.getFirstName().isBlank()) {
			throw new FieldDataMissingException("The first name appears to be missing");
		}
		if(!AccountValidation.isNameValid(userRequest.getFirstName())) {
			throw new FieldDataInvalidException("Invalid first name");
		}
		if(userRequest.getLastName() == null){
			throw new NullPointerException("The last name appears to be uninitialized");
		}
		if(userRequest.getLastName().isBlank()) {
			throw new FieldDataMissingException("The last name appears to be missing");
		}
		if(!AccountValidation.isNameValid(userRequest.getLastName())) {
			throw new FieldDataInvalidException("Invalid last name");
		}
		if(userRequest.getPhone() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		if(userRequest.getPhone().isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		if(!AccountValidation.isPhoneValid(userRequest.getPhone())) {
			throw new FieldDataInvalidException("Invalid phone number");
		}
		if(userRequest.getPicture() == null) {
			throw new NullPointerException("The picture appears to be uninitialized");
		}
		if(userRequest.getPicture().isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
		if(userRequest.getActive() == null) {
			throw new NullPointerException("is_active appears to be missing");
		}
		if(!AccountValidation.isAccountActive(userRequest.getActive())) {
			throw new FieldDataInvalidException("Invalid value for is_active");
		}
		User user = AccountMapper.INSTANCE.fromCreateAccountDto(userRequest);
		usersMap.put(aid, user);
	}

	public void updateAccount(int aid, AccountRequest userRequest) {
		
		if(!usersMap.containsKey(aid)) {
			throw new DataNotFoundException("The account identified by [" + aid + "] doesn't exist");
		}
		if(userRequest.getActive() == true) {
			throw new FieldDataInvalidException("Invalid value for is_active");
		}
		if(userRequest.getFirstName() == null){
			throw new NullPointerException("The first name appears to be uninitialized.");
		}
		if(userRequest.getFirstName().isBlank()) {
			throw new FieldDataMissingException("The first name appears to be missing");
		}
		if(!AccountValidation.isNameValid(userRequest.getFirstName())) {
			throw new FieldDataInvalidException("Invalid first name");
		}
		if(userRequest.getLastName() == null){
			throw new NullPointerException("The last name appears to be uninitialized");
		}
		if(!AccountValidation.isNameValid(userRequest.getLastName())) {
			throw new FieldDataInvalidException("The last name appears to be invalid.");
		}
		if(userRequest.getLastName().isBlank()) {
			throw new FieldDataMissingException("The last name appears to be missing");
		}
		if(userRequest.getPhone() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		if(userRequest.getPhone().isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		if(!AccountValidation.isPhoneValid(userRequest.getPhone())) {
			throw new FieldDataInvalidException("Invalid phone number");
		}
		if(userRequest.getPicture() == null) {
			throw new NullPointerException("The picture appears to be uninitialized");
		}
		if(userRequest.getPicture().isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
		if(userRequest.getActive() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		
		User user = AccountMapper.INSTANCE.fromCreateAccountDto(userRequest);
		usersMap.put(aid, user);
	}

	public void deleteAccount(int aid) {
		if(!usersMap.containsKey(aid)) {
			throw new DataNotFoundException("The account identified by [" + aid + "] doesn't exist");
		}
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
				String userAid = String.valueOf(userValue.getAid());
				String userFN = userValue.getFirstName().toLowerCase();
				String userLN = userValue.getLastName().toLowerCase();
				String userPN = userValue.getPhone();
				String userPic = userValue.getPicture();
				if(newKey.contains(userAid) ||
						newKey.contains(userFN) ||
						newKey.contains(userLN) || 
						newKey.contains(userPN) || 
						newKey.contains(userPic)) {
					userAccountsWithMatch.add(userValue);
				}
			}
//			for(Map.Entry<Integer, User> user : usersMap.entrySet()) {
//				String userToString = user.getValue().toString();
//				if(newKey.contains(userToString)) {
//					userAccountsWithMatch.add(user.getValue());
//				}
//			}
		ViewAccounts users = new ViewAccounts();
		users.setAccounts(userAccountsWithMatch);
		ViewAccountsResponse accounts = AccountMapper.INSTANCE.toViewAccountsDto(users);
		return new ArrayList<>(accounts.getAccounts());
	}

	public RateAccountSidResponse rateAccount(int aid, RateAccountRequest ratingRequest) {
	
		if(ratingRequest.getRid() == null) {
			throw new NullPointerException("The ride appears to be uninitialized");
		}
		if(ratingRequest.getSentById() == null) {
			throw new NullPointerException("The sent_by_id appears to be uninitialized");
		}
		if(ratingRequest.getRating() == null) {
			throw new NullPointerException("The rating appears to be uninitialized");
		}
		if(ratingRequest.getSentById() == aid) {
			throw new FieldDataInvalidException("Cannot rate the same account");
		}
		if(!ridesMap.containsKey(ratingRequest.getRid())) {
			throw new FieldDataInvalidException("Invalid value for rid");
		}
		if(!usersMap.containsKey(aid)) {
			throw new FieldDataInvalidException("Invalid value for aid");
		}
		if(!usersMap.containsKey(ratingRequest.getSentById())) {
			throw new FieldDataInvalidException("Invalid value for sent_by_id");
		}
		if(!AccountValidation.isRatingAmountValid(ratingRequest.getRating())) {
			throw new FieldDataInvalidException("Invalid rating amount");
		}

		
		boolean isSenderDriver = false;
		boolean isSenderRider = false;
		boolean isReceiverDriver = false;
		boolean isReceiverRider = false;
		
		User userReceiver = usersMap.get(aid);
		User userSender = usersMap.get(ratingRequest.getSentById());
		Ride ride = ridesMap.get(ratingRequest.getRid());
		ratingRequest.setAccountToRate(aid);

		//sender was a driver
		System.out.println(ride.getAid() + " sentbyid " + ratingRequest.getSentById() + " accounttorate " +
		ratingRequest.getAccountToRate() + "sender rider " + ride.getRiders());
		if(ride.getAid() == userSender.getAid()) {
			System.out.println("Meh 0");
			isSenderDriver = true;
		}

		//receiver was a driver
		if(ride.getAid() == userReceiver.getAid()) {
			System.out.println("Meh 1");
			isReceiverDriver = true;
		}

		//sender was a rider
		if(ride.getRiders() == null) {
			System.out.println("Meh 2");
			isSenderRider = false;
		} else if((ride.getRiders().containsKey(userSender.getAid()))) {
			System.out.println("Meh 3");
			isSenderRider = true;
		} else if(ride.getRiders().containsKey(userReceiver.getAid())) {//receiver was a rider
			System.out.println("Meh 4");
			isReceiverRider = true;
		}

		if(!isSenderRider && !isSenderDriver) {
			throw new FieldDataInvalidException("This account (" + ratingRequest.getSentById() + ") did't create this ride (" + ratingRequest.getRid() + ") nor was it a passenger");
		}
		if(!isReceiverRider && !isReceiverDriver) {
			throw new FieldDataInvalidException("This account (" + aid + ") did't create this ride (" + ratingRequest.getRid() + ") nor was it a passenger");

		}
		

		if(isSenderDriver && isReceiverRider || isSenderRider && isReceiverDriver) {
			System.out.println("Meh 5");
			int sid = UniqueIdGenerator.generateUniqueID();
			ratingRequest.setSid(sid);
			ratingRequest.setDate(DateCreated.getDateOrTime("dd-MMM-yyyy"));
			
			Rating rating = RatingMapper.INSTANCE.fromRateAccountRequestDto(ratingRequest);
			String firstName = userSender.getFirstName();
			rating.setFirstName(firstName);
			
			if(isReceiverDriver) {
				if(userReceiver.getDriversRating() == null) {
					List<Rating> driversRating = new ArrayList<Rating>();
					driversRating.add(rating);
					userReceiver.setDriversRating(driversRating);
				} else {
					userReceiver.getDriversRating().add(rating);
				}
				return RatingMapper.INSTANCE.toRateAccountResponseDto(rating);
			} else {
				if(userReceiver.getRidersRating() == null) {
					List<Rating> ridersRating = new ArrayList<Rating>();
					ridersRating.add(rating);
					userReceiver.setRidersRating(ridersRating);
				} else {
					userReceiver.getRidersRating().add(rating);
				}
				return RatingMapper.INSTANCE.toRateAccountResponseDto(rating);
			}
		} else {
			throw new FieldDataInvalidException("This account (" + ratingRequest.getSentById() + ") did't create this ride (" + ratingRequest.getRid() + ") nor was it a passenger");
		}	
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
