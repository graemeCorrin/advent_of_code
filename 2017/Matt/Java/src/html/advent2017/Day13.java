package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day13 extends DayBase {
  String dataFile = "data/day13";


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

    String[] entries = new String[lineCount];
    System.arraycopy(lines, 0, entries, 0, lineCount);

    return entries;
  }


  private int part1(String[] data) {
    int count = 0;

    for (String line : data) {
      String[] words = line.split(": ");
      int layer = Integer.parseInt(words[0]);
      int range = Integer.parseInt(words[1]);
      int severity = layer * range;
      int rangeStep = (range - 1) * 2;
      if (layer % rangeStep == 0) {
        count += severity;
      }
    }
    return count;
  }


  private int part2(String[]data) {
    int delay = 0;
    boolean escape = false;

    while (!escape) {
      escape = true;
      for (String line : data) {
        String[] words = line.split(": ");
        int layer = Integer.parseInt(words[0]);
        int range = Integer.parseInt(words[1]);
        int rangeStep = (range - 1) * 2;
        if ((layer + delay) % rangeStep == 0) {
          delay++;
          escape = false;
          break;
        }
      }
    }
    return delay;
  }
}
