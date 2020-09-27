package com.cs.iit.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequest {
	@JsonbProperty("first_name")
	private String firstName;
	@JsonbProperty("last_name")
	private String lastName;
	private String phone;
	private String picture;
	@JsonbProperty("is_active")
	private Boolean active;
	private Integer aid;
	@JsonbProperty("date_created")
	private String dateCreated;
}
