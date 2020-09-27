package com.cs.iit.sar.exception;

import javax.ws.rs.BadRequestException;

public class FieldDataMissingException extends BadRequestException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7165000587377399866L;

	public FieldDataMissingException(String message) {
		super(message);
		System.out.println("Hello in exception class");
	}

}
