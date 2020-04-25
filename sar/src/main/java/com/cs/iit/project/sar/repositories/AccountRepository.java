package com.cs.iit.project.sar.repositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class AccountRepository {

	static Map<Integer, User> usersMap = new HashMap<Integer, User>();
	
	public int createAccount(User user) {
		int aid = UniqueIdGenerator.generateUniqueID();
		user.setAid(aid);
		usersMap.put(aid, user);
		return aid;
	}
	
	public void activateAccount(int aid, User user) {
		if (usersMap.containsKey(aid) && user.isIs_active()){
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

	public Integer rateAccount(int aid, Rating rating) {
		if(usersMap.containsKey(aid)) {
			int sid = UniqueIdGenerator.generateUniqueID();
			String dateCreated = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			rating.setDate(dateCreated);
			 
		}
		for(User u: users) {
			if(u.getAid()==aid) {
				String dateCreated = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				rating.setDate(dateCreated);
				u.setDriversRating(rating);
				return sid;
			}
		}
		return null;
	}

	public List<User> searchAccounts(String key) {
		System.out.println("key value print in repo: " + key);
		List<User> userAccountsWithMatch = new ArrayList<User>();
		String newKey = key.toLowerCase();
			for(User u: users) {
				if(u.getFirst_name().toLowerCase().contains(newKey) 
						|| u.getLast_name().toLowerCase().contains(newKey)
						|| u.getPhone().contains(newKey)) {
					userAccountsWithMatch.add(u);
				}
			}
		System.out.println(userAccountsWithMatch);
		return userAccountsWithMatch;
	}

	public User viewDriverRatings(int aid) {
		for(User u : users) {
			if (u.getAid() == aid) {
				return u;
			}	
		}
		return null;
	}
	
	public User viewRiderRatings(int aid) {
		for(User u : users) {
			if (u.getAid() == aid) {
				return u;
			}	
		}
		return null;
	}
	
}
