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

	/**
	 * Purpose: Test for onParticleSpawnEvent() 
	 * Input: Particle p with velocity set to PVector(1, 1)
	 * Expected:
	 * 		new acceleration should be equal to the sum of original and new accelerations
	 */
	@Test
	void testOnParticleSpawnEvent() {
		PVector acceleration = new PVector(0, 0);
		ParticleAccelerationController controller = new ParticleAccelerationController(acceleration);
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(applet, img);
		p.setAcceleration(new PVector(1, 1));
		controller.onParticleSpawnEvent(p);
		assertEquals(p.getAcceleration(), acceleration.add(new PVector(1, 1)));
	}
}
