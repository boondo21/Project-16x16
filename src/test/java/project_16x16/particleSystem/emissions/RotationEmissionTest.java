package project_16x16.particleSystem.emissions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PVector;

class RotationEmissionTest {
	/**
	 * Purpose: Test for copy()
	 * Input: no Input to the method
	 * Expected:
	 * 		return RotationEmission object with same values
	 */
	@Test
	void testCopy() {
		PVector vector = new PVector(0, 0);
		RotationEmission rotation = new RotationEmission(vector, 0, 0, 0, 0);
		RotationEmission copy = (RotationEmission) rotation.copy();
		assertNotNull(copy);
		assertEquals(copy.getVelocity(), rotation.getVelocity());
		assertEquals(copy.getAcceleration(), rotation.getAcceleration());
		assertEquals(copy.getSpread(), rotation.getSpread());
		assertEquals(copy.getDiv(), rotation.getDiv());
	}

}
