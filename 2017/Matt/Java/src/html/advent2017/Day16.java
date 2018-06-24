package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

class Day16 extends DayBase {
  String dataFile = "data/day16";


  void solution() {
    String[][] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private String[][] getData() {
    String line = "";
    try {
      FileReader fRead = new FileReader(dataFile);
      BufferedReader bRead = new BufferedReader(fRead);
      line = bRead.readLine();
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    String[] temp = line.split(",");
    String[][] data = new String[temp.length][];

    for (int i = 0; i < temp.length; i++) {
      data[i] = parseCommand(temp[i]);
    }

    return data;
  }


  private String part1(String[][] data) {
    String result = "";
    String[] programOrder = new String[16];
    for (int i = 0; i < 16; i++) {
      programOrder[i] = Character.toString((char)(97 + i));
    }

    for (String[] command : data) {
      switch (command[0]) {
        case "s":
          spin(programOrder, Integer.parseInt(command[1]));
          break;
        case "x":
          exchange(programOrder, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
          break;
        case"p":
          partner(programOrder, command[1], command[2]);
          break;
      }
    }
    for (String program : programOrder) {
      result = result.concat(program);
    }
    return result;
  }


  private String part2(String[][] data) {
    String result = "";
    String[] programOrder = new String[16];
    for (int i = 0; i < 16; i++) {
      programOrder[i] = Character.toString((char)(97 + i));
    }
    for (String program : programOrder) {
      result = result.concat(program);
    }
    boolean repeat = false;
    HashMap<String, String> orderMap = new HashMap<>();
    long count = 0;
    orderMap.put(Long.toString(count), result);

    while (!repeat) {
      count++;
      result = "";
      for (String[] command : data) {
        switch (command[0]) {
          case "s":
            spin(programOrder, Integer.parseInt(command[1]));
            break;
          case "x":
            exchange(programOrder, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            break;
          case"p":
            partner(programOrder, command[1], command[2]);
            break;
        }
      }
      for (String program : programOrder) {
        result = result.concat(program);
      }
      if (orderMap.containsValue(result)) {
        repeat = true;
      } else {
        orderMap.put(Long.toString(count), result);
      }
    }
    return orderMap.get(Long.toString(1000000000 % count));
  }


  private String[] parseCommand(String data) {
    String[] command = new String[3];
    command[0] = Character.toString(data.charAt(0));
    String[] temp = data.substring(1).split("/");
    command[1] = temp[0];
    if (temp.length < 2) {
      command[2] = "/";
    } else {
      command[2] = temp[1];
    }

    return command;
  }


  private void spin(String[] stringOrder, int toSpinCount) {
    String[] temp = Arrays.copyOf(stringOrder, stringOrder.length);
    System.arraycopy(temp, temp.length - toSpinCount, stringOrder, 0, toSpinCount);
    System.arraycopy(temp, 0, stringOrder, toSpinCount, temp.length - toSpinCount);
  }


  private void exchange(String[] stringOrder, int indexA, int indexB) {
    String programA = stringOrder[indexA];
    String programB = stringOrder[indexB];
    stringOrder[indexA] = programB;
    stringOrder[indexB] = programA;
  }

  private void partner(String[] stringOrder, String programA, String programB) {
    int indexA = 0;
    int indexB = 0;

    for (int i = 0; i < stringOrder.length; i++) {
      if (stringOrder[i].equals(programA)) {
        indexA = i;
      } else if (stringOrder[i].equals(programB)) {
        indexB = i;
      }
    }
    stringOrder[indexA] = programB;
    stringOrder[indexB] = programA;
  }
}
