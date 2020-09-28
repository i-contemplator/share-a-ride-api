package com.cs.iit.sar.services.exceptionchecker.validation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.DataNotFoundException;
import com.cs.iit.sar.models.Report;

@TestInstance(Lifecycle.PER_CLASS)
class ReportValidationTest extends ReportValidation{

	Report report;
	Map<Integer, Report> reportsMap;
	
	@BeforeAll
	void init() {
		report = new Report();
		report.setPid(1);
		reportsMap = DataClass.getReportsMap();
		reportsMap.put(1, report);
	}
	
	@AfterAll
	void cleanUp() {
		reportsMap.clear();
	}
	
	@Test
	void validatePid_PidOfReportThatShouldNotExist_ExceptionThrown() {
		
		DataNotFoundException exception = assertThrows(DataNotFoundException.class,
				() -> ReportValidation.validatePid(2));
		assertTrue(exception.getMessage().contains("2 doesn't exist"));
	}
	
	@Test
	void validatePid_PidOfReportThatShouldExist_NoException() {
		
		assertDoesNotThrow(() -> ReportValidation.validatePid(1));
	}

}
