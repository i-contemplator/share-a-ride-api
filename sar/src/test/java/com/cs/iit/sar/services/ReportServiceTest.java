package com.cs.iit.sar.services;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.models.Car;
import com.cs.iit.sar.models.DateTime;
import com.cs.iit.sar.models.LocationInfo;
import com.cs.iit.sar.models.Report;
import com.cs.iit.sar.models.ReportDetail;
import com.cs.iit.sar.models.Ride;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class ReportServiceTest extends ReportService{

	Map<Integer, Report> reportsMap;
	Map<Integer, Ride> ridesMap;
	ReportService service = new ReportService();
	
	LocationInfo location1;
	LocationInfo location2;
	LocationInfo location3;
	LocationInfo location4;
	LocationInfo location5;
	DateTime dateTime1;
	DateTime dateTime2;
	DateTime dateTime3;
	DateTime dateTime4;
	DateTime dateTime5;
	Ride ride1;
	Ride ride2;
	Ride ride3;
	Ride ride4;
	Ride ride5;
	
	
	@BeforeAll
	void init() {
		reportsMap = DataClass.getReportsMap();
		ridesMap = DataClass.getRidesMap();
		
		location1 = new LocationInfo("Chicago", "60640", "Los Angelos", "53202");
		location2 = new LocationInfo("SpringField", "60640", "Seattle", "");
		location3 = new LocationInfo("Austin", "60640", "Houston", "");
		location4 = new LocationInfo("Chicago", "60640", "Houston", "53202");
		location5 = new LocationInfo("Chicago", "60640", "Houston", "53202");
		
		dateTime1 = new DateTime("14-Apr-2020", "23:32");
		dateTime2 = new DateTime("15-Apr-2020", "12:35");
		dateTime3 = new DateTime("14-Apr-2020", "02:32");
		dateTime4 = new DateTime("15-Apr-2020", "02:32");
		dateTime5 = new DateTime("14-Apr-2020", "03:35");
		
		ride1 = new Ride(1, 1, location1, dateTime1, new Car(), 5, 3.5);
		ride2 = new Ride(2, 2, location2, dateTime2, new Car(), 4, 4.5);
		ride3 = new Ride(3, 3, location3, dateTime3, new Car(), 3, 5.5);
		ride3.setTripCompleted(true);
		ride4 = new Ride(4, 4, location4, dateTime4, new Car(), 4, 6.5);
		ride4.setTripCompleted(true);
		ride5 = new Ride(5, 5, location5, dateTime5, new Car(), 5, 9.5);
		ride5.setTripCompleted(true);
		
		ridesMap.put(1, ride1);
		ridesMap.put(2, ride2);
		ridesMap.put(3, ride3);
		ridesMap.put(4, ride4);
		ridesMap.put(5, ride5);
		
	}

	@AfterAll
	void cleanUp() {
		reportsMap.clear();
		ridesMap.clear();
	}
	
	@Test
	@Order(1)
	void testGetAllReports_NoReportsThereNewCreated_Successful() {
		service.getAllReports();
	}
	
	@Test
	@Order(2)
	void testGetAllReports_ReportsAlreadyExist_Successful() {
		service.getAllReports();
	}
	
	@Test
	void testGetSingleReport_ReportForRidesPosted_Successful() throws ParseException {
		service.getReport(1, "14-Apr-2020", "14-Apr-2020");
	}
	
	@Test
	void testGetSingleReport_ReportForRidesTaken_Successful() throws ParseException {
		service.getReport(2, "14-Apr-2020", "14-Apr-2020");
	}
	
	@Test
	void testGetSingleReport_ReportForRidesPostedDetailFromToZipShouldMatch_Successful() throws ParseException {
		service.getReport(1, "14-Apr-2020", "14-Apr-2020");
	}
	
	@Test
	void testGetSingleReport_ReportForRidesTakenDateShouldMatch_Successful() throws ParseException {
		service.getReport(2, "14-Apr-2020", "14-Apr-2020");
	}
	
	@Test
	void testGetSingleReport_ReportForRidesTakenShouldNotMatch_Successful() throws ParseException {
		service.getReport(2, "10-Apr-2020", "24-Apr-2020");	
	}
	
	@Test
	void testIsDateInRange_DateIsInTheRangeEndDateEmptyRange_ReturnFalse() throws ParseException {
		service.getReport(1, "15-Apr-2020", "");
	}
	
	@Test
	void testIsDateInRange_DateIsInTheRange_ReturnFalse() throws ParseException {
		service.getReport(1, "15-Apr-2020", "15-Apr-2020");
	}
	
	@Test
	void testIsDataInRange_DateIsInTheRangeCompleted_ReturnTrue() throws ParseException {
		service.getReport(2, "15-Apr-2020", "");
	}
	
	@Test
	void testIsDataInRange_DateIsOnTheRangeCompleted_ReturnTrue() throws ParseException {
		service.getReport(2, "15-Apr-2020", "15-Apr-2020");
	}
	
	@Test
	void testIsFromToZipMatch_FromNotEqual_ReturnFalse() {
		ReportDetail detail = new ReportDetail("60616", "32333", 0);
		
		assertFalse(service.isFromToZipMatch(detail, "60612", "32333"));
	}
	
	@Test
	void testIfEmptyDate_StringDateIsEmpty_ReturnFalse() {
		assertEquals(service.ifEmptyDate(null), "");
	}
	
	@Test
	void testStartDateForReport_StartDateIsNull_ReturnFalse() throws ParseException {
		assertEquals(service.getStartDateForReport(null), new Date(Long.MIN_VALUE));
	}
	
	@Test
	void testStartDateForReport_StartDateIsEmpty_ReturnFalse() throws ParseException {
		assertEquals(service.getStartDateForReport(""), new Date(Long.MIN_VALUE));
	}
	
	@Test
	void testEndDateForReport_EndDatIsNull_ReturnFalse() throws ParseException {
		assertEquals(service.getEndDateForReport(null), new Date(Long.MAX_VALUE));
	}
}
