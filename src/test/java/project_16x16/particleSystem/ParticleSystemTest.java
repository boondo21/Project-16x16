package project_16x16.particleSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import project_16x16.SideScroller;

class ParticleSystemTest {
	/**
	 * Purpose: Test for Constructor()
	 * Input: (SideScroller applet, PImage img, 0, 0, 0)
	 * Expected:
	 * 		return ParticleSystem object with given values
	 */
	@Test
	void testParticleSystemSideScrollerPImageIntIntFloat() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		ParticleSystem system = new ParticleSystem(applet, img, 0, 0, 0);
		assertNotNull(system);
		assertSame(system.getImage(), img);
		assertEquals(system.getSpawnAmount(), 0);
		assertEquals(system.getSpawnRate(), 0);
		assertEquals(system.getLifespan(), 0);
	}
}
