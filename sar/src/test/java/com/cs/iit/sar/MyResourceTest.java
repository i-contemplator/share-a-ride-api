package com.cs.iit.sar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyResourceTest {

	@Test
	void test() {
		MyResource homeResource = new MyResource();
		homeResource.getIt();
	}

}
