package com.cs.iit.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RateAccountRequest {
	private int sid;
	private Integer rid;
	@JsonbProperty("sent_by_id")
	private Integer sentById;
	private Integer accountToRate;
	private Integer rating;
	private String comment;
	private String date;
	
	public RateAccountRequest(Integer rid, Integer sentById, Integer rating) {
		super();
		this.rid = rid;
		this.sentById = sentById;
		this.rating = rating;
	}
	
}
