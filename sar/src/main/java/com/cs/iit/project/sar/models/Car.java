package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbProperty;

public class Car {

	private String make;
	private String model;
	private String color;
	@JsonbProperty("plate_state")
	private String plateState;
	@JsonbProperty("plate_serial")
	private String plateSerial;
	
	public Car() {
		
	}
	
	public Car(String make, String model, String color, String plateState, String plateSerial) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.plateState = plateState;
		this.plateSerial = plateSerial;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlateState() {
		return plateState;
	}

	public void setPlateState(String plateState) {
		this.plateState = plateState;
	}

	public String getPlateSerial() {
		return plateSerial;
	}

	public void setPlateSerial(String plateSerial) {
		this.plateSerial = plateSerial;
	}
	
}
