package com.cs.iit.sar.boundaryinterfaces;

import java.text.ParseException;
import java.util.List;

import com.cs.iit.sar.dto.response.ReportResponse;
import com.cs.iit.sar.dto.response.SingleReportResponse;

public interface ReportBoundaryInterface {

	List<ReportResponse> getAllReports();
	
	SingleReportResponse getReport(int pid, String startDate, String endDate) throws ParseException;

}
