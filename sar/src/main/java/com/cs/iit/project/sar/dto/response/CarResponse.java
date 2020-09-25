package com.cs.iit.project.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Data;

@Data
public class CarResponse {
	
	private String make;
	private String model;
	private String color;
	@JsonbProperty("plate_state")
	private String plateState;
	@JsonbProperty("plate_serial")
	private String plateSerial;
	
}
