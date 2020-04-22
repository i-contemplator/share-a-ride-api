package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbProperty;
import javax.xml.bind.annotation.XmlElement;

public class JoinRequest {

	private int aid;
	private int passengers;
	@JsonbProperty(nillable=true)
	private boolean ride_confirmed;
	@JsonbProperty(nillable=true)
	private boolean pickup_confirmed;
	private int jid;
	
	public JoinRequest() {
		
	}
	
	public JoinRequest(int aid, int passengers/*, boolean ride_confirmed, boolean pickup_confirmed*/) {
		super();
		this.aid = aid;
		this.passengers = passengers;
//		this.ride_confirmed = ride_confirmed;
//		this.pickup_confirmed = pickup_confirmed;
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
	public boolean isRide_confirmed() {
		return ride_confirmed;
	}
	public void setRide_confirmed(boolean ride_confirmed) {
		this.ride_confirmed = ride_confirmed;
	}
	public boolean isPickup_confirmed() {
		return pickup_confirmed;
	}
	public void setPickup_confirmed(boolean pickup_confirmed) {
		this.pickup_confirmed = pickup_confirmed;
	}
	
	public int getJid() {
		return jid;
	}

	public void setJid(int jid) {
		this.jid = jid;
	}

}
