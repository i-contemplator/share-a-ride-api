package com.cs.iit.sar.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cs.iit.sar.boundaryinterfaces.ReportBoundaryInterface;
import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.dto.mapper.ReportMapper;
import com.cs.iit.sar.dto.response.ReportResponse;
import com.cs.iit.sar.dto.response.SingleReportResponse;
import com.cs.iit.sar.dto.response.ViewReportsResponse;
import com.cs.iit.sar.models.Report;
import com.cs.iit.sar.models.ReportDetail;
import com.cs.iit.sar.models.Ride;
import com.cs.iit.sar.models.ViewReports;
import com.cs.iit.sar.services.exceptionchecker.ReportException;
import com.cs.iit.sar.utilities.UniqueIdGenerator;

public class ReportService implements ReportBoundaryInterface {

	private Map<Integer, Report> reportsMap = DataClass.getReportsMap();
	private Map<Integer, Ride> ridesMap = DataClass.getRidesMap();
	
	public List<ReportResponse> getAllReports() {
		
		if(reportsMap.isEmpty()) {
			Report ridesPostedReport = new Report();
			ridesPostedReport.setPid(UniqueIdGenerator.generateUniqueID());
			ridesPostedReport.setName("Rides posted between two dates");
			
			Report ridesTakenReport = new Report();
			ridesTakenReport.setPid(UniqueIdGenerator.generateUniqueID());
			ridesTakenReport.setName("Rides taken between two dates");

			reportsMap.put(ridesPostedReport.getPid(), ridesPostedReport);
			reportsMap.put(ridesTakenReport.getPid(), ridesTakenReport);
		} 
		
		ViewReports reports = new ViewReports();
		reports.setReports(new ArrayList<>(reportsMap.values()));
		
		ViewReportsResponse reportsResponse = ReportMapper.INSTANCE.toViewReportsDto(reports);
		return new ArrayList<>(reportsResponse.getReports());
	}
	
	public SingleReportResponse getReport(int pid, String startDate, String endDate) throws ParseException {
		
		ReportException.checkGetReport(pid);
		
		Report report = reportsMap.get(pid);
		
		if(report.getName().contains("posted")) {
			Report reportForRidesPosted = getReportForRidesPosted(pid, startDate, endDate);
			return ReportMapper.INSTANCE.toReportDto(reportForRidesPosted);
		} else {
			Report reportForRidesTaken = getReportForRidesTaken(pid, startDate, endDate);
			return ReportMapper.INSTANCE.toReportDto(reportForRidesTaken);
		}
	}

	private Report getReportForRidesPosted(int pid, String startDate, String endDate) throws ParseException {
		
		Report report = reportsMap.get(pid);
		
		List<ReportDetail> details = new ArrayList<>();
		
		startDate = ifEmptyDate(startDate);
		endDate = ifEmptyDate(endDate);
		
		Date start = getStartDateForReport(startDate);
		Date end = getEndDateForReport(endDate);
		
		int totalRides = 0;
		//ride, start, end, details,
		for(Ride ride : ridesMap.values()) {
			Date rideDate = getRideDate(ride.getDateTime().getDate());
			if(isDateInRange(rideDate, start, end)) {
				
				String fromZip = ride.getLocationInfo().getFromZip();
				String toZip = ride.getLocationInfo().getToZip();
				
				int count = 0;
				
				boolean isMatch = false;
				
				if(details.isEmpty()) {
					ReportDetail detail = new ReportDetail(fromZip, toZip, ++count);
					details.add(detail);
				} else {
					for(ReportDetail detail : details) {
						if(isFromToZipMatch(detail, fromZip, toZip)) {
							count = detail.getCount();
							detail.setCount(++count);
							isMatch = true;
							break;
						}
					}
					if(!isMatch) {
						ReportDetail detail = new ReportDetail(fromZip, toZip, ++count);
						details.add(detail);
					}
				}
				totalRides++;
			}
		
		}
		report.setStartDate(startDate);
		report.setEndDate(endDate);
		report.setRides(totalRides);
		report.setDetail(details);
		return report;
	}
		
	private Report getReportForRidesTaken(int pid, String startDate, String endDate) throws ParseException {
		
		Report report = reportsMap.get(pid);
		
		List<ReportDetail> details = new ArrayList<>();
		
		startDate = ifEmptyDate(startDate);
		endDate = ifEmptyDate(endDate);
	
		Date start = getStartDateForReport(startDate);
		Date end = getEndDateForReport(endDate);
		
		int totalRides = 0;
		
		for(Ride ride : ridesMap.values()) {
			Date rideDate = getRideDate(ride.getDateTime().getDate());
			if(isDateInRange(rideDate, start, end, ride.isTripCompleted())) {
				
				String fromZip = ride.getLocationInfo().getFromZip();
				String toZip = ride.getLocationInfo().getToZip();
				
				int count = 0;
				
				boolean isMatch = false;
				
				if(details.isEmpty()) {
					ReportDetail detail = new ReportDetail(fromZip, toZip, ++count);
					details.add(detail);
				} else {
					for(ReportDetail detail : details) {
						if(isFromToZipMatch(detail, fromZip, toZip)) {
							count = detail.getCount();
							detail.setCount(++count);
							isMatch = true;
							break;
						}
					}
					if(!isMatch) {
						ReportDetail detail = new ReportDetail(fromZip, toZip, ++count);
						details.add(detail);
					}
				}
				totalRides++;
			}
		
		}
		report.setStartDate(startDate);
		report.setEndDate(endDate);
		report.setRides(totalRides);
		report.setDetail(details);
		return report;
	}
	
	boolean isDateInRange(Date rideDate, Date start, Date end) {
		if((rideDate.after(start) || rideDate.equals(start)) 
					&& (rideDate.before(end) || rideDate.equals(end)))	{
			return true;
		}
		return false;
	}
	
	boolean isDateInRange(Date rideDate, Date start, Date end, boolean isRideCompleted) {
		if((rideDate.after(start) || rideDate.equals(start)) 
					&& (rideDate.before(end) || rideDate.equals(end))
					&& isRideCompleted)	{
			return true;
		}
		return false;
	}
	
	boolean isFromToZipMatch(ReportDetail detail, String fromZip, String toZip) {
		if(detail.getFromZip().equals(fromZip) && detail.getToZip().equals(toZip)) {
			return true;
		}
		return false;
	}
	
	String ifEmptyDate(String date) {
		if(date == null || date.isBlank()) {
			return "";
		}
		return date;
	}

	Date getStartDateForReport(String start) throws ParseException {
		if(start == null || start.isBlank()) {
			return new Date(Long.MIN_VALUE);
		}
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		return dateFormat.parse(start);
	}
	
	Date getEndDateForReport(String end) throws ParseException {
		if(end == null || end.isBlank()) {
			return new Date(Long.MAX_VALUE);
		} 
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		return dateFormat.parse(end);
	}

	private Date getRideDate(String date) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		return dateFormat.parse(date);
	}
}
