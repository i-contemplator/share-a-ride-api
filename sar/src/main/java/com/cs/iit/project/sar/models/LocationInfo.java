package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbProperty;

public class LocationInfo {
	
	@JsonbProperty("from_city")
	private String fromCity;
	@JsonbProperty("from_zip")
	private String fromZip;
	@JsonbProperty("to_city")
	private String toCity;
	@JsonbProperty("to_zip")
	private String toZip;
	
	public LocationInfo() {
		
	}
	
	public LocationInfo(String fromCity, String fromZip, String toCity, String toZip) {
		super();
		this.fromCity = fromCity;
		this.fromZip = fromZip;
		this.toCity = toCity;
		this.toZip = toZip;
	}
	
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getFromZip() {
		return fromZip;
	}
	public void setFromZip(String fromZip) {
		this.fromZip = fromZip;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getToZip() {
		return toZip;
	}
	public void setToZip(String toZip) {
		this.toZip = toZip;
	}
	
}
