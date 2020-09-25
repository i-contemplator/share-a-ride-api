package com.cs.iit.project.sar.dto.request;

import javax.json.bind.annotation.JsonbProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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
