package project_16x16.particleSystem.events;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.particleSystem.Particle;

class ParticleAccelerationControllerTest {


	/**
	 * Purpose: Test for Constructor() 
	 * Input: PVector(0, 0)
	 * Expected:
	 * 		ParticleAccelerationController object with the same value for acceleration as given
	 */
	@Test
	void testParticalAccelerationController() {
		ParticleAccelerationController controller = new ParticleAccelerationController(new PVector(0, 0));
		assertEquals(controller.getAcceleration(), new PVector(0, 0));
	}
}
