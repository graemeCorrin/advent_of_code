package html.advent2017;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

import static java.util.Arrays.sort;

class Day04 extends DayBase {
  private String dataFile = "data/day04";


  void solution() {
    String[] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private String[] getData() {
    String line;
    int lineCount = 0;
    String[] lines = new String[1000];

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
    int validCount = 0;
    int lineCount = data.length;
    boolean validPass;

    for (int i = 0; i < lineCount; i++) {
      String[] line = data[i].split(" ");
      int wordCount = line.length;
      validPass = true;

      for (int j = 0; j < wordCount; j++) {
        for (int k = j + 1; k < wordCount; k++) {
          if (line[j].equals(line[k])) {
            validPass = false;
          }
        }
      }
      if (validPass) {
        validCount++;
      }
    }
    return validCount;
  }


  private int part2(String[] data) {
    int validCount = 0;
    int lineCount = data.length;
    boolean validPass;

    for (int i = 0; i < lineCount; i++) {
      String[] line = data[i].split(" ");
      int wordCount = line.length;
      validPass = true;

      for (int j = 0; j < wordCount; j++) {
        String[] word = line[j].split("");
        Arrays.sort(word);
        line[j] = Arrays.toString(word);
      }

      for (int j = 0; j < wordCount; j++) {
        for (int k = j + 1; k < wordCount; k++) {
          if (line[j].equals(line[k])) {
            validPass = false;
          }
        }
      }
      if (validPass) {
        validCount++;
      }
    }
    return validCount;
  }
}
