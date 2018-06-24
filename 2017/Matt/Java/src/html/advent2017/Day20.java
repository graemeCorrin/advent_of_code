package html.advent2017;

import html.advent2017.day20.Particle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Day20 extends DayBase {
  String dataFile = "data/day20";


  void solution() {
    String[] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private String[] getData() {
    String line;
    int lineCount = 0;
    String[] lines = new String[2000];

    try {
      FileReader fRead = new FileReader(dataFile);
      BufferedReader bRead = new BufferedReader(fRead);
      while ((line = bRead.readLine()) != null) {
        lines[lineCount] = line;
        lineCount++;
      }
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String[] data = new String[lineCount];
    for (int i = 0; i < lineCount; i++) {
        data[i] = lines[i];
    }
    return data;
  }


  private String part1(String[] data) {

    HashMap<String, Particle> particleHashMap = new HashMap<>();
    long lowestAcceleration = Long.MAX_VALUE;
    long lowestVelocity = Long.MAX_VALUE;

    for (int i = 0; i < data.length; i++) {
      particleHashMap.put(Integer.toString(i), generateParticle(i, data[i]));
      if (particleHashMap.get(Integer.toString(i)).getAccelerationSum() < lowestAcceleration) {
        lowestAcceleration = particleHashMap.get(Integer.toString(i)).getAccelerationSum();
      }
    }

    HashSet<String> removeSet = new HashSet<>();
    for (Particle particle : particleHashMap.values()) {
      if (particle.getAccelerationSum() > lowestAcceleration) {
        removeSet.add(particle.getParticleID());
      }
    }
    for (String ParticleID : removeSet) {
      particleHashMap.remove(ParticleID);
    }

    boolean end = false;

    while (!end) {
      end = true;
      for (Particle particle : particleHashMap.values()) {
        particle.update();
        if (!particle.isAccelerationAndVelocitySameDirection()) {
          end = false;
        }
      }
    }

    removeSet = new HashSet<>();
    for (Particle particle : particleHashMap.values()) {
      if (particle.getVelocitySum() < lowestVelocity) {
        lowestVelocity = particle.getVelocitySum();
      }
    }
    for (Particle particle : particleHashMap.values()) {
      if (particle.getVelocitySum() > lowestVelocity) {
        removeSet.add(particle.getParticleID());
      }
    }
    for (String ParticleID : removeSet) {
      particleHashMap.remove(ParticleID);
    }

    String result = "";
    for (Particle particle : particleHashMap.values()) {
      result = particle.getParticleID();
    }

      return result;
  }


  private int part2(String[] data) {

    HashMap<String, Particle> particleHashMap = new HashMap<>();
    long lowestAcceleration = Long.MAX_VALUE;
    long lowestVelocity = Long.MAX_VALUE;

    for (int i = 0; i < data.length; i++) {
      particleHashMap.put(Integer.toString(i), generateParticle(i, data[i]));
    }

    HashSet<String> removeList;
    for (int i = 0; i < 100; i++) {
      removeList = new HashSet<>();
      for (Particle particle : particleHashMap.values()) {
        particle.update();
      }
      for (Particle particleOne : particleHashMap.values()) {
        for (Particle particleTwo : particleHashMap.values()) {
          if (Arrays.equals(particleOne.getPosition(), particleTwo.getPosition())
              && particleOne != particleTwo) {
            removeList.add(particleOne.getParticleID());
          }
        }
      }
      for (String particleID : removeList) {
        particleHashMap.remove(particleID);
      }
    }

    return particleHashMap.size();
  }


  private Particle generateParticle(int particleID, String particleData) {
    long[] position = new long[3];
    long[] velocity = new long[3];
    long[] acceleration = new long[3];

    String[] tempData = particleData.replaceAll("p=<|v=<|a=<|>| ", "").split(",");

    for (int i = 0; i < 3; i++) {
      position[i] = Long.parseLong(tempData[i]);
      velocity[i] = Long.parseLong(tempData[i + 3]);
      acceleration[i] = Long.parseLong(tempData[i + 6]);
    }

    Particle particle = new Particle(Integer.toString(particleID));
    particle.setPosition(position);
    particle.setVelocity(velocity);
    particle.setAcceleration(acceleration);

    return particle;
  }
}
