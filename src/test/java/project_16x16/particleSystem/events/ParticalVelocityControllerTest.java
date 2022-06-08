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
}
