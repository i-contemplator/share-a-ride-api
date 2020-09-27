package com.cs.iit.sar.utilities;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
	
	private static AtomicInteger atomicInteger = new AtomicInteger();
	
	public static int generateUniqueID() {
		return atomicInteger.incrementAndGet();
	}
}
