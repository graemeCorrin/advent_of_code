package html.advent2017.day23;

import html.advent2017.day18.RegisterLong;

import java.util.Arrays;
import java.util.HashMap;

public class CoprocessorDebug {
  private int multiplyCount;
  private int commandIndex;
  private HashMap<String, RegisterLong> registerHashMap;
  private String[][] commandList;
  private boolean complete;

  
  public CoprocessorDebug(String[][] commandList) {
    complete = false;
    multiplyCount = 0;
    commandIndex = 0;
    registerHashMap = new HashMap<>();
    this.commandList = new String[commandList.length][];
    for (int i = 0; i < commandList.length; i ++) {
      this.commandList[i] = Arrays.copyOf(commandList[i], commandList[i].length);
    }
  }


  public long getMultiplyCount() {
    return multiplyCount;
  }

  
  public int run() {
    while (!isComplete()) {
      String[] command = new String[3];
      Arrays.fill(command, " ");
      System.arraycopy(commandList[commandIndex], 0, command, 0, commandList[commandIndex].length);
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

      if (argumentOneRegister && argumentTwoRegister) {
        commandIndex += commandSwitch(command[0], registerHashMap.get(command[1]), registerHashMap.get(command[2]));
      } else if (argumentOneRegister) {
        commandIndex += commandSwitch(command[0], registerHashMap.get(command[1]), Long.parseLong(command[2]));
      } else if (argumentTwoRegister) {
        commandIndex += commandSwitch(command[0], Long.parseLong(command[1]), registerHashMap.get(command[2]));
      } else {
        commandIndex += commandSwitch(command[0], Long.parseLong(command[1]), Long.parseLong(command[2]));
      }

      if (commandIndex < 0 || commandIndex >= commandList.length) {
        complete = true;
      }
    }
    return multiplyCount;
  }


  public boolean isComplete() {
    return complete;
  }


  public void set(RegisterLong x, long y) {
    x.setValue(y);
  }
  
  
  public void set(RegisterLong x, RegisterLong y) {
    set(x, y.getValue());
  }
  
  
  public void subtract(RegisterLong x, long y) {
    x.setValue(x.getValue() - y);
  }
  
  
  public void subtract(RegisterLong x, RegisterLong y) {
    subtract(x, y.getValue());
  }
  
  
  public void multiply(RegisterLong x, long y) {
    x.setValue(x.getValue() * y);
    multiplyCount++;
  }
  
  
  public void multiply(RegisterLong x, RegisterLong y) {
    multiply(x, y.getValue());
  }
  
  
  public int jumpIfNotZero(long x, long y) {
    return x != 0 ? (int) y : 1;
  }
  
  
  public int jumpIfNotZero(RegisterLong x, long y) {
    return jumpIfNotZero(x.getValue(), y);
  }
  
  
  public int jumpIfNotZero(long x, RegisterLong y) {
    return jumpIfNotZero(x, y.getValue());
  }
  
  
  public int jumpIfNotZero(RegisterLong x, RegisterLong y) {
    return jumpIfNotZero(x.getValue(), y.getValue());
  }


  private int commandSwitch(String command, long argumentOne, long argumentTwo) {
    int result = 1;

    switch (command) {
      case "jnz":
        result = jumpIfNotZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, RegisterLong argumentOne, long argumentTwo) {
    int result = 1;

    switch (command) {
      case "set":
        set(argumentOne, argumentTwo);
        break;
      case "mul":
        multiply(argumentOne, argumentTwo);
        break;
      case "sub":
        subtract(argumentOne, argumentTwo);
        break;
      case "jnz":
        result = jumpIfNotZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, long argumentOne, RegisterLong argumentTwo) {
    int result = 1;

    switch (command) {
      case "jnz":
        result = jumpIfNotZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, RegisterLong argumentOne, RegisterLong argumentTwo) {
    int result = 1;

    switch (command) {
      case "set":
        set(argumentOne, argumentTwo);
        break;
      case "mul":
        multiply(argumentOne, argumentTwo);
        break;
      case "sub":
        subtract(argumentOne, argumentTwo);
        break;
      case "jnz":
        result = jumpIfNotZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }
}
