package com.cs.iit.sar.models;

import com.cs.iit.sar.exception.FieldDataInvalidException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rating {
	private int sid;
	private Integer rid;
	private Integer sentById;
	private Integer accountToRate;
	private Integer rating;
	private String comment;
	private String date;
	private String firstName;
	
	public Rating(int sid, Integer rid, Integer rating, Integer sentById) {
		this.sid = sid;
		this.rid = rid;
		this.rating = rating;
		this.sentById = sentById;
	}
	public void setRid(Integer rid) {
		if(rid == null) {
			throw new FieldDataInvalidException("rid appears to be null");
		}
		this.rid = rid;
	}
	
	public void setSentById(Integer sentById) {
		if(sentById == null) {
			throw new FieldDataInvalidException("sent_by_id appears to be null");
		}
		this.sentById = sentById;
	}
	
	public void setRating(Integer rating) {
		if(rating == null) {
			throw new FieldDataInvalidException("rating appears to be null");
		}
		this.rating = rating;
	}
}
