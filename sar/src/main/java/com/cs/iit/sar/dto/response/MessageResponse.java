package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageResponse {
	private Integer mid;
	@JsonbProperty("sent_by_aid")
	private Integer sentByAid;
	private String date;
	private String body;
}
