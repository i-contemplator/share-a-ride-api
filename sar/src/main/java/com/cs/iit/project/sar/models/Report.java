package com.cs.iit.project.sar.models;

import java.util.List;

public class Report {
	private int pid;
	private String name;
	private String start_date;
	private String end_date;
	private int rides;
	private List<DetailReport> detail;
	
	public Report() {
		
	}
	
	public Report(int pid, String name, String start_date, String end_date, int rides, List<DetailReport> detail) {
		super();
		this.pid = pid;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
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
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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
