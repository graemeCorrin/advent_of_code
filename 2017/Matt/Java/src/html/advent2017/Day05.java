package html.advent2017;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class Day05 extends DayBase {
  private String dataFile = "data/day05";


  void solution() {
    int[] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private int[] getData() {
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

    int[] data = new int[lineCount];
    for (int i = 0; i < lineCount; i++) {
      data[i] = Integer.parseInt(lines[i]);
    }
    return data;
  }


  private  int part1(int[] data) {
    int[] jumpCommands = new int[data.length];
    System.arraycopy(data, 0, jumpCommands, 0, data.length);
    int steps = 0;
    int index = 0;
    boolean inBounds = true;

    while (inBounds) {
      try {
        index += jumpCommands[index]++;
        steps++;
      } catch (ArrayIndexOutOfBoundsException e) {
        inBounds = false;
      }
    }
    return steps;
  }


  private  int part2(int[] data) {
    int[] jumpCommands = new int[data.length];
    System.arraycopy(data, 0, jumpCommands, 0, data.length);
    int steps = 0;
    int index = 0;
    int last = 0;
    boolean inBounds = true;

    while (inBounds) {
      try {
        last = index;
        index += jumpCommands[index];
        if (jumpCommands[last] >= 3) {
          jumpCommands[last] -= 1;
        } else {
          jumpCommands[last] += 1;
        }
        steps++;
      } catch (ArrayIndexOutOfBoundsException e) {
        inBounds = false;
      }
    }
    return steps;
  }
}
