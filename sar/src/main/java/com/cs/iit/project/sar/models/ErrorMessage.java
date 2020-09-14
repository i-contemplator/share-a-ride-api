package com.cs.iit.project.sar.models;

public class ErrorMessage {

	private String type;
	private String title;
	private String detail;
	private Integer status;
	private String instance;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String type, String title, String detail, Integer status, String instance) {
		super();
		this.type = type;
		this.title = title;
		this.detail = detail;
		this.status = status;
		this.instance = instance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}
	
}
