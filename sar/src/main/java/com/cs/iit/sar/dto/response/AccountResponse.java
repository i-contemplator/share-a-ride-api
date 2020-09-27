package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AccountResponse {
	private Integer aid;
	private String name;
	@JsonbProperty("date_created")
	private String dateCreated;
	@JsonbProperty("is_active")
	private Boolean active;
}
