package project_16x16.particleSystem.events;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.particleSystem.Particle;
import project_16x16.particleSystem.ParticlePreloadSystem;

class ParticalVelocityControllerTest {
	/**
	 * Purpose: Test for Constructor() 
	 * Input: PVector(0, 0)
	 * Expected:
	 * 		ParticalVelocityController object with the same value for velocity as given
	 */
	@Test
	void testParticalVelocityController() {
		ParticalVelocityController controller = new ParticalVelocityController(new PVector(0, 0));
		assertEquals(controller.getVelocity(), new PVector(0, 0));
	}

	/**
	 * Purpose: Test for onParticleSpawnEvent() 
	 * Input: Particle p with velocity set to PVector(1, 1)
	 * Expected:
	 * 		new velocity should be equal to the sum of original and new velocities
	 */
	@Test
	void testOnParticleSpawnEvent() {
		PVector velocity = new PVector(0, 0);
		ParticalVelocityController controller = new ParticalVelocityController(velocity);
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(applet, img);
		p.setVelocity(new PVector(1, 1));
		controller.onParticleSpawnEvent(p);
		assertEquals(p.getVelocity(), velocity.add(new PVector(1, 1)));
	}

	/**
	 * Purpose: Test for copy() 
	 * Input: no input for copy()
	 * Expected:
	 * 		velocity vectors should be equal
	 */
	@Test
	void testCopy() {
		ParticalVelocityController controller = new ParticalVelocityController(new PVector(0, 0));
		ParticalVelocityController copy = (ParticalVelocityController) controller.copy();
		assertEquals(controller.getVelocity(), copy.getVelocity());
	}

}
