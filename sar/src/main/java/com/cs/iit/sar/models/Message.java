package com.cs.iit.sar.models;

import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.exception.FieldDataMissingException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {
	private int mid;
	private Integer aid;
	private String msg;
	private String date;
	
	public Message(Integer aid, String msg) {
		this.aid = aid;
		this.msg = msg;
	}
	
	public void setAid(Integer aid) {
		if(aid == null) {
			throw new FieldDataInvalidException("aid appears to be null");
		}
		this.aid = aid;
	}
	
	public void setMsg(String msg) {
		if(msg == null) {
			throw new FieldDataInvalidException("msg appears to be null");
		}
		if(msg.isBlank()) {
			throw new FieldDataMissingException("msg appears to be empty");
		}
		this.msg = msg;
	}
}