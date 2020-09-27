package com.cs.iit.sar.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Report {
	private Integer pid;
	private String name;
	private String startDate;
	private String endDate;
	private Integer rides;
	private List<ReportDetail> detail;
}
