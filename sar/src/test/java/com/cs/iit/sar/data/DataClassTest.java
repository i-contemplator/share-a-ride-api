package com.cs.iit.sar.data;

import org.junit.jupiter.api.Test;

class DataClassTest extends DataClass{

	@Test
	void testGetUsersMap() {
		DataClass.getUsersMap();
	}

	@Test
	void testGetRidesMap() {
		DataClass.getRidesMap();
	}

	@Test
	void testGetJoinRequestsMap() {
		DataClass.getJoinRequestsMap();
	}

	@Test
	void testGetMessagesMap() {
		DataClass.getMessagesMap();
	}

	@Test
	void testGetReportsMap() {
		DataClass.getReportsMap();
	}

}
