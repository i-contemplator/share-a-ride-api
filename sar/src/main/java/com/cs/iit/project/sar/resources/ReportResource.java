package com.cs.iit.project.sar.resources;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cs.iit.project.sar.dto.response.ReportResponse;
import com.cs.iit.project.sar.dto.response.SingleReportResponse;
import com.cs.iit.project.sar.resources.beans.ReportFilterBean;
import com.cs.iit.project.sar.services.ReportService;

@Path("reports")
public class ReportResource {

	ReportService repo = new ReportService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReportResponse> getAllReports() {
		return repo.getAllReports();
	}
	
	@GET
	@Path("{pid}")
	@Produces(MediaType.APPLICATION_JSON)
	public SingleReportResponse getReport(@PathParam("pid") int pid, @BeanParam ReportFilterBean reportFilterBean) throws ParseException {
		return repo.getReport(pid, reportFilterBean.getStartDate(), reportFilterBean.getEndDate());
	}
	
}
