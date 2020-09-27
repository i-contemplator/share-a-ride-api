package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarResponse {
	private String make;
	private String model;
	private String color;
	@JsonbProperty("plate_state")
	private String plateState;
	@JsonbProperty("plate_serial")
	private String plateSerial;
}
