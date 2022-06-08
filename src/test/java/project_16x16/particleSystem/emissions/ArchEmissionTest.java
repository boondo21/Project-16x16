/**
 * 
 */
package project_16x16.particleSystem.emissions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import processing.core.PVector;
import project_16x16.particleSystem.Particle;

class ArchEmissionTest {

	/**
	 * Purpose: Test for copy()
	 * Input: no Input to the method
	 * Expected:
	 * 		return ArchEmission object with same values
	 */
	@Test
	void testCopy() {
		PVector vector = new PVector(0, 0);
		ArchEmission arch = new ArchEmission(vector, 0, 0, 0, 0, 0);
		ArchEmission copy = (ArchEmission) arch.copy();
		assertNotNull(copy);
		assertEquals(copy.getVelocity(), arch.getVelocity());
		assertEquals(copy.getAcceleration(), arch.getAcceleration());
		assertEquals(copy.getSpread(), arch.getSpread());
		assertEquals(copy.getMinAngle(), arch.getMinAngle());
		assertEquals(copy.getMaxAngle(), arch.getMaxAngle());
	}

	/**
	 * Purpose: test for Construct() method
	 * Input: (vector, 0, 1, 2, 3, 4)
	 * Expected:
	 * 		return ArchEmission object with given values
	 */
	@Test
	void testArchEmission() {
		PVector vector = new PVector(0, 0);
		ArchEmission arch = new ArchEmission(vector, 0, 1, 2, 3, 4);
		assertNotNull(arch);
		assertEquals(0, arch.getVelocity());
		assertEquals(1, arch.getAcceleration());
		assertEquals(2, arch.getSpread());
		assertEquals(3, arch.getMinAngle());
		assertEquals(4, arch.getMaxAngle());
	}

	/**
	 * Purpose: test for generateNew() method
	 * Input: (vector, 10, -10, 10, 5, 1)
	 * Expected:
	 * 		new values for velocity, acceleration, position
	 */
	@Test
	void testGenerateNew() {
		PVector vector = new PVector(0, 0);
		ArchEmission arch = new ArchEmission(vector, 10, -10, 10, 5, 1);
		arch.generateNew();
		assertFalse(arch.getVelocity() == arch.newVelocity.x);
		assertFalse(arch.getAcceleration() == arch.newAcceleration.x);
		assertFalse(arch.newPosition.x == 0);
		assertFalse(arch.newPosition.y == 0);
	}

}
