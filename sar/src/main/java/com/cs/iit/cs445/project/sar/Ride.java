package com.cs.iit.cs445.project.sar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ride {
	
	private int rid;
	private String name;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override	
	public String toString() {
		return "Ride [rid=" + rid + ", name=" + name + "]";
	}
	
	

}
