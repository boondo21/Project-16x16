package project_16x16.particleSystem.events;

import processing.core.PVector;
import project_16x16.particleSystem.Particle;

/**
 * Partical Velocity Controller
 * <p>
 * Adds velocity to a particle on spawn.
 * Useful is using a emission that only adds random or directional velocity.
 *
 * @author petturtle
 */
public class ParticalVelocityController implements ParticleEventListener {

	private PVector velocity;
	
	/**
	 * Adds velocity to a particle on spawn.
	 * Useful is using a emission that only adds random or directional velocity
	 *
	 * @param velocity PVector velocity
	 */
	public ParticalVelocityController(PVector velocity) {
		this.setVelocity(velocity);
	}

	@Override
	public void onParticleSpawnEvent(Particle particle) {
		particle.updateVelocity(getVelocity());
	}

	@Override
	public ParticleEventListener copy() {
		return new ParticalVelocityController(getVelocity());
	}

	public PVector getVelocity() {
		return velocity;
	}

	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}
}
