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

}
