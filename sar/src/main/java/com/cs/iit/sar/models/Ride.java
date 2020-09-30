package com.cs.iit.sar.models;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.cs.iit.sar.exception.FieldDataInvalidException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
public class Ride {
	private Integer rid;
	private Integer aid;
	private LocationInfo locationInfo;
	private DateTime dateTime;
	private Car carInfo;
	private Integer maxPassengers;
	private Double amountPerPassenger;
	private String conditions;
	private Map<Integer, JoinRequest> joinRequests;
	private Map<Integer, User> riders;
	private List<Message> messages;
	private boolean isTripCompleted;
	
	public Ride(Integer rid, Integer aid, LocationInfo locationInfo, DateTime dateTime, Car carInfo,
			Integer maxPassengers, Double amountPerPassenger) {
		super();
		this.rid = rid;
		this.aid = aid;
		this.locationInfo = locationInfo;
		this.dateTime = dateTime;
		this.carInfo = carInfo;
		this.maxPassengers = maxPassengers;
		this.amountPerPassenger = amountPerPassenger;
	}	
	
	public void setAid(Integer aid) {
		if(aid == null) {
			throw new FieldDataInvalidException("aid appears to be null");
		}
		this.aid = aid;
	}
	
	public void setLocationInfo(LocationInfo locationInfo) {
		if(locationInfo == null) {
			throw new FieldDataInvalidException("location_info appears to be null");
		}
		this.locationInfo = locationInfo;
	}
	
	public void setDateTime(DateTime dateTime) {
		if(dateTime == null) {
			throw new FieldDataInvalidException("date_time appears to be null");
		}
		this.dateTime = dateTime;
	}
	
	public void setCarInfo(Car carInfo) {
		if(carInfo == null) {
			throw new FieldDataInvalidException("car_info appears to be null");
		}
		this.carInfo = carInfo;
	}
	
	public void setMaxPassengers(Integer maxPassengers) {
		if(maxPassengers == null) {
			throw new FieldDataInvalidException("max_passengers appears to be null");
		}
		this.maxPassengers = maxPassengers;
	}
	
	public void setAmountPerPassenger(Double amountPerPassenger) {
		if(amountPerPassenger == null) {
			throw new FieldDataInvalidException("amount_per_passenger appears to be null");
		}
		this.amountPerPassenger = amountPerPassenger;
	}
	
	public void setConditions(String conditions) {
		if(conditions == null) {
			throw new FieldDataInvalidException("conditions appears to be null");
		}
		this.conditions = conditions;
	}

}
