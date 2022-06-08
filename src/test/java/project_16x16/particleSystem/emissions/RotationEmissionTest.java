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

	/**
	 * Purpose: test for Construct() method
	 * Input: (vector, 0, 1, 2, 3)
	 * Expected:
	 * 		return RotationEmission object with given values
	 */
	@Test
	void testRotationEmission() {
		PVector vector = new PVector(0, 0);
		RotationEmission rotation = new RotationEmission(vector, 0, 1, 2, 3);
		assertNotNull(rotation);
		assertEquals(0, rotation.getVelocity());
		assertEquals(1, rotation.getAcceleration());
		assertEquals(2, rotation.getSpread());
		assertEquals(3, rotation.getDiv());
	}
	
	/**
	 * Purpose: test for generateNew() method
	 * Input: (vector, 10, -10, 5, 5)
	 * Expected:
	 * 		new values for velocity, acceleration, position
	 */
	@Test
	void testGenerateNew() {
		PVector vector = new PVector(0, 0);
		RotationEmission rotation = new RotationEmission(vector, 10, -10, 5, 5);
		rotation.generateNew();
		assertFalse(rotation.getVelocity() == rotation.newVelocity.x);
		assertFalse(rotation.getAcceleration() == rotation.newAcceleration.x);
		assertFalse(rotation.newPosition.x == 0);
		assertFalse(rotation.newPosition.y == 0);
	}

}
