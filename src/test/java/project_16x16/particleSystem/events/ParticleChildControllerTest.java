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

	/**
	 * Purpose: Test for Constructor()
	 * Input: (ParticleSystem system, delay - 5, spawnOnDeath - true)
	 * Expected:
	 * 		ParticleChildController object with given values
	 */
	@Test
	void testParticleChildControllerParticleSystemIntBoolean() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		
		ParticleChildController controller = new ParticleChildController(system, 5, true);
		assertEquals(controller.getDelay(), 5);
		assertTrue(controller.hasDelay());
		assertTrue(controller.isSpawnOnDeath());
	}
	
	/**
	 * Purpose: Test for Constructor()
	 * Input: (ParticleSystem system, delay - 5, spawnOnDeath - false)
	 * Expected:
	 * 		ParticleChildController object with given values
	 */
	@Test
	void testParticleChildControllerParticleSystemIntBoolean2() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);

		ParticleChildController controller = new ParticleChildController(system, 5, false);
		assertEquals(controller.getDelay(), 5);
		assertTrue(controller.hasDelay());
		assertFalse(controller.isSpawnOnDeath());
	}

	/**
	 * Purpose: Test for Constructor()
	 * Input: (ParticleSystem system, spawnOnDeath - true)
	 * Expected:
	 * 		ParticleChildController object with given spawnOnDeath value and no delay
	 */
	@Test
	void testParticleChildControllerParticleSystemBoolean() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);

		ParticleChildController controller = new ParticleChildController(system, true);
		assertFalse(controller.hasDelay());
		assertTrue(controller.isSpawnOnDeath());
	}

	/**
	 * Purpose: Test for Constructor()
	 * Input: (ParticleSystem system, spawnOnDeath - false)
	 * Expected:
	 * 		ParticleChildController object with given spawnOnDeath value and no delay
	 */
	@Test
	void testParticleChildControllerParticleSystemBoolean2() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);

		ParticleChildController controller = new ParticleChildController(system, false);
		assertFalse(controller.hasDelay());
		assertFalse(controller.isSpawnOnDeath());
	}
	
	/**
	 * Purpose: Test for onUpdateEvent()
	 * Input: no input for onUpdateEvent()
	 * Expected:
	 * 		update the number of ParticleSystems so that those without particles are removed
	 * 		its number should be 0
	 */
	@Test
	void testOnUpdateEvent() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		
		ParticleChildController controller = new ParticleChildController(system, 0, true);
		controller.onUpdateEvent();
		assertEquals(controller.getParticleSystems().size(), 0);
	}

	/**
	 * Purpose: Test for onParticleRunEvent()
	 * Input: Particle p
	 * Expected:
	 * 		now there is one more particleSystem with active particle
	 * 		its number should be 1
	 */
	@Test
	void testOnParticleRunEvent() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(applet, img);
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		
		ParticleChildController controller = new ParticleChildController(system, 0, true);
		controller.onParticleRunEvent(p);
		assertEquals(controller.getParticleSystems().size(), 1);
	}

	/**
	 * Purpose: Test for onParticleDeathEvent()
	 * Input: Particle p
	 * Expected:
	 * 		if the value of isSpawnedOnDeath is true
	 * 		new Particle created after death immediately
	 * 		number of particleSystems should be 1
	 */
	@Test
	void testOnParticleDeathEvent() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(applet, img);
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		
		ParticleChildController controller = new ParticleChildController(system, 5, true);
		controller.onParticleDeathEvent(p);
		assertEquals(controller.getParticleSystems().size(), 1);
	}

	/**
	 * Purpose: Test for copy()
	 * Input: no input for copy()
	 * Expected:
	 * 		the new ParticleChildController object
	 * 		which has the same delay value
	 */
	@Test
	void testCopy() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		
		ParticleChildController controller = new ParticleChildController(system, 5, true);
		ParticleChildController copy = (ParticleChildController) controller.copy();
		assertEquals(controller.getDelay(), copy.getDelay());
		assertEquals(controller.hasDelay(), copy.hasDelay());
	}

}
