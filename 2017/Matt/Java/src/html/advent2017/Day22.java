package html.advent2017;

import html.advent2017.day21.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day22 extends DayBase {
  String dataFile = "data/day22";
  int i;


  void solution() {
    int[][] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private int part1(int[][] data) {
    int count = 0;
    int size = data.length;

    int[][] grid = Matrix.copyMatrix(data);

    // index[2] is direction. 0 = up, 1 = right, 2 = down, 3 = left
    int[] index = {Math.floorDiv(size, 2), Math.floorDiv(size, 2), 0};

    for (i = 0; i < 10000; i++) {
      count += grid[index[0]][index[1]] == 0 ? 1 : 0;
      grid = burstOne(index, grid);
    }

    return count;
  }


  private int part2(int[][] data) {
    int count = 0;
    int size = data.length;

    int[][] grid = Matrix.copyMatrix(data);

    // index[2] is direction. 0 = up, 1 = right, 2 = down, 3 = left
    int[] index = {Math.floorDiv(size, 2), Math.floorDiv(size, 2), 0};

    for (i = 0; i < 10000000; i++) {
      count += grid[index[0]][index[1]] == 2 ? 1 : 0;
      grid = burstTwo(index, grid);
    }

    return count;
  }


  private int[][] getData() {
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
    lines = Arrays.copyOf(lines, lineCount);

    int[][] result = new int[lineCount][];
    for (int i = 0; i < lineCount; i++) {
      result[i] = hashDotStringToThreeZeroArray(lines[i]);
    }
    return result;
  }


  private int[] hashDotStringToThreeZeroArray(String keyString) {
    String[] temp = keyString.replaceAll("\\.", "0").replaceAll("#", "3").split("");
    int[] result = new int[temp.length];
    for (int i = 0; i < temp.length; i++) {
      result[i] = Integer.parseInt(temp[i]);
    }
    return result;
  }


  private int[][] burstOne(int[] index, int[][] grid) {
    int size = grid.length;
    int[][] newGrid = grid;

    if (grid[index[0]][index[1]] == 3) {
      index[2] = Math.floorMod(index[2] + 1, 4);
      grid[index[0]][index[1]] = 0;
    } else {
      index[2] = Math.floorMod(index[2] - 1, 4);
      grid[index[0]][index[1]] = 3;
    }

    if (index[2] == 0) {
      index[0] -= 1;
    } else if (index[2] == 1) {
      index[1] += 1;
    }else if (index[2] == 2) {
      index[0] += 1;
    }else if (index[2] == 3) {
      index[1] -= 1;
    }

    if (index[0] < 0 || index [0] >= size || index[1] < 0 || index[1] >= size) {
      newGrid = new int[size + 8][size + 8];

      for (int i = 0; i < size; i++){
        System.arraycopy(grid[i], 0, newGrid[i + 4], 4, size);
      }

      index[0] += 4;
      index[1] += 4;
    }
    return newGrid;
  }


  private int[][] burstTwo(int[] index, int[][] grid) {
    int size = grid.length;
    int[][] newGrid = grid;

    if (grid[index[0]][index[1]] == 3) {
      index[2] = Math.floorMod(index[2] + 1, 4);
      grid[index[0]][index[1]] = 1;
    } else if (grid[index[0]][index[1]] == 2) {
      grid[index[0]][index[1]] = 3;
    } else if (grid[index[0]][index[1]] == 1) {
      index[2] = Math.floorMod(index[2] + 2, 4);
      grid[index[0]][index[1]] = 0;
    } else {
      index[2] = Math.floorMod(index[2] - 1, 4);
      grid[index[0]][index[1]] = 2;
    }

    if (index[2] == 0) {
      index[0] -= 1;
    } else if (index[2] == 1) {
      index[1] += 1;
    }else if (index[2] == 2) {
      index[0] += 1;
    }else if (index[2] == 3) {
      index[1] -= 1;
    }

    if (index[0] < 0 || index [0] >= size || index[1] < 0 || index[1] >= size) {
      newGrid = new int[size + 8][size + 8];

      for (int i = 0; i < size; i++){
        System.arraycopy(grid[i], 0, newGrid[i + 4], 4, size);
      }

      index[0] += 4;
      index[1] += 4;
    }
    return newGrid;
  }
}
