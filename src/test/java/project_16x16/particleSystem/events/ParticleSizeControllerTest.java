package project_16x16.particleSystem.events;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import project_16x16.SideScroller;
import project_16x16.particleSystem.Particle;

class ParticleSizeControllerTest {
	/**
	 * Purpose: Test for Constructor() 
	 * Input: spawnAmount - 20
	 * Expected:
	 * 		the values of the object fields should be equal to the given one
	 */
	@Test
	void testParticleSizeController() {
		ParticleSizeController controller = new ParticleSizeController(10, 20);
		assertEquals(controller.getStartSize(), 10);
		assertEquals(controller.getEndSize(), 20);
	}
}
