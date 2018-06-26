package html.advent2017;

import html.advent2017.day18.DuetMusic;
import html.advent2017.day18.DuetProgram;
import html.advent2017.day18.RegisterLong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

class Day18 extends DayBase {
  String dataFile = "data/day18";


  void solution() {
    String[][] data = getData();
    System.out.println(part1(data));
    System.out.println(part2(dataFile));
  }


  private String[][] getData() {
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

    String[][] data = new String[lineCount][];

    for (int i = 0; i < lineCount; i++) {
      data[i] = lines[i].split(" ");
    }

    return data;
  }


  private long part1(String[][] data) {
    DuetMusic duetMusic = new DuetMusic();
    int commandIndex = 0;
    long firstRecover = 0;
    HashMap<String, RegisterLong> registerHashMap = new HashMap<>();

    while (commandIndex >= 0 && commandIndex < data.length) {
      String[] command = new String[3];
      Arrays.fill(command, " ");
      System.arraycopy(data[commandIndex], 0, command, 0, data[commandIndex].length);
      boolean argumentOneRegister = false;
      boolean argumentTwoRegister = false;

      if (command[1].charAt(0) >= 'a' && command[1].charAt(0) <= 'z') {
        argumentOneRegister = true;
        if (!registerHashMap.containsKey(command[1])) {
          registerHashMap.put(command[1], new RegisterLong(command[1]));
        }
      }
      if ((command[2].charAt(0) >= 'a' && command[2].charAt(0) <= 'z') || command[2].charAt(0) == ' ') {
        argumentTwoRegister = true;
        if (!registerHashMap.containsKey(command[2])) {
          registerHashMap.put(command[2], new RegisterLong(command[2]));
        }
      }

      String[] result;

      if (argumentOneRegister && argumentTwoRegister) {
        result = commandSwitch(duetMusic, command[0], registerHashMap.get(command[1]), registerHashMap.get(command[2]));
      } else if (argumentOneRegister) {
        result = commandSwitch(duetMusic, command[0], registerHashMap.get(command[1]), Long.parseLong(command[2]));
      } else if (argumentTwoRegister) {
        result = commandSwitch(duetMusic, command[0], Long.parseLong(command[1]), registerHashMap.get(command[2]));
      } else {
        result = commandSwitch(duetMusic, command[0], Long.parseLong(command[1]), Long.parseLong(command[2]));
      }

      if (result[0].equals("rcv") && Long.parseLong(result[1]) != 0) {
        firstRecover = Long.parseLong(result[1]);
        return firstRecover;
      } else if (result[0].equals("jgz")) {
        commandIndex += (int)Long.parseLong(result[1]);
      } else {
        commandIndex++;
      }
    }
    return firstRecover;
  }


  private long part2(String inputCommandList) {
    DuetProgram duet = new DuetProgram();
    return duet.run(inputCommandList);
  }


  private String[] commandSwitch(DuetMusic duetMusic, String command, long argumentOne, long argumentTwo) {
    String[] result = new String[2];
    result[0] = command;
    
    switch (command) {
      case "snd":
        duetMusic.sound(argumentOne);
        break;
      case "rcv":
        result[1] = Long.toString(duetMusic.recover(argumentOne));
        break;
      case "jgz":
        result[1] = Long.toString(duetMusic.jumpIfGreaterThanZero(argumentOne, argumentTwo));
        break;
    }
    return result;
  }


  private String[] commandSwitch(DuetMusic duetMusic, String command, RegisterLong argumentOne, long argumentTwo) {
    String[] result = new String[2];
    result[0] = command;

    switch (command) {
      case "snd":
        duetMusic.sound(argumentOne);
        break;
      case "set":
        duetMusic.set(argumentOne, argumentTwo);
        break;
      case "add":
        duetMusic.add(argumentOne, argumentTwo);
        break;
      case "mul":
        duetMusic.multiply(argumentOne, argumentTwo);
        break;
      case "mod":
        duetMusic.modulo(argumentOne, argumentTwo);
        break;
      case "rcv":
        result[1] = Long.toString(duetMusic.recover(argumentOne));
        break;
      case "jgz":
        result[1] = Long.toString(duetMusic.jumpIfGreaterThanZero(argumentOne, argumentTwo));
        break;
    }
    return result;
  }


  private String[] commandSwitch(DuetMusic duetMusic, String command, long argumentOne, RegisterLong argumentTwo) {
    String[] result = new String[2];
    result[0] = command;

    switch (command) {
      case "snd":
        duetMusic.sound(argumentOne);
        break;
      case "rcv":
        result[1] = Long.toString(duetMusic.recover(argumentOne));
        break;
      case "jgz":
        result[1] = Long.toString(duetMusic.jumpIfGreaterThanZero(argumentOne, argumentTwo));
        break;
    }
    return result;
  }


  private String[] commandSwitch(DuetMusic duetMusic, String command, RegisterLong argumentOne, RegisterLong argumentTwo) {
    String[] result = new String[2];
    result[0] = command;

    switch (command) {
      case "snd":
        duetMusic.sound(argumentOne);
        break;
      case "set":
        duetMusic.set(argumentOne, argumentTwo);
        break;
      case "add":
        duetMusic.add(argumentOne, argumentTwo);
        break;
      case "mul":
        duetMusic.multiply(argumentOne, argumentTwo);
        break;
      case "mod":
        duetMusic.modulo(argumentOne, argumentTwo);
        break;
      case "rcv":
        result[1] = Long.toString(duetMusic.recover(argumentOne));
        break;
      case "jgz":
        result[1] = Long.toString(duetMusic.jumpIfGreaterThanZero(argumentOne, argumentTwo));
        break;
    }
    return result;
  }
}
