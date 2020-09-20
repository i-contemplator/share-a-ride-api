package com.cs.iit.project.sar.models;

public class DetailReport {
	private String fromZip;
	private String toZip;
	private int count;
	
	public DetailReport() {
		
	}
	
	public DetailReport(String fromZip, String toZip, int count) {
		super();
		this.fromZip = fromZip;
		this.toZip = toZip;
		this.count = count;
	}
	public String getFromZip() {
		return fromZip;
	}
	public void setFromZip(String fromZip) {
		this.fromZip = fromZip;
	}
	public String getToZip() {
		return toZip;
	}
	public void setToZip(String toZip) {
		this.toZip = toZip;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
