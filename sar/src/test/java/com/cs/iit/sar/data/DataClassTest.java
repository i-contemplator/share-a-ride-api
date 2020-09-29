package com.cs.iit.sar.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import com.cs.iit.sar.models.User;

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
