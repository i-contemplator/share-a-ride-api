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
public class DateTime {
	private String date;
	private String time;
	
	public void setDate(String date) {
		if(date == null) {
			throw new FieldDataInvalidException("date appears to be null");
		}
		if(date.isBlank()) {
			throw new FieldDataMissingException("date appears to be missing");
		}
		this.date = date;
	}
	
	public void setTime(String time) {
		if(time == null) {
			throw new FieldDataInvalidException("time appears to be null");
		}
		if(time.isBlank()) {
			throw new FieldDataMissingException("time appears to be missing");
		}
		this.time = time;
	}
}
