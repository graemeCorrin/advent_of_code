package html.advent2017;


import java.util.HashSet;

class Day14 extends DayBase {
  String puzzleInput = "nbysizxe";


  void solution() {
    int[][] hashInput = getHashInput(puzzleInput);
    System.out.println(part1(hashInput));
    System.out.println(part2(hashInput));


  }


  private int[][] getHashInput(String data) {
    int[][] hashInput = new int[128][];
    for (int i = 0; i < 128; i++) {
      String temp = data + "-" + i;
      hashInput[i] = getAsciiList(temp);
    }
    return hashInput;
  }


  private int[] getAsciiList(String inputString) {
    int[] appendToAsciiList = {17, 31, 73, 47, 23};
    int[] asciiList = new int[inputString.length() + appendToAsciiList.length];

    for (int i = 0; i < inputString.length(); i++) {
      asciiList[i] = (int) inputString.charAt(i);
    }
    System.arraycopy(appendToAsciiList, 0
        , asciiList, inputString.length(), appendToAsciiList.length);

    return asciiList;
  }


  private int part1(int[][] hashInput) {
    int count = 0;
    for (int i = 0; i < 128; i++) {
      String hexString = knotHash(hashInput[i]);
      String binaryString = "";
      for (int j = 0; j < 32; j++) {
        binaryString = binaryString.concat(hexToBinary(hexString.charAt(j)));
      }
      for (int k = 0; k < 128; k++) {
        if (binaryString.charAt(k) == '1') {
          count++;
        }
      }
    }
    return count;
  }


  private int part2(int[][] hashInput) {
    boolean[][] dataGrid = new boolean[128][128];
    
    for (int i = 0; i < 128; i++) {
      String hexString = knotHash(hashInput[i]);
      String binaryString = "";
      for (int j = 0; j < 32; j++) {
        binaryString = binaryString.concat(hexToBinary(hexString.charAt(j)));
      }
      for (int k = 0; k < 128; k++) {
        dataGrid[i][k] = (binaryString.charAt(k) == '1');
      }
    }
    return countGroups(dataGrid);
  }


  private String knotHash(int[] hashInput) {
    return getDenseHash(getSparseHash(hashInput));
  }


  private int[] getSparseHash(int[] hashInput) {
    int[] hashTarget = new int[256];
    for (int h = 0; h < 256; h++) {
      hashTarget[h] = h;
    }
    
    int hashLength = hashTarget.length;

    int index = 0;
    int skipSize = 0;
    for (int i = 0; i < 64; i++) {
      for (int currentLength : hashInput) {
        int[] temp = new int[currentLength];
        for (int j = 0; j < currentLength; j++) {
          temp[j] = hashTarget[(index + j) % hashLength];
        }
        for (int k = 0; k < currentLength; k++) {
          hashTarget[(index + k) % hashLength] = temp[currentLength - 1 - k];
        }
        index = (index + currentLength + skipSize) % hashLength;
        skipSize++;
      }
    }
    return hashTarget;
  }


  private String getDenseHash(int[] sparseHash) {
    String denseHash = "";
    int[] hashBlock = new int[16];

    for (int i = 0; i < 16; i ++) {
      System.arraycopy(sparseHash, (i * 16), hashBlock, 0, 16);
      int bitwiseResult = 0;
      for (int j = 0; j < 16; j++) {
        bitwiseResult = bitwiseResult ^ hashBlock[j];
      }
      String temp = Integer.toHexString(bitwiseResult);
      if (temp.length() == 1) {
        temp = "0".concat(temp);
      }
      denseHash = denseHash.concat(temp);
    }
    return denseHash;
  }


  private String hexToBinary(char hex) {
    if (hex == '0') {
      return "0000";
    } else if (hex == '1') {
      return "0001";
    } else if (hex == '2') {
      return "0010";
    } else if (hex == '3') {
      return "0011";
    } else if (hex == '4') {
      return "0100";
    } else if (hex == '5') {
      return "0101";
    } else if (hex == '6') {
      return "0110";
    } else if (hex == '7') {
      return "0111";
    } else if (hex == '8') {
      return "1000";
    } else if (hex == '9') {
      return "1001";
    } else if (hex == 'a') {
      return "1010";
    } else if (hex == 'b') {
      return "1011";
    } else if (hex == 'c') {
      return "1100";
    } else if (hex == 'd') {
      return "1101";
    } else if (hex == 'e') {
      return "1110";
    } else if (hex == 'f') {
      return "1111";
    } else {
      return "";
    }
  }


  private int countGroups(boolean[][] hardDriveUsedGrid) {
    int groupName = 1;
    int[][] groupGrid = new int[128][128];

    for (int i = 0; i < groupGrid.length; i++) {
      for (int j = 0; j < groupGrid[i].length; j++) {
        if (hardDriveUsedGrid[i][j]) {
          if (j != 0 && hardDriveUsedGrid[i][j - 1]) {
            groupGrid[i][j] = groupGrid[i][j - 1];
            if (i != 0 && hardDriveUsedGrid[i - 1][j] && groupGrid[i][j] != groupGrid[i - 1][j]) {
              int groupA = groupGrid[i][j];
              int groupB = groupGrid[i - 1][j];
              mergeGroups(groupGrid, groupA, groupB, i, j);
            }
          } else {
            if (i != 0 && hardDriveUsedGrid[i - 1][j]) {
              groupGrid[i][j] = groupGrid[i - 1][j];
            } else {
              groupGrid[i][j] = groupName;
              groupName++;
            }
          }
        }
      }
    }

/*
    for (int i = 0; i < 128; i++) {
      for (int j = 0; j < 128; j ++) {
        System.out.format("%4d ", groupGrid[i][j]);
      }
      System.out.format("%n");
    }
*/


    HashSet<String> groupSet = new HashSet<>();
    for (int x = 0; x < groupGrid.length; x++) {
      for (int y = 0; y < groupGrid[x].length; y++) {
        groupSet.add(Integer.toString(groupGrid[x][y]));
      }
    }
    return groupSet.size() - 1;
  }


  private void mergeGroups(int[][] groupGrid, int groupA, int groupB, int row, int col) {
    for (int i = 0; i < row + 1; i++) {
      int jMax = i < row ? groupGrid[i].length : col;
      for (int j = 0; j < jMax; j++) {
        if (groupGrid[i][j] == groupB) {
          groupGrid[i][j] = groupA;
        }
      }
    }
  }
}
