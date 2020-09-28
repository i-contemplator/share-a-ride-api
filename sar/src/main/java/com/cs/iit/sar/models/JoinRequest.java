package com.cs.iit.sar.models;

import javax.json.bind.annotation.JsonbNillable;

import com.cs.iit.sar.exception.FieldDataInvalidException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonbNillable
@NoArgsConstructor
public class JoinRequest {
	private int jid;
	private Integer aid;
	private Integer rid;
	private Integer passengers;
	private Boolean rideConfirmed;
	private Boolean pickupConfirmed;

	public JoinRequest(int jid, Integer aid, Integer rid, Integer passengers, Boolean rideConfirmed,
			Boolean pickupConfirmed) {
		super();
		this.jid = jid;
		this.aid = aid;
		this.rid = rid;
		this.passengers = passengers;
		this.rideConfirmed = rideConfirmed;
		this.pickupConfirmed = pickupConfirmed;
	}
	
	public void setAid(Integer aid) {
		if(aid == null) {
			throw new NullPointerException("aid appears to be null");
		}
		this.aid = aid;
	}
	
	public void setPassengers(Integer passengers) {
		if(passengers == null) {
			throw new NullPointerException("passengers appears to be null");
		}
		this.passengers = passengers;
	}
	
	public void setRideConfirmed(Boolean rideConfirmed) {
		if(rideConfirmed != null) {
			throw new FieldDataInvalidException("Invalid value for ride_confirmed");
		}
		this.rideConfirmed = rideConfirmed;
	}
	
	public void setPassengers(Boolean pickupConfirmed) {
		if(pickupConfirmed != null) {
			throw new FieldDataInvalidException("Invalid value for pickup_confirmed");
		}
		this.pickupConfirmed = pickupConfirmed;
	}
	
}
