package html.advent2017;

import html.advent2017.day21.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

class Day21 extends DayBase {
  private String dataFile = "data/day21";
  String initialImage = ".#./..#/###";
  HashMap<String, int[][]> enhancementRules;


  void solution() {
    enhancementRules = getData();
    System.out.println(part1());
    System.out.println(part2());
  }


  private int part1() {
    int count = 0;
    int[][] image = keyStringToPatternArray(initialImage);

    for (int i = 0; i < 5; i ++) {
      image = iterateImage(image);
    }

    for (int[] row : image) {
      for (int col : row) {
        count += col;
      }
    }

    return count;
  }


  private int part2() {
    int count = 0;
    int[][] image = keyStringToPatternArray(initialImage);

    for (int i = 0; i < 18; i ++) {
      image = iterateImage(image);
    }

    for (int[] row : image) {
      for (int col : row) {
        count += col;
      }
    }

    return count;
  }

  private HashMap<String, int[][]> getData() {
    String line;
    int lineCount = 0;
    String[] lines = new String[2000];
    HashMap<String, int[][]> data = new HashMap<>();

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

    for (String row : lines) {
      String[] pattern = row.split(" => ");
      int[][] patternArray = keyStringToPatternArray(pattern[0]);
      for (int i = 0; i < 4; i ++) {
        data.put(patternArrayToKeyString(patternArray), keyStringToPatternArray(pattern[1]));
        Matrix.rotateRight(patternArray);
      }
      Matrix.flipAcrossYAxis(patternArray);
      for (int j = 0; j < 4; j++) {
        data.put(patternArrayToKeyString(patternArray), keyStringToPatternArray(pattern[1]));
        Matrix.rotateRight(patternArray);
      }
    }
    return data;
  }


  private int[][] keyStringToPatternArray(String keyString) {
    String[] temp = keyString.replaceAll("\\.", "0").replaceAll("#", "1").split("/");
    int[][] result = new int[temp.length][temp.length];
    for (int i = 0; i < temp.length; i++) {
      for (int j = 0; j < temp.length; j++) {
        result[i][j] = Integer.parseInt(Character.toString(temp[i].charAt(j)));
      }
    }
    return result;
  }


  private String patternArrayToKeyString(int[][] patternArray) {
    String result = "";
    for (int[] row : patternArray) {
      for (int col : row) {
        result = result.concat(Integer.toString(col));
      }
      result = result.concat(" ");
    }
    result = result.trim().replaceAll(" ", "/").replaceAll("0", ".").replaceAll("1", "#");
    return result;
  }


  private int[][] iterateImage(int[][] inputImage) {
    int[][] oldImage = Matrix.copyMatrix(inputImage);
    
    int size = oldImage.length;
    int bits;
    int bytes;
    if (size % 2 == 0) {
      bits = 2;
      bytes = size / 2;
    } else {
      bits = 3;
      bytes = size / 3;
    }
    int[][] result = new int[(bits + 1) * bytes][(bits + 1) * bytes];

    for (int i = 0; i < bytes; i ++) {
      for (int j = 0; j < bytes; j++) {
        int[][] subImage = new int[bits][bits];
        for (int m = 0; m < bits; m ++) {
          for (int n = 0; n < bits; n ++) {
            subImage[m][n] = oldImage[(i * bits) + m][(j * bits) + n];
          }
        }
        subImage = enhancementRules.get(patternArrayToKeyString(subImage));
        for (int m = 0; m < (bits + 1); m ++) {
          for (int n = 0; n < (bits + 1); n ++) {
            result[(i * (bits + 1)) + m][(j * (bits + 1)) + n] = subImage[m][n];
          }
        }
      }
    }
    return result;
  }
}