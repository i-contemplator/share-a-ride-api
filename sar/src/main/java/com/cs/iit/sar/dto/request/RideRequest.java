package com.cs.iit.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import com.cs.iit.sar.dto.response.CarResponse;
import com.cs.iit.sar.dto.response.DateTimeResponse;
import com.cs.iit.sar.dto.response.LocationInfoResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideRequest {
	private Integer aid;
	private Integer rid;
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
