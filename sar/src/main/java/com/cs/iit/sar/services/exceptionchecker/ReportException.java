package com.cs.iit.sar.services.exceptionchecker;

import com.cs.iit.sar.services.exceptionchecker.validation.ReportValidation;

public class ReportException {
	
	public static void checkGetReport(int pid) {
		ReportValidation.validatePid(pid);
	}
}
