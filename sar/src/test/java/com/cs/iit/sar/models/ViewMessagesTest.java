package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ViewMessagesTest extends ViewMessages {
	
	@Test
	void testViewMessagesTest_Success() {
		ViewMessages messages = new ViewMessages();
	}
}
