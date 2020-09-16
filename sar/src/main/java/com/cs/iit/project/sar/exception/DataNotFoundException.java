package com.cs.iit.project.sar.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

public class DataNotFoundException extends NotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7445978958946919025L;

	public DataNotFoundException(Response response) {
		super(response);
	}

	
	
}
