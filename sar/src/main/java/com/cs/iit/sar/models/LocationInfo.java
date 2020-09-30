package com.cs.iit.sar.models;

import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.exception.FieldDataMissingException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class LocationInfo {
	private String fromCity;
	private String fromZip;
	private String toCity;
	private String toZip;
	
	public void setFromCity(String fromCity) {
		if(fromCity == null) {
			throw new FieldDataInvalidException("from_city appears to be null");
		}
		if(fromCity.isBlank()) {
			throw new FieldDataMissingException("from_city appears to be empty");
		}
		this.fromCity = fromCity;
	}
	
	public void setToCity(String toCity) {
		if(toCity == null) {
			throw new FieldDataInvalidException("to_city appears to be null");
		}
		if(toCity.isBlank()) {
			throw new FieldDataMissingException("to_city appears to be empty");
		}
		this.toCity = toCity;
	}
	
}
