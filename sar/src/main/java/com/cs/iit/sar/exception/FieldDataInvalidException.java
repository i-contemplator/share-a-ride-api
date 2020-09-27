package com.cs.iit.sar.exception;

import javax.ws.rs.BadRequestException;

public class FieldDataInvalidException extends BadRequestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4311778005127336446L;

	public FieldDataInvalidException(String message) {
		super(message);
	}

	
}
