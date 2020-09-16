package com.cs.iit.project.sar.models;

import java.util.List;
import java.util.Map;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ride {
	private Integer aid;
	@JsonbProperty("location_info")
	private LocationInfo locationInfo;
	@JsonbProperty("date_time")
	private DateTime dateTime;
	@JsonbProperty("car_info")
	private Car carInfo;
	@JsonbProperty("max_passengers")
	private Integer maxPassengers;
	@JsonbProperty("amount_per_passenger")
	private Double amountPerPassenger;
	private String conditions;
	private Integer rid;
	@JsonbProperty("join_requests")
	private Map<Integer, JoinRequest> joinRequests;
	private List<Message> messages;

	public Ride() {
		
	}
	
	public Ride(Integer aid, LocationInfo locationInfo, DateTime dateTime, Car carInfo, Integer maxPassengers,
			Double amountPerPassenger, String conditions) {
		super();
		this.aid = aid;
		this.locationInfo = locationInfo;
		this.dateTime = dateTime;
		this.carInfo = carInfo;
		this.maxPassengers = maxPassengers;
		this.amountPerPassenger = amountPerPassenger;
		this.conditions = conditions;
	}
	
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public LocationInfo getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(LocationInfo locationInfo) {
		this.locationInfo = locationInfo;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Car getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(Car carInfo) {
		this.carInfo = carInfo;
	}

	public Integer getMaxPassengers() {
		return maxPassengers;
	}

	public void setMaxPassengers(Integer maxPassengers) {
		this.maxPassengers = maxPassengers;
	}

	public Double getAmountPerPassenger() {
		return amountPerPassenger;
	}

	public void setAmountPerPassenger(Double amountPerPassenger) {
		this.amountPerPassenger = amountPerPassenger;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}
	
	public Map<Integer, JoinRequest> getJoinRequests() {
		return joinRequests;
	}

	public void setJoinRequests(Map<Integer, JoinRequest> joinRequests) {
		this.joinRequests = joinRequests;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
