package com.cs.iit.project.sar.models;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ride {
	private int aid;
	private LocationInfo location_info;
	private DateTime date_time;
	private Car car_info;
	private int max_passengers;
	private float amount_per_passenger;
	private String conditions;
	private int rid;
	private List<JoinRequest> joinRequests;
	private List<Message> messages;

	public Ride() {
		
	}
	
	public Ride(int aid, LocationInfo location_info, DateTime date_time, Car car_info, int max_passengers,
			float amount_per_passenger, String conditions) {
		super();
		this.aid = aid;
//		this.location_info = location_info;
//		this.date_time = date_time;
//		this.car_info = car_info;
		this.max_passengers = max_passengers;
		this.amount_per_passenger = amount_per_passenger;
		this.conditions = conditions;
	}
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public LocationInfo getLocation_info() {
		return location_info;
	}

	public void setLocation_info(LocationInfo location_info) {
		this.location_info = location_info;
	}

	public DateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(DateTime date_time) {
		this.date_time = date_time;
	}

	public Car getCar_info() {
		return car_info;
	}

	public void setCar_info(Car car_info) {
		this.car_info = car_info;
	}

	public int getMax_passengers() {
		return max_passengers;
	}

	public void setMax_passengers(int max_passengers) {
		this.max_passengers = max_passengers;
	}

	public float getAmount_per_passenger() {
		return amount_per_passenger;
	}

	public void setAmount_per_passenger(float amount_per_passenger) {
		this.amount_per_passenger = amount_per_passenger;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public List<JoinRequest> getJoinRequests() {
		return joinRequests;
	}

	public void setJoinRequests(List<JoinRequest> joinRequests) {
		this.joinRequests = joinRequests;
	}
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
