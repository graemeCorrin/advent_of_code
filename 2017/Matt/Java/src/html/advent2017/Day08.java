package html.advent2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

class Day08 extends DayBase {
  String dataFile = "data/day08";


  void solution() {
    String[] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(data));
  }


  private String[] getData() {
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

    String[] entries = new String[lineCount];
    System.arraycopy(lines, 0, entries, 0, lineCount);

    return entries;
  }


  private int part1(String[] data) {
    int highValue = 0;
    HashMap<String, Integer> map = new HashMap<>();

    for (String line : data) {
      boolean condition = false;

      String[] instruction = line.split(" ");

      String conditionRegister = instruction[4];
      String conditionOperator = instruction[5];
      int conditionValue = Integer.parseInt(instruction[6]);
      String commandRegister = instruction[0];
      int commandOperator = (instruction[1].equals("inc") ? 1 : -1);
      int commandValue = Integer.parseInt(instruction[2]);

      if (!map.containsKey(conditionRegister)) {
        map.put(conditionRegister, 0);
      }
      if (!map.containsKey(commandRegister)) {
        map.put(commandRegister, 0);
      }

      switch (conditionOperator) {
        case "==":
          if (map.get(conditionRegister) == conditionValue) {
            condition = true;
          }
          break;
        case "!=":
          if (map.get(conditionRegister) != conditionValue) {
            condition = true;
          }
          break;
        case "<":
          if (map.get(conditionRegister) < conditionValue) {
            condition = true;
          }
          break;
        case "<=":
          if (map.get(conditionRegister) <= conditionValue) {
            condition = true;
          }
          break;
        case ">":
          if (map.get(conditionRegister) > conditionValue) {
            condition = true;
          }
          break;
        case ">=":
          if (map.get(conditionRegister) >= conditionValue) {
            condition = true;
          }
          break;
      }

      if (condition) {
        map.replace(commandRegister, map.get(commandRegister) + (commandOperator * commandValue));
      }
    }

    Collection<Integer> values = map.values();
    for (Integer value : values) {
      highValue = value > highValue ? value : highValue;
    }
    return highValue;
  }


  private int part2(String[] data) {
    int highValue = 0;
    HashMap<String, Integer> map = new HashMap<>();

    for (String line : data) {
      boolean condition = false;

      String[] instruction = line.split(" ");

      String conditionRegister = instruction[4];
      String conditionOperator = instruction[5];
      int conditionValue = Integer.parseInt(instruction[6]);
      String commandRegister = instruction[0];
      int commandOperator = (instruction[1].equals("inc") ? 1 : -1);
      int commandValue = Integer.parseInt(instruction[2]);

      if (!map.containsKey(conditionRegister)) {
        map.put(conditionRegister, 0);
      }
      if (!map.containsKey(commandRegister)) {
        map.put(commandRegister, 0);
      }

      switch (conditionOperator) {
        case "==":
          if (map.get(conditionRegister) == conditionValue) {
            condition = true;
          }
          break;
        case "!=":
          if (map.get(conditionRegister) != conditionValue) {
            condition = true;
          }
          break;
        case "<":
          if (map.get(conditionRegister) < conditionValue) {
            condition = true;
          }
          break;
        case "<=":
          if (map.get(conditionRegister) <= conditionValue) {
            condition = true;
          }
          break;
        case ">":
          if (map.get(conditionRegister) > conditionValue) {
            condition = true;
          }
          break;
        case ">=":
          if (map.get(conditionRegister) >= conditionValue) {
            condition = true;
          }
          break;
      }

      if (condition) {
        map.replace(commandRegister, map.get(commandRegister) + (commandOperator * commandValue));
        highValue = map.get(commandRegister) > highValue ? map.get(commandRegister) : highValue;
      }
    }
    return highValue;
  }
}
