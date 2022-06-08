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
}
