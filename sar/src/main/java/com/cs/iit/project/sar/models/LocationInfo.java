package com.cs.iit.project.sar.models;

public class LocationInfo {
	
	private String from_city;
	private String from_zip;
	private String to_city;
	private String to_zip;
	
	public LocationInfo() {
		
	}
	
	public LocationInfo(String from_city, String from_zip, String to_city, String to_zip) {
		super();
		this.from_city = from_city;
		this.from_zip = from_zip;
		this.to_city = to_city;
		this.to_zip = to_zip;
	}
	
	public String getFrom_city() {
		return from_city;
	}
	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}
	public String getFrom_zip() {
		return from_zip;
	}
	public void setFrom_zip(String from_zip) {
		this.from_zip = from_zip;
	}
	public String getTo_city() {
		return to_city;
	}
	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}
	public String getTo_zip() {
		return to_zip;
	}
	public void setTo_zip(String to_zip) {
		this.to_zip = to_zip;
	}
	
}
