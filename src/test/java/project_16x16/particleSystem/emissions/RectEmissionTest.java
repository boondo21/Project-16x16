package project_16x16.particleSystem.emissions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PVector;

class RectEmissionTest {
	/**
	 * Purpose: Test for copy()
	 * Input: no Input to the method
	 * Expected:
	 * 		return RectEmission object with same values
	 */
	@Test
	void testCopy() {
		PVector vector = new PVector(0, 0);
		RectEmission rect = new RectEmission(vector, 0, 0, 0, 0);
		RectEmission copy = (RectEmission) rect.copy();
		assertNotNull(copy);
		assertEquals(copy.getVelocity(), rect.getVelocity());
		assertEquals(copy.getAcceleration(), rect.getAcceleration());
		assertEquals(copy.getWidth(), rect.getWidth());
		assertEquals(copy.getHeight(), rect.getHeight());
	}

}
