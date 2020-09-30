package com.cs.iit.sar.models;

import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.exception.FieldDataMissingException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Car {
	private String make;
	private String model;
	private String color;
	private String plateState;
	private String plateSerial;	
	
	public Car(String plateState) {
		this.plateState = plateState;
	}
	
	public void setMake(String make) {
		if(make == null) {
			throw new FieldDataInvalidException("car make appears to be null");
		}
		if(make.isBlank()) {
			throw new FieldDataMissingException("car make appears to be empty");
		}
		this.make = make;
	}
	
	public void setModel(String model) {
		if(model == null) {
			throw new FieldDataInvalidException("car model appears to be null");
		}
		if(model.isBlank()) {
			throw new FieldDataMissingException("car model appears to be empty");
		}
		this.model = model;
	}
	
	public void setColor(String color) {
		if(color == null) {
			throw new FieldDataInvalidException("car color appears to be null");
		}
		if(color.isBlank()) {
			throw new FieldDataMissingException("car color appears to be empty");
		}
		this.color = color;
	}
	
	public void setPlateState(String plateState) {
		if(plateState == null) {
			throw new FieldDataInvalidException("car plate_state appears to be null");
		}
		if(plateState.isBlank()) {
			throw new FieldDataMissingException("car plate_state appears to be empty");
		}
		this.plateState = plateState;
	}
	
	public void setPlateSerial(String plateSerial) {
		if(plateSerial == null) {
			throw new FieldDataInvalidException("car plate_serial appears to be null");
		}
		if(plateSerial.isBlank()) {
			throw new FieldDataMissingException("car plate_serial appears to be empty");
		}
		this.plateSerial = plateSerial;
	}
}
