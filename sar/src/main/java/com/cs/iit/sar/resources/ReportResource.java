package com.cs.iit.sar.resources;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cs.iit.sar.boundaryinterfaces.ReportBoundaryInterface;
import com.cs.iit.sar.dto.response.ReportResponse;
import com.cs.iit.sar.dto.response.SingleReportResponse;
import com.cs.iit.sar.resources.beans.ReportFilterBean;
import com.cs.iit.sar.services.ReportService;

@Path("reports")
public class ReportResource {

	ReportBoundaryInterface reportService = new ReportService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportResponse> getAllReports() {
		return reportService.getAllReports();
	}
	
	@GET
	@Path("{pid}")
	@Produces(MediaType.APPLICATION_JSON)
	public SingleReportResponse getReport(@PathParam("pid") int pid, @BeanParam ReportFilterBean reportFilterBean) throws ParseException {
		return reportService.getReport(pid, reportFilterBean.getStartDate(), reportFilterBean.getEndDate());
	}
	
}
