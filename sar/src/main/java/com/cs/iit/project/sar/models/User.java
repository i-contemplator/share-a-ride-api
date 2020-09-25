package com.cs.iit.project.sar.models;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@Data
@NoArgsConstructor
//@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
	
	private Integer aid;
	@JsonbProperty("first_name")
	private String firstName;
	@JsonbProperty("last_name")
	private String lastName;
	private String phone;
	private String picture;
	@JsonbProperty("is_active")
	private Boolean active;
	@JsonbProperty("date_created")
	private String dateCreated;
	private List<Rating> driversRating;
	private List<Rating> ridersRating;    
	private int totalRidesAsRider;    
	private int totalRidesAsDriver;   
	@SuppressWarnings("unused")
	private Integer totalRatingsAsRider;
	@SuppressWarnings("unused")
	private Integer totalRatingsAsDriver; 
	@SuppressWarnings("unused")
	private Double averageRatingAsRider;  
	@SuppressWarnings("unused")
	private Double averageRatingAsDriver; 
	
	public User(String firstName, String lastName, String phone, String picture, Boolean active,
			Integer aid, List<Rating> driversRating, List<Rating> ridersRating,
			String dateCreated) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.picture = picture;
		this.active = active;
		this.aid = aid;
		this.driversRating = driversRating;
		this.ridersRating = ridersRating;
		this.dateCreated = dateCreated;
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
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", picture=" + picture
				+ ", active=" + active + ", aid=" + aid + "]";
	}

}
