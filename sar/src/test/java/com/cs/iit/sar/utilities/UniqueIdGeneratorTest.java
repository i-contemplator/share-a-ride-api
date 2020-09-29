package com.cs.iit.sar.utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UniqueIdGeneratorTest extends UniqueIdGenerator{

	@Test
	void testUniqueIdGenerator_Success() {
		UniqueIdGenerator.generateUniqueID();
	}

}
