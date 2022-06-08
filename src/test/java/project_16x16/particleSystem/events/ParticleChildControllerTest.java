package project_16x16.particleSystem.events;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import project_16x16.SideScroller;
import project_16x16.particleSystem.Particle;
import project_16x16.particleSystem.ParticleSystem;

class ParticleChildControllerTest {
	/**
	 * Purpose: Test for Constructor()
	 * Input: (ParticleSystem system, delay - 5)
	 * Expected:
	 * 		ParticleChildController object with given delay value
	 */
	@Test
	void testParticleChildControllerParticleSystemInt() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		ParticleChildController controller = new ParticleChildController(system, 5);
		assertEquals(controller.getDelay(), 5);
		assertTrue(controller.hasDelay());
		assertFalse(controller.isSpawnOnDeath());
	}
}
