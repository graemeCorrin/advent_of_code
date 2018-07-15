package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day06 extends DayBase {
  private String dataFile = "data/day06";
  private int[] puzzleInput = {4, 10, 4, 1, 8, 4, 9, 14, 5, 1, 14, 15, 0, 15, 3, 5};

  void solution() {
    puzzleInput = getData();
    System.out.println(bankRoutineCounter());   // Part 1
    System.out.println(bankRoutineCounter());   // Part 2
  }


  private int[] getData() {
    String line = "";

    try {
      FileReader fRead = new FileReader(dataFile);
      BufferedReader bRead = new BufferedReader(fRead);
      line = bRead.readLine();
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String[] stringValues = line.split(" ");
    int[] intValues = new int[stringValues.length];

    for (int i = 0; i < stringValues.length; i++) {
      intValues[i] = Integer.parseInt(stringValues[i]);
    }
    return intValues;
  }


  private int bankRoutineCounter() {
    int bankCount = puzzleInput.length;
    int[] banks = new int[bankCount];
    System.arraycopy(puzzleInput, 0, banks, 0, bankCount);
    Set<String> bankCombinations = new HashSet<>();
    boolean repeat = false;

    while (!repeat) {
      String combination = Integer.toString(banks[0]);
      for (int i = 1; i < bankCount; i++) {
        combination = combination.concat(" " + Integer.toString(banks[i]));
      }
      if (bankCombinations.contains(combination)) {
        repeat = true;
        // Copies repeat bank configuration to data, which is the starting data set for Part 2.
        System.arraycopy(banks, 0, puzzleInput, 0, bankCount);
      } else {
        bankCombinations.add(combination);
        int[] largestBank = {0, 0};
        for (int i = 0; i < bankCount; i++) {
          if (banks[i] > largestBank[1]) {
            largestBank[0] = i;
            largestBank[1] = banks[i];
          }
        }
        banks[largestBank[0]] = 0;
        while (largestBank[1] > 0) {
          largestBank[0] = (largestBank[0] + 1) % bankCount;
          banks[largestBank[0]]++;
          largestBank[1]--;
        }
      }
    }
    return bankCombinations.size();
  }
}
