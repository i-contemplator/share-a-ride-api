package com.cs.iit.sar.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
	private int sid;
	private Integer rid;
	private Integer sentById;
	private Integer accountToRate;
	private Integer rating;
	private String comment;
	private String date;
	private String firstName;
	
	public void setRid(Integer rid) {
		if(rid == null) {
			throw new NullPointerException("rid appears to be null");
		}
		this.rid = rid;
	}
	
	public void setSentById(Integer sentById) {
		if(sentById == null) {
			throw new NullPointerException("sent_by_id appears to be null");
		}
		this.sentById = sentById;
	}
	
	public void setRating(Integer rating) {
		if(rating == null) {
			throw new NullPointerException("rating appears to be null");
		}
		this.rating = rating;
	}
}
