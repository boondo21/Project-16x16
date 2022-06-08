package project_16x16.particleSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import processing.core.PImage;
import processing.core.PVector;
import project_16x16.SideScroller;

class ParticlePreloadSystemTest {
	/**
	 * Purpose: Test for preload() 
	 * Input: 1 - number of frames
	 * Expected:
	 * 		Consumer<Particle> object
	 * 		call spawn to create a particle for consumer and make it accept it
	 */
	@Test
	void testPreload() {
		SideScroller applet = new SideScroller();
		PImage img = new PImage();
		Consumer<Particle> c = ParticlePreloadSystem.preload(1);
		Particle p = new Particle(applet, img);
		p.spawn(c, 100);
		p.setPosition(new PVector(1, 1));
		p.setVelocity(new PVector(1, 1));
		p.setAcceleration(new PVector(1, 1));
		p.spawn(c, 100);
		assertNotNull(c);
	}

}
