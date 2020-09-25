package com.cs.iit.project.sar.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportDetail {
	private String fromZip;
	private String toZip;
	private int count;
	
	public ReportDetail(String fromZip, String toZip, int count) {
		super();
		this.fromZip = fromZip;
		this.toZip = toZip;
		this.count = count;
	}
}
