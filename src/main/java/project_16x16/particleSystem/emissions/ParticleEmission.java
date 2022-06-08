package project_16x16.particleSystem.emissions;

import java.util.Random;
import java.util.function.Consumer;

import processing.core.PVector;
import project_16x16.particleSystem.Particle;

public abstract class ParticleEmission {
	protected PVector position;
	protected float velocity;
	protected float acceleration;
	protected float spread;
	protected float angle;
	
	protected PVector newPosition;
	protected PVector newVelocity;
	protected PVector newAcceleration;
	
	protected ParticleEmission(PVector position, float velocity, float acceleration, float spread) {
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.spread = spread;
	}
	
	public void setPosition(PVector position) {
		this.position = position;
	}
	
	public abstract ParticleEmission copy();

	public abstract float determinePhi();
	
	public void generateNew() {
		float phi = determinePhi();
		newParameters(phi);
	}
	
	public void newVelocity(float phi) {
		newVelocity = new PVector();
		newVelocity.x = (float) (getVelocity()*Math.cos(phi));
		newVelocity.y = (float) (getVelocity()*Math.sin(phi));
	}

	public void newAcceleration(float phi) {
		newAcceleration = new PVector();
		newAcceleration.x = (float) (getAcceleration()*Math.cos(phi));
		newAcceleration.y = (float) (getAcceleration()*Math.sin(phi));
	}

	public void newPosition() {
		PVector p = position.copy();
		Random ran = new Random();
		p.x += (ran.nextFloat()*getSpread()*2f)-getSpread();
		p.y += (ran.nextFloat()*getSpread()*2f)-getSpread();
		newPosition = p;
	}
	
	public Consumer<Particle> getConsumer() {
		return p -> {
			generateNew();
			p.setPosition(newPosition);
			p.setVelocity(newVelocity);
			p.setAcceleration(newAcceleration);
		};
	}

	public void newParameters(float phi) {
		newPosition();
		newVelocity(phi);
		newAcceleration(phi);
	}

	public float getVelocity() {
		return velocity;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public float getSpread() {
		return spread;
	}

	public float getAngle() {
		return angle;
	}
}
