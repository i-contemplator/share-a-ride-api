package com.cs.iit.sar.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.cs.iit.sar.exception.FieldDataInvalidException;
import com.cs.iit.sar.exception.FieldDataMissingException;

@TestInstance(Lifecycle.PER_CLASS)
class CarTest {

	Car car;
	
	@BeforeAll
	void init() {
		car = new Car();
	}
	
	@Test
	void testSetMake_MakeShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class, 
				() -> car.setMake(null));
		assertTrue(e.getMessage().equals("car make appears to be null"));
	}
	
	@Test
	void testSetMake_MakeShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class, 
				() -> car.setMake(""));
		assertTrue(e.getMessage().equals("car make appears to be empty"));
	}
	
	@Test
	void testSetMake_MakeShouldBeValid_NoException() {
		assertDoesNotThrow(() -> car.setMake("Audi"));
	}

	@Test
	void testSetModel_ModelShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class, 
				() -> car.setModel(null));
		assertTrue(e.getMessage().equals("car model appears to be null"));
	}
	
	@Test
	void testSetModel_ModelShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class, 
				() -> car.setModel(""));
		assertTrue(e.getMessage().equals("car model appears to be empty"));
	}
	
	@Test
	void testSetModel_ModelShouldBeValid_NoException() {
		assertDoesNotThrow(() -> car.setModel("A4"));
	}
	
	@Test
	void testSetColor_ColorShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class, 
				() -> car.setColor(null));
		assertTrue(e.getMessage().equals("car color appears to be null"));
	}
	
	@Test
	void testSetColor_ColorShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class, 
				() -> car.setColor(""));
		assertTrue(e.getMessage().equals("car color appears to be empty"));
	}
	
	@Test
	void testSetColor_ColorhouldBeValid_NoException() {
		assertDoesNotThrow(() -> car.setColor("Gray"));
	}
	
	@Test
	void testSetPlateState_PlateStateShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class, 
				() -> car.setPlateState(null));
		assertTrue(e.getMessage().equals("car plate_state appears to be null"));
	}
	
	@Test
	void testSetPlateState_PlateStateShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class, 
				() -> car.setPlateState(""));
		assertTrue(e.getMessage().equals("car plate_state appears to be empty"));
	}
	
	@Test
	void testSetPlateState_PlateStatehouldBeValid_NoException() {
		assertDoesNotThrow(() -> car.setPlateState("IL"));
	}
	
	@Test
	void testSetPlateSerial_PlateSerialShouldBeNull_ExceptionThrown() {
		FieldDataInvalidException e = assertThrows(FieldDataInvalidException.class, 
				() -> car.setPlateSerial(null));
		assertTrue(e.getMessage().equals("car plate_serial appears to be null"));
	}
	
	@Test
	void testSetPlateSerial_PlateSerialShouldBeBlank_ExceptionThrown() {
		FieldDataMissingException e = assertThrows(FieldDataMissingException.class, 
				() -> car.setPlateSerial(""));
		assertTrue(e.getMessage().equals("car plate_serial appears to be empty"));
	}
	
	@Test
	void testSetPlateSerial_PlateSerialhouldBeValid_NoException() {
		assertDoesNotThrow(() -> car.setPlateSerial("COVID19"));
	}
	
}

