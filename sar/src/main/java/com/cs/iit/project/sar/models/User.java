package com.cs.iit.project.sar.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private String first_name;
	private String last_name;
	private String phone;
	private String picture;
	private boolean is_active;
	private int aid;
	private List<Rating> drivers_rating;
	private List<Rating> riders_rating;

	public List<Rating> getDrivers_rating() {
		return drivers_rating;
	}

	public void setDrivers_rating(List<Rating> drivers_rating) {
		this.drivers_rating = drivers_rating;
	}

	public List<Rating> getRiders_rating() {
		return riders_rating;
	}

	public void setRiders_rating(List<Rating> riders_rating) {
		this.riders_rating = riders_rating;
	}

	public User() {
	
	}
	
	public User(String first_name, String last_name, String phone, String picture, boolean is_active) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.picture = picture;
		this.is_active = is_active;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPicture() {
		return picture;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setDriversRating(Rating rating) {
		this.drivers_rating.add(rating);
	}
	
	public void setRidersRating(Rating rating) {
		this.riders_rating.add(rating);
	}
}
