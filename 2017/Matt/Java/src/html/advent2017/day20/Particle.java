package html.advent2017.day20;

import java.util.Arrays;

public class Particle {
  private String particleID;
  private long[] position;
  private long[] velocity;
  private long[] acceleration;

  private long time;
  private long[] minVelocity;

  public Particle(String particleID) {
    this.particleID = particleID;
    time = 0;
    minVelocity = new long[3];
  }


  public void setPosition(long[] position) {
    this.position = Arrays.copyOf(position, 3);
  }


  public void setVelocity(long[] velocity) {
    this.velocity = Arrays.copyOf(velocity, 3);
    if (time == 0) {
      minVelocity[0] = 0;
      minVelocity[1] = getVelocitySum();
      minVelocity[2] = time;
    }
  }


  public void setAcceleration(long[] acceleration) {
    this.acceleration = Arrays.copyOf(acceleration, 3);
  }


  public String getParticleID() {
    return particleID;
  }


  public long[] getPosition() {
    return position;
  }


  public long getPositionSum() {
    return (Math.abs(position[0]) + Math.abs(position[1]) + Math.abs(position[2]));
  }


  public long getVelocitySum() {
    return (Math.abs(velocity[0]) + Math.abs(velocity[1]) + Math.abs(velocity[2]));
  }


  public long getAccelerationSum() {
    return (Math.abs(acceleration[0]) + Math.abs(acceleration[1]) + Math.abs(acceleration[2]));
  }


  public boolean isAccelerationAndVelocitySameDirection() {
    if (velocity[0] * acceleration[0] < 0) {
      return false;
    }
    if (velocity[1] * acceleration[1] < 0) {
      return false;
    }
    if (velocity[2] * acceleration[2] < 0) {
      return false;
    }
    return true;
  }


  public void update() {
    time++;

    velocity[0] += acceleration[0];
    velocity[1] += acceleration[1];
    velocity[2] += acceleration[2];

    position[0] += velocity[0];
    position[1] += velocity[1];
    position[2] += velocity[2];

  }
}
