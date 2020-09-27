package com.cs.iit.sar.exception;

import javax.ws.rs.NotFoundException;

public class DataNotFoundException extends NotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7445978958946919025L;

	public DataNotFoundException(String message) {
		super(message);
	}

	
}
