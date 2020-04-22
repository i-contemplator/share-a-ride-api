package com.cs.iit.project.sar.models;

public class Car {

	private String make;
	private String model;
	private String color;
	private String plate_state;
	private String plate_serial;
	
	public Car() {
		
	}
	
	public Car(String make, String model, String color, String plate_state, String plate_serial) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.plate_state = plate_state;
		this.plate_serial = plate_serial;
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

	public String getPlate_state() {
		return plate_state;
	}

	public void setPlate_state(String plate_state) {
		this.plate_state = plate_state;
	}

	public String getPlate_serial() {
		return plate_serial;
	}

	public void setPlate_serial(String plate_serial) {
		this.plate_serial = plate_serial;
	}
	
}
