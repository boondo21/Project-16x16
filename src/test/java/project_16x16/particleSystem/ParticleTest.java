package project_16x16.particleSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.particleSystem.emissions.AreaEmission;

import java.util.function.Consumer;

class ParticleTest {
	
	/**
	 * Purpose: Test for Constructor()
	 * Input: (SideScroller s, PImage img)
	 * Expected:
	 * 		return Particle object
	 */
	@Test
	void testParticle() {
		SideScroller s = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(s, img);
		assertNotNull(p);
		assertEquals(0, p.getFrameCount());
		assertSame(img, p.getImage());
		assertSame(s, p.getApplet());
	}
}
