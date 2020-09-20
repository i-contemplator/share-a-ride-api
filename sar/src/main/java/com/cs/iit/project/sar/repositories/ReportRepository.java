package com.cs.iit.project.sar.repositories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cs.iit.project.sar.models.Report;

public class ReportRepository {

	static Map<Integer, Report> reportsMap = new HashMap<Integer, Report>();
	public List<Report> getAllReports() {
		return new ArrayList<Report>(reportsMap.values());
	}
	public List<Report> getAllReportsBetweenDate(int pid, String start_date, String end_date) throws ParseException {
		List<Report> reportsBetweenDates = new ArrayList<Report>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = sdf.parse(start_date);
		Date endDate = sdf.parse(end_date);

		for(Report report: reportsMap.values()) {
			Date reportStartDate = sdf.parse(report.getStartDate());
			Date reportEndDate = sdf.parse(report.getEndDate());
			if((reportStartDate.compareTo(startDate) > 0) && (reportEndDate.compareTo(endDate) > 0)) {
				reportsBetweenDates.add(report);
			}
		}
		return reportsBetweenDates;
	}

}
