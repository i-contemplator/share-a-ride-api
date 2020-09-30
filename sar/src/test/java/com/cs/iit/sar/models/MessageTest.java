package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.exception.FieldDataMissingException;

@TestInstance(Lifecycle.PER_CLASS)
class MessageTest {

	Message message;
	
	@BeforeAll
	void init() {
		message = new Message();
	}
	
	@Test
	void testSetAid_AidShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class, 
				() -> message.setAid(null));
		assertTrue(e.getMessage().equals("aid appears to be null"));
	}
	
	@Test
	void testSetAid_AidShouldBeValid_NoException() {
		assertDoesNotThrow(() -> message.setAid(2));
	}
	
	@Test
	void testSetMsg_MsgShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class,
				() -> message.setMsg(null));
		assertTrue(e.getMessage().equals("msg appears to be null"));
	}
	
	@Test
	void testSetMsg_MsgShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class,
				() -> message.setMsg(""));
		assertTrue(e.getMessage().equals("msg appears to be empty"));
	}
	
	@Test
	void testSetMsg_MsgShouldBeValid_NoException() {
		assertDoesNotThrow(() -> message.setMsg("Where are you?"));
	}

}
