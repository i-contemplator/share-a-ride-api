package com.cs.iit.project.sar.repositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.data.DataClass;
import com.cs.iit.project.sar.exception.DataNotFoundException;
import com.cs.iit.project.sar.exception.FieldDataInvalidException;
import com.cs.iit.project.sar.exception.FieldDataMissingException;
import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.Ride;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.repositories.validation.AccountValidation;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class AccountRepository {

	private Map<Integer, User> usersMap = DataClass.getUsersMap();
	private Map<Integer, Ride> ridesMap = DataClass.getRidesMap();

	public int createAccount(User user) {
		
		if(user.getFirstName() == null){
			throw new NullPointerException("The first name appears to be uninitialized.");
		}
		if(user.getFirstName().isBlank()) {
			throw new FieldDataMissingException("The first name appears to be missing");
		}
		if(!AccountValidation.isNameValid(user.getFirstName())) {
			throw new FieldDataInvalidException("Invalid first name");
		}
		if(user.getLastName() == null){
			throw new NullPointerException("The last name appears to be uninitialized");
		}
		if(user.getLastName().isBlank()) {
			throw new FieldDataMissingException("The last name appears to be missing");
		}
		if(!AccountValidation.isNameValid(user.getLastName())) {
			throw new FieldDataInvalidException("Invalid last name");
		}
		if(user.getPhone() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		if(user.getPhone().isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		if(!AccountValidation.isPhoneValid(user.getPhone())) {
			throw new FieldDataInvalidException("Invalid phone number");
		}
		if(user.getPicture() == null) {
			throw new NullPointerException("The picture appears to be uninitialized");
		}
		if(user.getPicture().isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
		if(user.isActive() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		int aid = UniqueIdGenerator.generateUniqueID();
		user.setAid(aid);
		usersMap.put(aid, user);
		return aid;
	}
	
	public void activateAccount(int aid, User user) {
		
		if(!usersMap.containsKey(aid)) {
			throw new DataNotFoundException("The account identified by [" + aid + "] doesn't exist");
		}
		if(user.getFirstName() == null){
			throw new NullPointerException("The first name appears to be uninitialized.");
		}
		if(user.getFirstName().isBlank()) {
			throw new FieldDataMissingException("The first name appears to be missing");
		}
		if(!AccountValidation.isNameValid(user.getFirstName())) {
			throw new FieldDataInvalidException("Invalid first name");
		}
		if(user.getLastName() == null){
			throw new NullPointerException("The last name appears to be uninitialized");
		}
		if(user.getLastName().isBlank()) {
			throw new FieldDataMissingException("The last name appears to be missing");
		}
		if(!AccountValidation.isNameValid(user.getLastName())) {
			throw new FieldDataInvalidException("Invalid last name");
		}
		if(user.getPhone() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		if(user.getPhone().isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		if(!AccountValidation.isPhoneValid(user.getPhone())) {
			throw new FieldDataInvalidException("Invalid phone number");
		}
		if(user.getPicture() == null) {
			throw new NullPointerException("The picture appears to be uninitialized");
		}
		if(user.getPicture().isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
//		if(user.isActive() == null) {
//			throw new NullPointerException("The phone number appears to be uninitialized");
//		}
		if(AccountValidation.isAccountActive(user.isActive())) {
			throw new FieldDataInvalidException("Invalid value for is_active");
		}
		usersMap.put(aid, user);
	}

	public void updateAccount(int aid, User user) {
		
		if(!usersMap.containsKey(aid)) {
			throw new DataNotFoundException("The account identified by [" + aid + "] doesn't exist");
		}
		if(user.getFirstName() == null){
			throw new NullPointerException("The first name appears to be uninitialized.");
		}
		if(user.getFirstName().isBlank()) {
			throw new FieldDataMissingException("The first name appears to be missing");
		}
		if(!AccountValidation.isNameValid(user.getFirstName())) {
			throw new FieldDataInvalidException("Invalid first name");
		}
		if(user.getLastName() == null){
			throw new NullPointerException("The last name appears to be uninitialized");
		}
		if(!AccountValidation.isNameValid(user.getLastName())) {
			throw new FieldDataInvalidException("Invalid last name");
		}
		if(user.getLastName().isBlank()) {
			throw new FieldDataMissingException("The last name appears to be missing");
		}
		if(user.getPhone() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		if(user.getPhone().isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		if(!AccountValidation.isPhoneValid(user.getPhone())) {
			throw new FieldDataInvalidException("Invalid phone number");
		}
		if(user.getPicture() == null) {
			throw new NullPointerException("The picture appears to be uninitialized");
		}
		if(user.getPicture().isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
		if(user.isActive() == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		
		usersMap.put(aid, user);
	}

	public void deleteAccount(int aid) {
		if(!usersMap.containsKey(aid)) {
			throw new DataNotFoundException("The account identified by [" + aid + "] doesn't exist");
		}
		usersMap.remove(aid);
	}

	public List<User> viewAllAccounts() {
		return new ArrayList<User>(usersMap.values());
	}
	
	public List<User> searchAccounts(String key) {
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
		return userAccountsWithMatch;
	}

	public Integer rateAccount(int aid, Rating rating) {
	
		if(rating.getRid() == null) {
			throw new NullPointerException("The ride appears to be uninitialized");
		}
		if(rating.getSentById() == null) {
			throw new NullPointerException("The sent_by_id appears to be uninitialized");
		}
		if(rating.getRating() == null) {
			throw new NullPointerException("The rating appears to be uninitialized");
		}
		if(!ridesMap.containsKey(rating.getRid())) {
			throw new FieldDataInvalidException("Invalid value for rid");
		}
		if(!usersMap.containsKey(aid)) {
			throw new FieldDataInvalidException("Invalid value for aid");
		}
		if(!usersMap.containsKey(rating.getSentById())) {
			throw new FieldDataInvalidException("Invalid value for aid");
		}
		if(!AccountValidation.isRatingAmountValid(rating.getRating())) {
			throw new FieldDataInvalidException("Invalid rating amount");
		}
		
		if(usersMap.containsKey(aid)) {
			User findUser = usersMap.get(aid);
			int sid = UniqueIdGenerator.generateUniqueID();
			String dateCreated = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			rating.setDate(dateCreated);
			if(findUser.getRatings() == null) {
				List<Rating> userRating = new ArrayList<Rating>();
				userRating.add(rating);
				findUser.setRatings(userRating);
			} else {
				findUser.getRatings().add(rating);
			}
			return sid;
		}
		return null;
	}

	public List<Rating> viewDriverRatings(int aid) {
		if(usersMap.containsKey(aid)) {
			return usersMap.get(aid).getDriversRating();
		}
		return null;
	}
	
	public List<Rating> viewRiderRatings(int aid) {
		if(usersMap.containsKey(aid)) {
			return usersMap.get(aid).getRidersRating();
		}
		return null;
	}
	
}
