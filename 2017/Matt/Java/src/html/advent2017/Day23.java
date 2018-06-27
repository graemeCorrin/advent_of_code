package html.advent2017;

import html.advent2017.day23.Coprocessor;
import html.advent2017.day23.CoprocessorDebug;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day23 extends DayBase {
  private String dataFile = "data/day23";
  private String dataFileOptimized = "data/day23optimized";

  void solution() {
    System.out.println(part1(getData(dataFile)));
    System.out.println(part2(getData(dataFileOptimized)));
  }


  private int part1(String[][] data) {
    CoprocessorDebug coprocessorDebug = new CoprocessorDebug(data);
    return coprocessorDebug.run();
  }


  private long part2(String[][] data) {
    Coprocessor coprocessor = new Coprocessor(data);
    return coprocessor.run();
  }


  private String[][] getData(String file) {
    String line;
    int lineCount = 0;
    String[] lines = new String[2000];

    try {
      FileReader fRead = new FileReader(file);
      BufferedReader bRead = new BufferedReader(fRead);
      while ((line = bRead.readLine()) != null) {
        lines[lineCount] = line;
        lineCount++;
      }
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    String[][] data = new String[lineCount][];

    for (int i = 0; i < lineCount; i++) {
      data[i] = lines[i].split(" ");
    }

    return data;
  }
}
