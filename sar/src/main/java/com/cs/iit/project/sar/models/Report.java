package com.cs.iit.project.sar.models;

import java.util.List;

public class Report {
	private int pid;
	private String name;
	private String startDate;
	private String endDate;
	private int rides;
	private List<DetailReport> detail;
	
	public Report() {
		
	}
	
	public Report(int pid, String name, String startDate, String endDate, int rides, List<DetailReport> detail) {
		super();
		this.pid = pid;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.rides = rides;
		this.detail = detail;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getRides() {
		return rides;
	}
	public void setRides(int rides) {
		this.rides = rides;
	}
	public List<DetailReport> getDetail() {
		return detail;
	}
	public void setDetail(List<DetailReport> detail) {
		this.detail = detail;
	}
	
	
}
