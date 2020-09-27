package com.cs.iit.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingleReportDetailResponse {
	@JsonbProperty("from_zip")
	private String fromZip;
	@JsonbProperty("to_zip")
	private String toZip;
	private int count;
}
