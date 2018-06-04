package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day2 {

  private String dataFile = "data/day2";


  void solution() {
    int[][] data = getData();
    System.out.println(checksumDifference(data));   // Part 1
    System.out.println(checksumQuotient(data));     // Part 2

  }


  private int checksumDifference(int[][] data) {
    int sum = 0;
    int rowCount = data.length;
    int colCount = data[0].length;

    for (int i = 0; i < rowCount; i++) {
      int currentValue;
      int highValue = data[i][0];
      int lowValue = highValue;

      for (int j = 1; j < colCount; j++) {
        currentValue = data[i][j];
        if (currentValue > highValue) {
          highValue = currentValue;
        } else if (currentValue < lowValue) {
          lowValue = currentValue;
        }
      }
      sum += highValue - lowValue;
    }
    return sum;
  }


  private int checksumQuotient(int[][] data) {
    int sum = 0;
    int rowCount = data.length;
    int colCount = data[0].length;

    for (int i = 0; i < rowCount; i++) {
      int currentValue;
      for (int j = 0; j < colCount; j++) {
        currentValue = data[i][j];
        for (int k = j + 1; k < colCount; k++) {
          int compareValue = data[i][k];
          if (currentValue % compareValue == 0) {
            sum += currentValue / compareValue;
            break;
          } else if (compareValue % currentValue == 0) {
            sum += compareValue / currentValue;
            break;
          }
        }
      }
    }
    return sum;
  }


  private int[][] getData() {
    String line;
    int lineCount = 0;
    String[] lines = new String[100];

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

    int[][] intEntries = new int[lineCount][lines[0].split(" ").length];

    for (int i = 0; i < lineCount; i++) {
      String[] strEntries = lines[i].split(" ");

      for (int j = 0; j < strEntries.length; j++) {
        intEntries[i][j] = Integer.parseInt(strEntries[j]);
      }
    }
    return intEntries;
  }
}
