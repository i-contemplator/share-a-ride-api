package com.cs.iit.project.sar.utilities;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
	
	private static AtomicInteger atomicInteger = new AtomicInteger();
	
	public static int generateUniqueID() {
		return atomicInteger.incrementAndGet();
	}
}
