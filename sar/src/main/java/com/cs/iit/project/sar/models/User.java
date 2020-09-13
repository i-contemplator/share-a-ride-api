package com.cs.iit.project.sar.models;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	@JsonbProperty("first_name")
	private String firstName;
	@JsonbProperty("last_name")
	private String lastName;
	private String phone;
	private String picture;
	@JsonbProperty("is_active")
	private boolean active;
	private int aid;
	@JsonbProperty("detail")
	private List<Rating> ratings;
//	private List<Rating> driversRating;
//	private List<Rating> ridersRating;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName, String phone, String picture, boolean isActive) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.picture = picture;
		this.active = isActive;
		this.ratings = new ArrayList<Rating>();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) { 
		this.lastName = lastName; 
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", picture=" + picture
				+ ", active=" + active + ", aid=" + aid + "]";
	}

}
