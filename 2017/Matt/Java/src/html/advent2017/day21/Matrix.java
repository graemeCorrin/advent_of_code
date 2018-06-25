package html.advent2017.day21;

import java.util.Arrays;

public class Matrix {

  public static int[][] copyMatrix(int[][] source) {
    int[][] result = new int[source.length][source.length];    
    for (int i = 0; i < source.length; i++) {
      result[i] = Arrays.copyOf(source[i], source.length);
    }
    return result;
  }
  

  public static void flipAcrossXAxis(int[][] values) {
    int[][] temp = copyMatrix(values);
    int size = values.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j ++) {
        values[i][j] = temp[(size - 1) - i][j];
      }
    }
  }


  public static void flipAcrossYAxis(int[][] values) {
    int[][] temp = copyMatrix(values);
    int size = values.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j ++) {
        values[i][j] = temp[i][(size - 1) - j];
      }
    }
  }


  public static void rotateRight(int[][] values) {
    int[][] temp = copyMatrix(values);
    int size = values.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j ++) {
        values[i][j] = temp[(size - 1) - j][i];
      }
    }
  }


  public static void rotateLeft(int[][] values) {
    int[][] temp = copyMatrix(values);
    int size = values.length;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j ++) {
        values[i][j] = temp[j][(size - 1) - i];
      }
    }
  }
}
