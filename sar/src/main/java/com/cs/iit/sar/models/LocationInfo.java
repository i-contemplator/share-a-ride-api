package com.cs.iit.sar.models;

import com.cs.iit.sar.exception.FieldDataMissingException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationInfo {
	private String fromCity;
	private String fromZip;
	private String toCity;
	private String toZip;
	
	public void setFromCity(String fromCity) {
		if(fromCity == null) {
			throw new NullPointerException("from_city appears to be null");
		}
		if(fromCity.isBlank()) {
			throw new FieldDataMissingException("from_city appears to be empty");
		}
		this.fromCity = fromCity;
	}
	
	public void setToCity(String toCity) {
		if(toCity == null) {
			throw new NullPointerException("to_city appears to be null");
		}
		if(toCity.isBlank()) {
			throw new FieldDataMissingException("to_city appears to be empty");
		}
		this.toCity = toCity;
	}
	
}
