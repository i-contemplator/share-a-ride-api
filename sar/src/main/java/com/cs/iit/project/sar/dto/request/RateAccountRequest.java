package com.cs.iit.project.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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
