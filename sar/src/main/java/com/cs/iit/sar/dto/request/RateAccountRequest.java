package com.cs.iit.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateAccountRequest {
	private int sid;
	private Integer rid;
	@JsonbProperty("sent_by_id")
	private Integer sentById;
	private Integer accountToRate;
	private Integer rating;
	private String comment;
	private String date;
}
