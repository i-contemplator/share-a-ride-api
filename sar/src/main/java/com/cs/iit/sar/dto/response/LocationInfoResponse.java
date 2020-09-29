package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationInfoResponse {
	@JsonbProperty("from_city")
	private String fromCity;
	@JsonbProperty("from_zip")
	private String fromZip;
	@JsonbProperty("to_city")
	private String toCity;
	@JsonbProperty("to_zip")
	private String toZip;
	
	public LocationInfoResponse(String fromCity, String fromZip, String toCity, String toZip) {
		super();
		this.fromCity = fromCity;
		this.fromZip = fromZip;
		this.toCity = toCity;
		this.toZip = toZip;
	}
	
	
}
