package com.cs.iit.project.sar.models;

public class Message {
	
	private int mid;
	private Integer aid;
	private String msg;
	private String date;
	
	public Message() {
		
	}
	
	public Message(String msg, Integer aid) {
		super();
		this.msg = msg;
		this.aid = aid;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
