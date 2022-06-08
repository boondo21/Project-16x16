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

	/**
	 * Purpose: Test for onCreateEvent() 
	 * Input: ParticleSystem system
	 * Expected:
	 * 		controller has the system given to him
	 */
	@Test
	void testOnCreateEvent() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		ParticleNoLoopController controller = new ParticleNoLoopController(20);
		controller.onCreateEvent(system);
		assertSame(controller.getParticleSystem(), system);		
	}
	
	/**
	 * Purpose: Test for reset() 
	 * Input: no input for reset()
	 * Expected:
	 * 		totalSpawned number should be 0
	 * 		PartycleSystem.isSpawn should be true
	 */
	@Test
	void testReset() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		ParticleNoLoopController controller = new ParticleNoLoopController(20);
		controller.onCreateEvent(system);
		controller.reset();
		assertEquals(controller.getTotalSpawned(), 0);
		assertTrue(controller.getParticleSystem().isSpawn());
	}

	/**
	 * Purpose: Test for onParticleSpawnEvent() 
	 * Input: Particle p
	 * Expected:
	 * 		totalSpawned number should increase by 1 everytime it called
	 * 		PartycleSystem.isSpawn should be true until the last spawned particle
	 */
	@Test
	void testOnParticleSpawnEvent() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(applet, img);
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		ParticleNoLoopController controller = new ParticleNoLoopController(2);
		controller.onCreateEvent(system);
		controller.reset();
		
		controller.onParticleSpawnEvent(p);
		assertEquals(controller.getTotalSpawned(), 1);
		assertTrue(controller.getParticleSystem().isSpawn());
		
		controller.onParticleSpawnEvent(p);
		assertEquals(controller.getTotalSpawned(), 2);
		assertFalse(controller.getParticleSystem().isSpawn());
	}
}
