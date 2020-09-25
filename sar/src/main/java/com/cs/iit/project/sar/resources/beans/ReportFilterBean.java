package com.cs.iit.project.sar.resources.beans;

import javax.ws.rs.QueryParam;

import lombok.Data;

@Data
public class ReportFilterBean {
	private @QueryParam("start_date") String startDate;
	private @QueryParam("end_date") String endDate;
}
