package com.cs.iit.sar.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ViewMessagesTest extends ViewMessages {
	
	@Test
	void testViewMessagesTest_Success() {
		new ViewMessages();
	}
}
