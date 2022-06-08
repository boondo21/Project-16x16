package project_16x16.particleSystem.emissions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PVector;

class DirectionalEmissionTest {

	/**
	 * Purpose: Test for copy()
	 * Input: no Input to the method
	 * Expected:
	 * 		return DirectionalEmission object with same values
	 */
	@Test
	void testCopy() {
		PVector vector = new PVector(0, 0);
		DirectionalEmission direct = new DirectionalEmission(vector, 0, 0, 0, 0);
		DirectionalEmission copy = (DirectionalEmission) direct.copy();
		assertNotNull(copy);
		assertEquals(copy.getVelocity(), direct.getVelocity());
		assertEquals(copy.getAcceleration(), direct.getAcceleration());
		assertEquals(copy.getSpread(), direct.getSpread());
		assertEquals(copy.getAngle(), direct.getAngle());
	}

	/**
	 * Purpose: test for Construct() method
	 * Input: (vector, 0, 1, 2, 3)
	 * Expected:
	 * 		return DirectionalEmission object with given values
	 */
	@Test
	void testDirectionalEmission() {
		PVector vector = new PVector(0, 0);
		DirectionalEmission direct = new DirectionalEmission(vector, 0, 1, 2, 3);
		assertNotNull(direct);
		assertEquals(0, direct.getVelocity());
		assertEquals(1, direct.getAcceleration());
		assertEquals(2, direct.getSpread());
		assertEquals(3, direct.getAngle());
	}
	
	/**
	 * Purpose: test for generateNew() method
	 * Input: (vector, 10, -10, 10, 5)
	 * Expected:
	 * 		new values for velocity, acceleration, position
	 */
	@Test
	void testGenerateNew() {
		PVector vector = new PVector(1, 1);
		DirectionalEmission direct = new DirectionalEmission(vector, 10, -10, 10, 5);
		direct.generateNew();
		assertFalse(direct.getVelocity() == direct.newVelocity.x);
		assertFalse(direct.getAcceleration() == direct.newAcceleration.x);
		assertFalse(direct.position.x == 1);
		assertFalse(direct.position.y == 1);
	}

}
