package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day1 {

  private String puzzleInput = null;
  private int inLength = 0;


  void solution() {
    puzzleInput = getInput();
    inLength = puzzleInput.length();
    compare(1);             // Part 1
    compare(inLength / 2);  // Part 2
  }


  private void compare(int compareDistance) {
    int count = 0;
    for (int i = 0; i < inLength; i++) {
      if (puzzleInput.charAt(i) == puzzleInput.charAt((i + compareDistance) % inLength)) {
        count += Character.getNumericValue(puzzleInput.charAt(i));
      }
    }
    System.out.println(count);
  }


  private String getInput() {
    String line = null;

    try {
      FileReader fRead = new FileReader("data/day1");
      BufferedReader bRead = new BufferedReader(fRead);
      line = bRead.readLine();
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return line;
  }
}
