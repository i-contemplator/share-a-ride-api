package com.cs.iit.project.sar.models;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class Report {
	private Integer pid;
	private String name;
	private String startDate;
	private String endDate;
	private Integer rides;
	private List<ReportDetail> detail;
	
	public Report(Integer pid, String name, String startDate, String endDate, Integer rides, List<ReportDetail> detail) {
		super();
		this.pid = pid;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rides = rides;
		this.detail = detail;
	}	
	
}
