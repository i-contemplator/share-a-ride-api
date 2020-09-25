package com.cs.iit.project.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Data;

@Data
public class JoinRequestRequest {
	private Integer aid;
	private Integer passengers;
	@JsonbProperty("ride_confirmed")
	private Boolean rideConfirmed;
	@JsonbProperty("pickup_confirmed")
	private Boolean pickupConfirmed;
}
