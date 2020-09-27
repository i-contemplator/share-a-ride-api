package com.cs.iit.sar.models;

import com.cs.iit.sar.exception.FieldDataMissingException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	private int mid;
	private Integer aid;
	private String msg;
	private String date;
	
	public void setAid(Integer aid) {
		if(aid == null) {
			throw new NullPointerException("aid appears to be null");
		}
		this.aid = aid;
	}
	
	public void setMsg(String msg) {
		if(msg == null) {
			throw new NullPointerException("msg appears to be null");
		}
		if(msg.isBlank()) {
			throw new FieldDataMissingException("msg appears to be empty");
		}
		this.msg = msg;
	}
}