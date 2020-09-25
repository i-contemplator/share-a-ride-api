package com.cs.iit.project.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Data;

@Data
public class RideResponse {

	private Integer rid;
	@JsonbProperty("location_info")
	private LocationInfoResponse locationInfo;
	@JsonbProperty("date_time")
	private DateTimeResponse dateTime;
}
