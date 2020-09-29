package com.cs.iit.sar.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateCreatedTest extends DateCreated{

	@Test
	void testGetDateOrTime() {
		DateCreated.getDateOrTime("HH:mm:ss");
	}

}
