package project_16x16.particleSystem.emissions;

import java.util.Random;
import processing.core.PVector;

/**
 * RectEmission
 * <p>
 * Spawns particles in a rect given center position, width, height.
 *
 * @author petturtle
 */
public class RectEmission extends ParticleEmission {

	private int width;
	private int height;
	
	/**
     * Create a new AreaEmission.

     * @param position 	   PVector center position, set to a active entities PVector for the particle system to follow
     * @param velocity     Start velocity of particle in random direction;
     * @param acceleration Start acceleration of particle in random direction;
     * @param width		   width of rect
     * @param height	   height of rect
     */
	public RectEmission(PVector position, float velocity, float acceleration, int width, int height) {
		super(position, velocity, acceleration, 0);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void newPosition() {
		PVector p = position.copy();
		Random ran = new Random();
		p.x += (ran.nextFloat()*getWidth()/2f)-getWidth()/2;
		p.y += (ran.nextFloat()*getHeight()/2f)-getHeight()/2;
		setPosition(p);
	}
	
	@Override
	public ParticleEmission copy() {
		return new  RectEmission(position, getVelocity(), getAcceleration(), getWidth(), getHeight());
	}

	public float determinePhi() {
		float phi = (float) (2*Math.PI*Math.random());
		return phi;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
