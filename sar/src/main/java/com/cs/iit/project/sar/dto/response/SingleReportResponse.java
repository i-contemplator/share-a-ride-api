package com.cs.iit.project.sar.dto.response;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;

import com.cs.iit.project.sar.models.ReportDetail;

import lombok.Data;

@Data
public class SingleReportResponse {

	private int pid;
	private String name;
	@JsonbProperty("start_date")
	private String startDate;
	@JsonbProperty("end_date")
	private String endDate;
	private int rides;
	private List<SingleReportDetailResponse> detail;
}
