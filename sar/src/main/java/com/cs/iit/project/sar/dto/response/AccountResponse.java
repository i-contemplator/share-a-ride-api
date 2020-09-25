package com.cs.iit.project.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountResponse {

	private Integer aid;
	private String name;
	@JsonbProperty("date_created")
	private String dateCreated;
	@JsonbProperty("is_active")
	private Boolean active;
}
