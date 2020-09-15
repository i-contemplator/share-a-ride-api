package com.cs.iit.project.sar.exception;

import javax.ws.rs.BadRequestException;

public class FieldDataMissingException extends BadRequestException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7165000587377399866L;

	public FieldDataMissingException(String message) {
		super(message);
	}

}
