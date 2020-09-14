package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbProperty;

public class PatchRideRequestConfirm {
	private Integer aid;
	@JsonbProperty("ride_confirmed")
	private Boolean rideConfirmed;
	
	public PatchRideRequestConfirm(Integer aid, Boolean rideConfirmed) {
		super();
		this.aid = aid;
		this.rideConfirmed = rideConfirmed;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Boolean getRideConfirmed() {
		return rideConfirmed;
	}

	public void setRideConfirmed(Boolean rideConfirmed) {
		this.rideConfirmed = rideConfirmed;
	}
	
	
	
}
