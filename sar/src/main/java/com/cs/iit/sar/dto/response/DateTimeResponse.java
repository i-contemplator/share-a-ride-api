package com.cs.iit.sar.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeResponse {
	private String date;
	private String time;
	
	public DateTimeResponse(String date, String time) {
		super();
		this.date = date;
		this.time = time;
	}
	
}
