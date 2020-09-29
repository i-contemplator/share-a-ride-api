package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarResponse {
	private String make;
	private String model;
	private String color;
	@JsonbProperty("plate_state")
	private String plateState;
	@JsonbProperty("plate_serial")
	private String plateSerial;
	
	public CarResponse(String make, String model, String color, String plateState, String plateSerial) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.plateState = plateState;
		this.plateSerial = plateSerial;
	}
	
}
