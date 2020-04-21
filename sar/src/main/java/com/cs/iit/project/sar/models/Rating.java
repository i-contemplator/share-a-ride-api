package com.cs.iit.project.sar.models;

public class Rating {
	private int rid;
	private int sent_by_id;
	private int rating;
	private String comment;
	private int sid;
	private String date;

	public Rating() {
		
	}
	
	public Rating(int rid, int sent_by_id, int rating, String comment) {
		super();
		this.rid = rid;
		this.sent_by_id = sent_by_id;
		this.rating = rating;
		this.comment = comment;
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getSent_by_id() {
		return sent_by_id;
	}

	public void setSent_by_id(int sent_by_id) {
		this.sent_by_id = sent_by_id;
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
