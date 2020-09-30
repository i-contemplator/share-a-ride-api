package com.cs.iit.sar.models;

import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;

import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.exception.FieldDataMissingException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	private Integer aid;
	private String firstName;
	private String lastName;
	private String phone;
	private String picture;
	private Boolean active;
	private String dateCreated;
	private List<Rating> driversRating;
	private List<Rating> ridersRating;    
	private int totalRidesAsRider;    
	private int totalRidesAsDriver;   

	public User(Integer aid, String firstName, String lastName, String phone, String picture, Boolean active) {
		super();
		this.aid = aid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.picture = picture;
		this.active = active;
	}
	
	public List<Rating> getRidersRating() {
		if(this.ridersRating == null) {
			return new ArrayList<>();
		}
		return this.ridersRating;
	}
	
	public List<Rating> getDriversRating() {
		if(this.driversRating == null) {
			return new ArrayList<>();
		}
		return this.driversRating;
	}
	
	public Integer getTotalRatingsAsRider() {
		if(this.ridersRating == null) {
			return 0;
		}
		return this.ridersRating.size();
	}
	
	public Integer getTotalRatingsAsDriver() {
		if(this.driversRating == null) {
			return 0;
		}
		return this.driversRating.size();
	}
	
	public Double getAverageRatingAsRider() {
		double total = 0;
		if(this.ridersRating == null) {
			return null;
		}
		for(Rating rating : this.ridersRating) {
			total = total + rating.getRating();
		}
		double ratings = total/this.getTotalRatingsAsRider();
		return ratings;
	}
	
	public Double getAverageRatingAsDriver() {
		double total = 0;
		if(this.driversRating == null) {
			return null;
		}
		for(Rating rating : this.driversRating) {
			total = total + rating.getRating();
		}
		double rating = total/this.getTotalRatingsAsDriver();
		return rating;
	}

	public void setFirstName(String firstName) {
		if(firstName == null) {
			throw new FieldDataInvalidException("First name appears to be null");
		}
		if(firstName.isBlank()) {
			throw new FieldDataMissingException("First name appears to be empty");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null){
			throw new FieldDataInvalidException("The last name appears to be null");
		}
		if(lastName.isBlank()) {
			throw new FieldDataMissingException("The last name appears to be empty");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if(phone == null) {
			throw new FieldDataInvalidException("The phone number appears to be uninitialized");
		}
		if(phone.isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		this.phone = phone;
	}
	
	public void setPicture(String picture) {
		if(picture == null) {
			throw new FieldDataInvalidException("The picture appears to be uninitialized");
		}
		if(picture.isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
		this.picture = picture;
	}
	
	public void setActive(Boolean active) {
		if(active == null) {
			throw new FieldDataInvalidException("is_active appears to be uninitialized");
		}
		this.active = active;
	}
}
