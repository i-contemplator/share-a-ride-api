package com.cs.iit.project.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import com.cs.iit.project.sar.dto.response.CarResponse;
import com.cs.iit.project.sar.dto.response.DateTimeResponse;
import com.cs.iit.project.sar.dto.response.LocationInfoResponse;

import lombok.Data;

@Data
public class RideRequest {
	private Integer aid;
	@JsonbProperty("location_info")
	private LocationInfoResponse locationInfo;
	@JsonbProperty("date_time")
	private DateTimeResponse dateTime;
	@JsonbProperty("car_info")
	private CarResponse carInfo;
	@JsonbProperty("max_passengers")
	private Integer maxPassengers;
	@JsonbProperty("amount_per_passenger")
	private Double amountPerPassenger;
	private String conditions;
}
