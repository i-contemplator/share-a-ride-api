package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationInfoResponse {
	@JsonbProperty("from_city")
	private String fromCity;
	@JsonbProperty("from_zip")
	private String fromZip;
	@JsonbProperty("to_city")
	private String toCity;
	@JsonbProperty("to_zip")
	private String toZip;
}
