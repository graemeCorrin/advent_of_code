package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Day19 extends DayBase {
  String dataFile = "data/day19";


  void solution() {
    char[][] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private char[][] getData() {
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

    int rows = lineCount;
    int cols = lines[0].split("").length;
    char[][] data = new char[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        data[i][j] = lines[i].charAt(j);
      }
    }
    return data;
  }


  private String part1(char[][] dataMap) {
    boolean end = false;
    // currentCoordinates [0] and [1] are the (x,y) coordinates in the maze.
    // currentCoordinates [2] is the facing with -1 = up, 1 = down, -2 = left, 2 = right
    int[] currentCoordinates = {0, 0, 1};
    String progress = "";
    
    for (int i = 0; i < dataMap[0].length; i++) {
      if (dataMap[0][i] == '|') {
        currentCoordinates[1] = i;
      }
    }
    
    while (!end) {
      
      if (dataMap[currentCoordinates[0]][currentCoordinates[1]] == '|' 
          || dataMap[currentCoordinates[0]][currentCoordinates[1]] == '-') {
        currentCoordinates = step(currentCoordinates[0], currentCoordinates[1], currentCoordinates[2]);
      } else {
          if (dataMap[currentCoordinates[0]][currentCoordinates[1]] >= 'A'
              && dataMap[currentCoordinates[0]][currentCoordinates[1]] <= 'Z') {
            progress += dataMap[currentCoordinates[0]][currentCoordinates[1]];
          }
          currentCoordinates = findAdjacent(dataMap, currentCoordinates[0]
              , currentCoordinates[1], currentCoordinates[2]);
        }
      if (currentCoordinates[2] == 0) {
        end = true;
      }
    }
    return progress;
  }


  private int part2(char[][] dataMap) {
    boolean end = false;
    // currentCoordinates [0] and [1] are the (x,y) coordinates in the maze.
    // currentCoordinates [2] is the facing with -1 = up, 1 = down, -2 = left, 2 = right
    int[] currentCoordinates = {0, 0, 1};
    int stepCount = 0;

    for (int i = 0; i < dataMap[0].length; i++) {
      if (dataMap[0][i] == '|') {
        currentCoordinates[1] = i;
      }
    }

    while (!end) {
      stepCount++;
      if (dataMap[currentCoordinates[0]][currentCoordinates[1]] == '|'
          || dataMap[currentCoordinates[0]][currentCoordinates[1]] == '-') {
        currentCoordinates = step(currentCoordinates[0], currentCoordinates[1], currentCoordinates[2]);
      } else {
        currentCoordinates = findAdjacent(dataMap, currentCoordinates[0]
            , currentCoordinates[1], currentCoordinates[2]);
      }
      if (currentCoordinates[2] == 0) {
        end = true;
      }
    }
    return stepCount;
  }
  
  
  private int[] step(int x, int y, int facing) {
    int[] newCoordinates = {x, y, facing};
    
    if (newCoordinates[2] == -1) {        // up
      newCoordinates[0] -= 1;
    } else if (newCoordinates[2] == 1) {  // down
      newCoordinates[0] += 1;
    } else if (newCoordinates[2] == -2) { // left
      newCoordinates[1] -= 1;
    } else if (newCoordinates[2] == 2) {  // right
      newCoordinates[1] += 1;
    }    
    return newCoordinates;
  }
  
  
  private int[] findAdjacent(char[][] dataMap, int x, int y, int facing) {
    int[] tempCoordinates = {x, y, facing};
    int[] bearings = {-1, 1, -2, 2};

    for (int direction : bearings) {
      tempCoordinates = step(x, y, direction);
      if ((direction != (-1 * facing)) && dataMap[tempCoordinates[0]][tempCoordinates[1]] != ' ') {
        return tempCoordinates;
      }
    }
    tempCoordinates[2] = 0;
    return tempCoordinates;
  }
}
