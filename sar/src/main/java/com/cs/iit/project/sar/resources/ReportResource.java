package com.cs.iit.project.sar.resources;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cs.iit.project.sar.models.Report;
import com.cs.iit.project.sar.repositories.ReportRepository;
import com.cs.iit.project.sar.resources.beans.ReportFilterBean;

@Path("reports")
public class ReportResource {

	ReportRepository repo = new ReportRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Report> getAllReports() {
		return repo.getAllReports();
	}
	
	@GET
	@Path("{pid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Report> getReport(@PathParam("pid") int pid, @BeanParam ReportFilterBean reportFilterBean) throws ParseException {
		if (reportFilterBean.getStart_date() != null && reportFilterBean.getEnd_date() != null) {
			return repo.getAllReportsBetweenDate(pid, reportFilterBean.getStart_date(), reportFilterBean.getEnd_date());
		}
		return repo.getAllReports();
	}
	
}
