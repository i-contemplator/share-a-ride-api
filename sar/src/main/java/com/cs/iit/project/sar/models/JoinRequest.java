package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbProperty;

@JsonbNillable
public class JoinRequest {

	private int jid;
	private Integer aid;
	private Integer rid;
	private Integer passengers;
	@JsonbProperty("ride_confirmed")
	private Boolean rideConfirmed;
	@JsonbProperty("pickup_confirmed")
	private Boolean pickupConfirmed;
	
	public JoinRequest() {
		
	}
	
	public JoinRequest(Integer aid, Integer passengers, boolean rideConfirmed, boolean pickupConfirmed) {
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
	
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getPassengers() {
		return passengers;
	}
	public void setPassengers(Integer passengers) {
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
