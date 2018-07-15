package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Day10 extends DayBase {
  private String dataFile = "data/day10";
  private int[] inputList;
  private String inputString;


  void solution() {
    int[] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
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
    inputString = line;

    String[] temp = line.split(",");
    inputList = new int[temp.length];

    for (int i = 0; i < temp.length; i++) {
      inputList[i] = Integer.parseInt(temp[i]);
    }

    int[] data = new int[256];
    for (int j = 0; j < 256; j++) {
      data[j] = j;
    }
    return data;
  }


  private int part1(int[] data) {
    int[] hash = Arrays.copyOf(data, data.length);
    int index = 0;
    int skipSize = 0;

    for (int currentLength : inputList) {
      int[] temp = new int[currentLength];
      for (int j = 0; j < currentLength; j++) {
        temp[j] = hash[(index + j) % data.length];
      }
      for (int k = 0; k < currentLength; k++) {
        hash[(index + k) % data.length] = temp[currentLength - 1 - k];
      }
      index = (index + currentLength + skipSize) % data.length;
      skipSize++;
    }
    return (hash[0] * hash[1]);
  }


  private String part2(int[] data) {
    int[] hash = Arrays.copyOf(data, data.length);
    getSparseHash(hash);
    return getDenseHash(hash);
  }
  
  
  private void getSparseHash(int[] hash) {
    int[] lengthList = getAsciiList();
    int hashLength = hash.length;

    int index = 0;
    int skipSize = 0;
    for (int i = 0; i < 64; i++) {
      for (int currentLength : lengthList) {
        int[] temp = new int[currentLength];
        for (int j = 0; j < currentLength; j++) {
          temp[j] = hash[(index + j) % hashLength];
        }
        for (int k = 0; k < currentLength; k++) {
          hash[(index + k) % hashLength] = temp[currentLength - 1 - k];
        }
        index = (index + currentLength + skipSize) % hashLength;
        skipSize++;
      }
    }
  }


  private int[] getAsciiList() {
    int[] appendToAsciiList = {17, 31, 73, 47, 23};
    int[] asciiList = new int[inputString.length() + appendToAsciiList.length];

    for (int i = 0; i < inputString.length(); i++) {
      asciiList[i] = (int) inputString.charAt(i);
    }
    System.arraycopy(appendToAsciiList, 0
        , asciiList, inputString.length(), appendToAsciiList.length);

    return asciiList;
  }


  private String getDenseHash(int[] hash) {
    String denseHash = "";
    int[] hashBlock = new int[16];

    for (int i = 0; i < 16; i ++) {
      System.arraycopy(hash, (i * 16), hashBlock, 0, 16);
      int bitwiseResult = 0;
      for (int j = 0; j < 16; j++) {
        bitwiseResult = bitwiseResult ^ hashBlock[j];
      }
      denseHash = denseHash.concat(Integer.toHexString(bitwiseResult));
    }
    return denseHash;
  }
}
