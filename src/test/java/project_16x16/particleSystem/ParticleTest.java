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
	
	/**
	 * Purpose: Test for spawn() with 100 health
	 * Input: (Consumer<Particle> c, 100)
	 * Expected:
	 * 		LifeSpan and MaxLifeSpan should be set to 100
	 */
	@Test
	void testSpawn() {
		SideScroller s = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(s, img);
		AreaEmission area = new AreaEmission(new PVector(0,0), 1, 1, 0);
		Consumer<Particle> c = area.getConsumer();
		p.spawn(c, 100);
		assertEquals(100, p.getMaxLifespan());
		assertEquals(100, p.getLifespan());
	}
	
	/**
	 * Purpose: Test for spawn() with 0 health
	 * Input: (Consumer<Particle> c, 100)
	 * Expected:
	 * 		LifeSpan and MaxLifeSpan should be set to 0
	 */
	@Test
	void testSpawnDead() {
		SideScroller s = new SideScroller();
		PImage img = new PImage();
		Particle p = new Particle(s, img);
		AreaEmission area = new AreaEmission(new PVector(0,0), 1, 1, 0);
		Consumer<Particle> c = area.getConsumer();
		p.spawn(c, 0);
		assertEquals(0, p.getMaxLifespan());
		assertEquals(0, p.getLifespan());
		assertTrue(p.isDead());
	}

}
