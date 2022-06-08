package project_16x16.particleSystem.events;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import project_16x16.SideScroller;
import project_16x16.particleSystem.Particle;
import project_16x16.particleSystem.ParticleSystem;

class ParticleNoLoopControllerTest {

	/**
	 * Purpose: Test for Constructor() 
	 * Input: spawnAmount - 20
	 * Expected:
	 * 		the values of the object fields should be equal to the given one
	 */
	@Test
	void testParticleNoLoopController() {
		ParticleNoLoopController controller = new ParticleNoLoopController(20);
		assertEquals(controller.getSpawnAmount(), 20);
		assertEquals(controller.getTotalSpawned(), 0);
	}
}
