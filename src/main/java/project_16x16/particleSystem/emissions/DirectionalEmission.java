package project_16x16.particleSystem.emissions;

import java.util.Random;
import processing.core.PVector;

/**
 * AreaEmission
 * <p>
 * Emits particles in a direction given angle (radians).
 * 0 is to the left, PI/2 is down.
 *
 * @author petturtle
 */
public class DirectionalEmission extends ParticleEmission {	
	/**
     * Create a new DirectionalEmission.

     * @param position 	   PVector position, set to a active entities PVector for the particle system to follow
     * @param velocity     Start velocity of particle in random direction;
     * @param acceleration Start acceleration of particle in random direction;
     * @param spread	   Deviation from spawn position
     * @param angle		   direction angle (radians)
     */
	public DirectionalEmission(PVector position, float velocity, float acceleration, float spread, float angle) {
		super(position, velocity, acceleration, spread);
		this.angle = angle;
	}

	public void newVelocity() {
		newVelocity = new PVector();
		newVelocity.x = (float) (getVelocity()*Math.cos(getAngle()));
		newVelocity.y = (float) (getVelocity()*Math.sin(getAngle()));
	}

	public void newAcceleration() {
		newAcceleration = new PVector();
		newAcceleration.x = (float) (getAcceleration()*Math.cos(getAngle()));
		newAcceleration.y = (float) (getAcceleration()*Math.sin(getAngle()));
	}

	@Override
	public void generateNew() {
		newPosition();
		newVelocity();
		newAcceleration();
	}
	
	@Override
	public void newPosition() {
		PVector p = position.copy();
		Random ran = new Random();
		float offset = (ran.nextFloat()*getSpread()*2f)-getSpread();
		p.x += (float) (offset*Math.cos(getAngle()+Math.PI/2));
		p.y += (float) (offset*Math.sin(getAngle()+Math.PI/2));
		setPosition(p);
	}
	
	@Override
	public ParticleEmission copy() {
		return new  DirectionalEmission(position, getVelocity(), getAcceleration(), getSpread(), getAngle());
	}

	@Override
	public float determinePhi() {
		return 0;
	}
}
