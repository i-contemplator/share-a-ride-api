package com.cs.iit.project.sar.repositories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cs.iit.project.sar.models.Rating;
import com.cs.iit.project.sar.models.User;
import com.cs.iit.project.sar.utilities.UniqueIdGenerator;

public class AccountRepository {

	static List<User> users = new ArrayList<>();
	
	public int createAccount(User user) {
		int aid = UniqueIdGenerator.generateUniqueID();
		users.add(user);
		user.setAid(aid);
		return aid;
	}
	
	public void activateAccount(int aid, User user) {
		for(User u : users) {
			if (u.getAid() == aid) {
				u.setIs_active(true);
			}
		}
	}

	public void updateAccount(int aid, User user) {
		for(User u : users) {
			if (u.getAid() == aid) {
				u.setFirst_name(user.getFirst_name());
				u.setLast_name(user.getLast_name());
				u.setPhone(user.getPhone());
				u.setPicture(user.getPicture());
				u.setIs_active(user.isIs_active());
			}
		}
	}

	public void deleteAccount(int aid) {
		for(User u : users) {
			if (u.getAid() == aid) {
				users.remove(u);
			}	
		}
	}

	public List<User> viewAllAccounts() {
		return users;
	}

	public Integer rateAccount(int aid, Rating rating) {
		int sid = UniqueIdGenerator.generateUniqueID();
		for(User u: users) {
			if(u.getAid()==aid) {
				String dateCreated = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
				rating.setDate(dateCreated);
				u.setRating(rating);
				return sid;
			}
		}
		return null;
	}

	public List<User> searchAccounts(String key) {
		List<User> userAccountsWithMatch = new ArrayList<User>();
		String newKey = key.toLowerCase();
			for(User u: users) {
				if(u.getFirst_name().toLowerCase().contains(newKey) 
						|| u.getLast_name().toLowerCase().contains(newKey)
						|| u.getPhone().contains(newKey)) {
					userAccountsWithMatch.add(u);
				}
			}
		return userAccountsWithMatch;
	}
	
}
