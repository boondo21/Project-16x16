package project_16x16.particleSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import project_16x16.SideScroller;

class ParticlesHandlerTest {

	/**
	 * Purpose: Test for Constructor()
	 * Input: (ParticleSystem system, SideScroller applet)
	 * Expected:
	 * 		return ParticlesHandler with given objects
	 */
	@Test
	void testParticlesHandler() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(null, img, 0, 0, 0);
		ParticlesHandler handler = new ParticlesHandler(system, applet);
		assertNotNull(handler);
		assertEquals(handler.getApplet(), applet);
		assertEquals(handler.getParticleSystem(), system);
	}

	/**
	 * Purpose: Test for newParticle()
	 * Input: no input for newParticle()
	 * Expected:
	 * 		it should return new particle
	 */
	@Test
	void testNewParticle() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(null, img, 5, 5, 5);
		ParticlesHandler handler = new ParticlesHandler(system, applet);
		Particle p = handler.newParticle();
		assertNotNull(p);
	}
	
	/**
	 * Purpose: Test for run()
	 * Input: no input for run(). PartycleSystem has 1 for spawnAmount
	 * Expected:
	 * 		there should be only 1 active particle even after new particle, because it health will be 0
	 */
	@Test
	void testRun() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(null, img, 1, 1, 0);
		ParticlesHandler handler = new ParticlesHandler(system, applet);
		handler.run();
		assertTrue(handler.getActiveParticles().size() == 1);
		handler.newParticle();
		handler.run();
		assertTrue(handler.getActiveParticles().size() == 1);
	}

	/**
	 * Purpose: Test for hasActiveParticles()
	 * Input: no input for hasActiveParticles()
	 * Expected:
	 * 		there should be 0 active particles before new one and 1 after newParticle() is called
	 */
	@Test
	void testHasActiveParticles() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(null, img, 5, 5, 5);
		ParticlesHandler handler = new ParticlesHandler(system, applet);
		assertFalse(handler.hasActiveParticles());
		handler.newParticle();
		assertTrue(handler.hasActiveParticles());
	}

}
