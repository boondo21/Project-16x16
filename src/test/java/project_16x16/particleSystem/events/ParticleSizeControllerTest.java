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

	/**
	 * Purpose: Test for onParticleSpawnEvent() 
	 * Input: Particle p
	 * Expected:
	 * 		useCustomSize in p should be true
	 */
	@Test
	void testOnParticleSpawnEvent() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(applet, img);
		ParticleSizeController controller = new ParticleSizeController(10, 20);
		controller.onParticleSpawnEvent(p);
		assertTrue(p.isUseCustomeSize());
	}

	/**
	 * Purpose: Test for onParticleRunEvent() 
	 * Input: Particle p
	 * Expected:
	 * 		size in p should be equal to the one we calculated by values from controller
	 */
	@Test
	void testOnParticleRunEvent() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(applet, img);
		ParticleSizeController controller = new ParticleSizeController(10, 20);
		controller.onParticleRunEvent(p);
		float size = p.getLifespan()/p.getMaxLifespan()*(controller.getStartSize()-controller.getEndSize())+controller.getEndSize();
		assertEquals(p.getSize(), size);
	}
}
