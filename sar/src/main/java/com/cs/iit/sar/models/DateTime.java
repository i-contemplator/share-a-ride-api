package com.cs.iit.sar.models;

import com.cs.iit.sar.exception.FieldDataMissingException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateTime {
	private String date;
	private String time;
	
	public void setDate(String date) {
		if(date == null) {
			throw new NullPointerException("date appears to be null");
		}
		if(date.isBlank()) {
			throw new FieldDataMissingException("date appears to be null");
		}
		this.date = date;
	}
	
	public void setTime(String time) {
		if(time == null) {
			throw new NullPointerException("time appears to be null");
		}
		if(time.isBlank()) {
			throw new FieldDataMissingException("time appears to be null");
		}
		this.time = time;
	}
}
