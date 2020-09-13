package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlElement;

@JsonbNillable
public class JoinRequest {

	private int jid;
	private int aid;
	private int passengers;
	@JsonbProperty("ride_confirmed")
	private Boolean rideConfirmed;
	@JsonbProperty("pickup_confirmed")
	private Boolean pickupConfirmed;
	
	public JoinRequest() {
		
	}
	
	public JoinRequest(int aid, int passengers, boolean rideConfirmed, boolean pickupConfirmed) {
		super();
		this.aid = aid;
		this.passengers = passengers;
		this.rideConfirmed = rideConfirmed;
		this.pickupConfirmed = pickupConfirmed;
	}
	
	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public Boolean isRideConfirmed() {
		return rideConfirmed;
	}
	public void setRideConfirmed(Boolean rideConfirmed) {
		this.rideConfirmed = rideConfirmed;
	}
	public Boolean isPickupConfirmed() {
		return pickupConfirmed;
	}
	public void setPickupConfirmed(Boolean pickupConfirmed) {
		this.pickupConfirmed = pickupConfirmed;
	}

}
