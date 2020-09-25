package com.cs.iit.project.sar.models;

import lombok.Data;

@Data
public class Rating {
	
	private int sid;
	private Integer rid;
	private Integer sentById;
	private Integer accountToRate;
	private Integer rating;
	private String comment;
	private String date;
	private String firstName;

	public Rating() {
		
	}
	
	public Rating(Integer rid, Integer sentById, Integer rating, String comment) {
		super();
		this.rid = rid;
		this.sentById = sentById;
		this.rating = rating;
		this.comment = comment;
	}
}
