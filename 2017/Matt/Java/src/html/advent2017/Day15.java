package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day15 extends DayBase {
  private String dataFile = "data/day15";
  private long startValueA;
  private long startValueB;
  private long factorA = 16807;
  private long factorB = 48271;
  private long divider = 2147483647;


  void solution() {
    getData();
    long p1Result = part1();
    long p2Result = part2();
    System.out.println("Part 1 final count: " + p1Result);
    System.out.println("Part 2 final count: " + p2Result);
  }


  private void getData() {
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

    String[][] entries = new String[lineCount][];
    for (int i = 0; i < lineCount; i++) {
      entries[i] = lines[i].split(" ");
    }

    startValueA = Integer.parseInt(entries[0][4]);
    startValueB = Integer.parseInt(entries[1][4]);
  }


  private long part1() {
    long count = 0;
    long valueA = startValueA;
    long valueB = startValueB;

    for (long i = 0; i < 40000000; i++) {
      valueA = magicGenerator(valueA, factorA, divider);
      valueB = magicGenerator(valueB, factorB, divider);
      if (compareLast16Bits(valueA, valueB)) {
        count++;
      }
      if (i % 760000 == 0) {
        long percentComplete = i / 400000;
        System.out.println("Part 1: " + percentComplete + "% complete...");
      }
    }
    System.out.println("Part 1: 100% complete...\n");

    return count;
  }


  private long part2() {
    int count = 0;
    long[][] judgeCard = new long[5000000][2];
    long valueA = startValueA;
    long valueB = startValueB;

    for (int i = 0; i < 5000000;) {
      valueA = magicGenerator(valueA, factorA, divider);
      if (valueA % 4 == 0) {
        judgeCard[i][0] = valueA;
        i++;
      }
    }
    for (int j = 0; j < 5000000;) {
      valueB = magicGenerator(valueB, factorB, divider);
      if (valueB % 8 == 0) {
        judgeCard[j][1] = valueB;
        j++;
      }
    }
    for (int k = 0; k < 5000000; k++) {
      if (compareLast16Bits(judgeCard[k][0], judgeCard[k][1])) {
        count++;
      }
      if (k % 500000 == 0) {
        long percentComplete = k / 50000;
        System.out.println("Part 2: " + percentComplete + "% complete...");
      }
    }
    System.out.println("Part 2: 100% complete...\n");

    return count;
  }


  private long magicGenerator(long inputValue, long factor, long divisor) {
    return ((inputValue * factor) % divisor);
  }


  private boolean compareLast16Bits(long valueA, long valueB) {
    String stringA = String.format("%32s", Long.toBinaryString(valueA)).replace(' ', '0');
    String stringB = String.format("%32s", Long.toBinaryString(valueB)).replace(' ', '0');

    return (stringA.substring(16).equals(stringB.substring(16)));
  }
}
