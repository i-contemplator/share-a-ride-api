package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideResponse {

	private Integer rid;
	@JsonbProperty("location_info")
	private LocationInfoResponse locationInfo;
	@JsonbProperty("date_time")
	private DateTimeResponse dateTime;
}
