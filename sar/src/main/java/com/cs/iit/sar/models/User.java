package com.cs.iit.sar.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

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

	public User(Integer aid, String firstName, String lastName, String phone, Boolean active) {
		super();
		this.aid = aid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.active = active;
	}
	
	public Integer getTotalRatingsAsRider() {
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
		for(Rating rating : this.ridersRating) {
			total = total + rating.getRating();
		}
		return total/this.getTotalRatingsAsRider();
	}
	
	public Double getAverageRatingAsDriver() {
		if(this.driversRating == null) {
			return 0.0;
		}
		double total = 0;
		for(Rating rating : this.driversRating) {
			total = total + rating.getRating();
		}
		return total/this.getTotalRatingsAsDriver();
	}

	public void setFirstName(String firstName) {
		if(firstName == null) {
			throw new NullPointerException("First name appears to be null");
		}
		if(firstName.isBlank()) {
			throw new FieldDataMissingException("First name appears to be empty");
		}
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if(lastName == null){
			throw new NullPointerException("The last name appears to be null");
		}
		if(lastName.isBlank()) {
			throw new FieldDataMissingException("The last name appears to be empty");
		}
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if(phone == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		if(phone.isBlank()) {
			throw new FieldDataMissingException("The phone number appears to be missing");
		}
		this.phone = phone;
	}
	
	public void setPicture(String picture) {
		if(picture == null) {
			throw new NullPointerException("The picture appears to be uninitialized");
		}
		if(picture.isBlank()) {
			throw new FieldDataMissingException("The picture appears to be missing");
		}
		this.picture = picture;
	}
	
	public void setActive(Boolean active) {
		if(active == null) {
			throw new NullPointerException("The phone number appears to be uninitialized");
		}
		this.active = active;
	}

}
