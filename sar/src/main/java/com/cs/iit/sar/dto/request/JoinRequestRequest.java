package com.cs.iit.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequestRequest {
	private Integer aid;
	private Integer passengers;
	@JsonbProperty("ride_confirmed")
	private Boolean rideConfirmed;
	@JsonbProperty("pickup_confirmed")
	private Boolean pickupConfirmed;
	
	public JoinRequestRequest(Integer aid, Integer passengers, Boolean rideConfirmed, Boolean pickupConfirmed) {
		super();
		this.aid = aid;
		this.passengers = passengers;
		this.rideConfirmed = rideConfirmed;
		this.pickupConfirmed = pickupConfirmed;
	}
	
}
