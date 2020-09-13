package com.cs.iit.project.sar.models;

import javax.json.bind.annotation.JsonbProperty;

public class Rating {
	private int sid;
	private int rid;
	@JsonbProperty("sent_by_id")
	private int sentById;
	private int rating;
	private String comment;
	private String date;

	public Rating() {
		
	}
	
	public Rating(int rid, int sentById, int rating, String comment) {
		super();
		this.rid = rid;
		this.sentById = sentById;
		this.rating = rating;
		this.comment = comment;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getSentById() {
		return sentById;
	}

	public void setSentById(int sentById) {
		this.sentById = sentById;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
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
