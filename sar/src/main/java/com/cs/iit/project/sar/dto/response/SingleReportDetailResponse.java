package com.cs.iit.project.sar.dto.response;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Data;

@Data
public class SingleReportDetailResponse {
	@JsonbProperty("from_zip")
	private String fromZip;
	@JsonbProperty("to_zip")
	private String toZip;
	private int count;
}
