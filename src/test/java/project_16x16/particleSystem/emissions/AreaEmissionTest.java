package project_16x16.particleSystem.emissions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import processing.core.PVector;

class AreaEmissionTest {
	
	/**
	 * Purpose: Test for copy()
	 * Input: no Input to the method
	 * Expected:
	 * 		return AreaEmission object with same values
	 */
	@Test
	void testCopy() {
		PVector vector = new PVector(0, 0);
		AreaEmission area = new AreaEmission(vector, 0, 0, 0);
		AreaEmission copy = (AreaEmission) area.copy();
		assertNotNull(copy);
		assertEquals(copy.getVelocity(), area.getVelocity());
		assertEquals(copy.getAcceleration(), area.getAcceleration());
		assertEquals(copy.getSpread(), area.getSpread());
	}

	/**
	 * Purpose: test for Construct() method
	 * Input: (vector, 0, 1, 2)
	 * Expected:
	 * 		return AreaEmission object with given values
	 */
	@Test
	void testAreaEmission() {
		PVector vector = new PVector(0, 0);
		AreaEmission area = new AreaEmission(vector, 0, 1, 2);
		assertNotNull(area);
		assertEquals(0, area.getVelocity());
		assertEquals(1, area.getAcceleration());
		assertEquals(2, area.getSpread());
	}
}
