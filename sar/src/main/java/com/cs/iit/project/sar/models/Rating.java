package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbProperty;

public class Rating {
	private int sid;
	private Integer rid;
	@JsonbProperty("sent_by_id")
	private Integer sentById;
	private Integer rating;
	private String comment;
	private String date;

	public Rating() {
		
	}
	
	public Rating(Integer rid, Integer sentById, Integer rating, String comment) {
		super();
		this.rid = rid;
		this.sentById = sentById;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getSentById() {
		return sentById;
	}

	public void setSentById(Integer sentById) {
		this.sentById = sentById;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}	
	
	public void setDate(String date) {
		this.date = date;
	}
}
