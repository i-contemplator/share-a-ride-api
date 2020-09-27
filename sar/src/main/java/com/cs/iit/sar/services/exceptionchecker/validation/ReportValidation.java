package com.cs.iit.sar.services.exceptionchecker.validation;

import java.util.Map;

import com.cs.iit.sar.data.DataClass;
import com.cs.iit.sar.exception.DataNotFoundException;
import com.cs.iit.sar.models.Report;

public class ReportValidation {

	private static Map<Integer, Report> reportsMap = DataClass.getReportsMap();

	public static void validatePid(int pid) {
		if(!reportsMap.containsKey(pid)) {
			throw new DataNotFoundException(pid + " doesn't exist");
		}
	}
}
