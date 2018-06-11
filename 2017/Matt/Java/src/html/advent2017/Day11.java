package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day11 extends DayBase {
  private String dataFile = "data/day11";


  void solution() {
    String[] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private String[] getData() {
    String line = "";
    try {
      FileReader fRead = new FileReader(dataFile);
      BufferedReader bRead = new BufferedReader(fRead);
      line = bRead.readLine();
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return line.split(",");
  }


  private int part1(String[] data) {
    int[] index = {0, 0, 0};

    for (int i = 0; i < data.length; i++) {
      String command = data[i];

      switch (command) {
        case "n":
          index[1] -= 1;
          index[2] += 1;
          break;
        case "s":
          index[1] += 1;
          index[2] -= 1;
          break;
        case "nw":
          index[0] -= 1;
          index[2] += 1;
          break;
        case "se":
          index[0] += 1;
          index[2] -= 1;
          break;
        case "sw":
          index[0] -= 1;
          index[1] += 1;
          break;
        case "ne":
          index[0] += 1;
          index[1] -= 1;
          break;
      }
    }
    return Math.max(Math.abs(index[0]), Math.max(Math.abs(index[1]), Math.abs(index[2])));
  }


  private int part2(String[] data) {
    int[] index = {0, 0, 0};
    int maxDistance = 0;

    for (int i = 0; i < data.length; i++) {
      String command = data[i];

      switch (command) {
        case "n":
          index[1] -= 1;
          index[2] += 1;
          break;
        case "s":
          index[1] += 1;
          index[2] -= 1;
          break;
        case "nw":
          index[0] -= 1;
          index[2] += 1;
          break;
        case "se":
          index[0] += 1;
          index[2] -= 1;
          break;
        case "sw":
          index[0] -= 1;
          index[1] += 1;
          break;
        case "ne":
          index[0] += 1;
          index[1] -= 1;
          break;
      }
      maxDistance = Math.max(maxDistance,
                             Math.max(Math.abs(index[0]),
                                      Math.max(Math.abs(index[1]),
                                               Math.abs(index[2]))));
    }
    return maxDistance;
  }
}
