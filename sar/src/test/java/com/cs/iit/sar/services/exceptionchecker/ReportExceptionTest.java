package com.cs.iit.sar.services.exceptionchecker;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.models.Report;

class ReportExceptionTest extends ReportException{

	@Test
	void testCheckGetReport_PidShouldExist_Successful() {
		
		Map<Integer, Report> reportsMap = DataClass.getReportsMap();
		reportsMap.put(1, new Report());
		ReportException.checkGetReport(1);
	}

}
