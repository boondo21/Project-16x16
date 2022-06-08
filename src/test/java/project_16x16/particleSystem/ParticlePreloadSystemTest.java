package project_16x16.particleSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

class ParticlePreloadSystemTest {
	/**
	 * Purpose: Test for preload() 
	 * Input: 60 - number of frames
	 * Expected:
	 * 		Consumer<Particle> object
	 */
	@Test
	void testPreload() {
		Consumer<Particle> c = ParticlePreloadSystem.preload(60);
		assertNotNull(c);
	}

}
