package com.cs.iit.project.sar.repositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.data.DataClass;
import com.cs.iit.project.sar.exception.FieldDataMissingException;
import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class AccountRepository {

	private Map<Integer, User> usersMap = DataClass.getUsersMap();

	public int createAccount(User user) {
		if(user.getFirstName() == null) {
			throw new FieldDataMissingException("First name missing");
		}
		int aid = UniqueIdGenerator.generateUniqueID();
		user.setAid(aid);
		usersMap.put(aid, user);
		return aid;
	}
	
	public void activateAccount(int aid, User user) {
		if (usersMap.containsKey(aid) && user.isActive()){
			usersMap.put(aid, user);
		}
	}

	public void updateAccount(int aid, User user) {
		if(usersMap.containsKey(aid)) {
			usersMap.put(aid, user);
		}
	}

	public void deleteAccount(int aid) {
		usersMap.remove(aid);
	}

	public List<User> viewAllAccounts() {
		return new ArrayList<User>(usersMap.values());
	}
	
	public List<User> searchAccounts(String key) {
		List<User> userAccountsWithMatch = new ArrayList<User>();
		String newKey = key.toLowerCase();
			for(Map.Entry<Integer, User> user : usersMap.entrySet()) {
				Integer userKey = user.getKey();
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
			return usersMap.get(aid).getRatings();
		}
		return null;
	}
	
	public List<Rating> viewRiderRatings(int aid) {
		if(usersMap.containsKey(aid)) {
			return usersMap.get(aid).getRatings();
		}
		return null;
	}
	
}
