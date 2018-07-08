package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day01 extends DayBase {
  private  String dataFile = "data/day01";
  private String puzzleInput = null;
  private int inLength = 0;


  void solution() {
    puzzleInput = getData();
    inLength = puzzleInput.length();
    System.out.println(compare(1));             // Part 1
    System.out.println(compare(inLength / 2));  // Part 2
  }


  private int compare(int compareDistance) {
    int count = 0;
    for (int i = 0; i < inLength; i++) {
      if (puzzleInput.charAt(i) == puzzleInput.charAt((i + compareDistance) % inLength)) {
        count += Character.getNumericValue(puzzleInput.charAt(i));
      }
    }
    return count;
  }


  private String getData() {
    String line = null;

    try {
      FileReader fRead = new FileReader(dataFile);
      BufferedReader bRead = new BufferedReader(fRead);
      line = bRead.readLine();
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return line;
  }
}
