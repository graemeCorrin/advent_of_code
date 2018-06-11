package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day09 extends DayBase {
  private String dataFile = "data/day09";

  void solution() {
    String data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private String getData() {
    String line = "";

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


  private int part1(String data) {
    int score = 0;
    int index = 0;
    int group = 0;
    boolean garbage = false;
    boolean cancel = false;

    do {  // while (group > 0)
      char next = data.charAt(index);
      if (cancel) {
        cancel = false;
      }else {
        if (garbage) {
          if (next == '!') {
            cancel = true;
          } else if (next == '>') {
            garbage = false;
          }
        } else {
          if (next == '{') {
            group++;
            score += group;
          } else if (next == '}') {
            group--;
          } else if (next == '<') {
            garbage = true;
          }
        }
      }
      index++;
    } while (group > 0);
    return score;
  }


  private int part2(String data) {
    int trashCount = 0;
    int index = 0;
    int group = 0;
    boolean garbage = false;
    boolean cancel = false;

    do {  // while (group > 0)
      char next = data.charAt(index);
      if (cancel) {
        cancel = false;
      }else {
        if (garbage) {
          if (next == '!') {
            cancel = true;
          } else if (next == '>') {
            garbage = false;
          } else {
            trashCount++;
          }
        } else {
          if (next == '{') {
            group++;
          } else if (next == '}') {
            group--;
          } else if (next == '<') {
            garbage = true;
          }
        }
      }
      index++;
    } while (group > 0);
    return trashCount;
  }
}
