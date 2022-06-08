package project_16x16.particleSystem.events;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import project_16x16.SideScroller;
import project_16x16.particleSystem.Particle;

class ParticleAnimationControllerTest {

	/**
	 * Purpose: Test for Constructor() 
	 * Input: ArrayList<PImage> images, rate - 10
	 * Expected:
	 * 		ParticleAnimationController object with the same value for rate and images given
	 */
	@Test
	void testParticleAnimationControllerArrayListOfPImageInt() {
		ArrayList<PImage> images = new ArrayList<PImage>();
		ParticleAnimationController controller = new ParticleAnimationController(images, 10);
		assertEquals(controller.getImages(), images);
		assertEquals(controller.getRate(), 10);
	}
}
