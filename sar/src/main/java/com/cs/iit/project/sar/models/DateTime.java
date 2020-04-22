package com.cs.iit.project.sar.models;

public class DateTime {
	
	private String date;
	private String time;
	
	public DateTime() {
		
	}
	public DateTime(String date, String time) {
		super();
		this.date = date;
		this.time = time;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
