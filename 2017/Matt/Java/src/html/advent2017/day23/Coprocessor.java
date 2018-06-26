package html.advent2017.day23;

import java.util.Arrays;
import java.util.HashMap;

public class Coprocessor {
  private int commandIndex;
  private HashMap<String, RegisterInt> registerHashMap;
  private String[][] commandList;
  private boolean complete;


  public Coprocessor(String[][] commandList) {
    complete = false;
    commandIndex = 0;
    registerHashMap = new HashMap<>();
    registerHashMap.put("a", new RegisterInt("a", 1));
    registerHashMap.put("h", new RegisterInt("h", 0));
    this.commandList = new String[commandList.length][];
    for (int i = 0; i < commandList.length; i ++) {
      this.commandList[i] = Arrays.copyOf(commandList[i], commandList[i].length);
    }
  }

  
  public int run() {
    while (!isComplete()) {
      if (commandIndex == 25) {
        System.out.println(registerHashMap.get("h").getValue());
      }


      String[] command = new String[3];
      Arrays.fill(command, " ");
      System.arraycopy(commandList[commandIndex], 0, command, 0, commandList[commandIndex].length);
      boolean argumentOneRegister = false;
      boolean argumentTwoRegister = false;

      if (command[1].charAt(0) >= 'a' && command[1].charAt(0) <= 'z') {
        argumentOneRegister = true;
        if (!registerHashMap.containsKey(command[1])) {
          registerHashMap.put(command[1], new RegisterInt(command[1]));
        }
      }
      if ((command[2].charAt(0) >= 'a' && command[2].charAt(0) <= 'z') || command[2].charAt(0) == ' ') {
        argumentTwoRegister = true;
        if (!registerHashMap.containsKey(command[2])) {
          registerHashMap.put(command[2], new RegisterInt(command[2]));
        }
      }

      if (argumentOneRegister && argumentTwoRegister) {
        commandIndex += commandSwitch(command[0], registerHashMap.get(command[1]), registerHashMap.get(command[2]));
      } else if (argumentOneRegister) {
        commandIndex += commandSwitch(command[0], registerHashMap.get(command[1]), Integer.parseInt(command[2]));
      } else if (argumentTwoRegister) {
        commandIndex += commandSwitch(command[0], Integer.parseInt(command[1]), registerHashMap.get(command[2]));
      } else {
        commandIndex += commandSwitch(command[0], Integer.parseInt(command[1]), Integer.parseInt(command[2]));
      }

      if (commandIndex < 0 || commandIndex >= commandList.length) {
        complete = true;
      }
    }
    return getRegisterH();
  }


  public int getRegisterH() {
    return registerHashMap.get("h").getValue();
  }


  public boolean isComplete() {
    return complete;
  }


  public void set(RegisterInt x, int y) {
    x.setValue(y);
  }
  
  
  public void set(RegisterInt x, RegisterInt y) {
    set(x, y.getValue());
  }


  public void add(RegisterInt x, int y) {
    x.setValue(x.getValue() + y);
  }


  public void add(RegisterInt x, RegisterInt y) {
    add(x, y.getValue());
  }
  
  
  public void subtract(RegisterInt x, int y) {
    x.setValue(x.getValue() - y);
  }
  
  
  public void subtract(RegisterInt x, RegisterInt y) {
    subtract(x, y.getValue());
  }
  
  
  public void multiply(RegisterInt x, int y) {
    x.setValue(x.getValue() * y);
  }
  
  
  public void multiply(RegisterInt x, RegisterInt y) {
    multiply(x, y.getValue());
  }
  
  
  public int jumpIfNotZero(int x, int y) {
    return x != 0 ? y : 1;
  }
  
  
  public int jumpIfNotZero(RegisterInt x, int y) {
    return jumpIfNotZero(x.getValue(), y);
  }
  
  
  public int jumpIfNotZero(int x, RegisterInt y) {
    return jumpIfNotZero(x, y.getValue());
  }
  
  
  public int jumpIfNotZero(RegisterInt x, RegisterInt y) {
    return jumpIfNotZero(x.getValue(), y.getValue());
  }


  public int jumpIfPrime(RegisterInt x, int y) {
    return isPrime(x.getValue()) ?  y : 1;
  }


  private int commandSwitch(String command, int argumentOne, int argumentTwo) {
    int result = 1;

    switch (command) {
      case "jnz":
        result = jumpIfNotZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, RegisterInt argumentOne, int argumentTwo) {
    int result = 1;

    switch (command) {
      case "set":
        set(argumentOne, argumentTwo);
        break;
      case "mul":
        multiply(argumentOne, argumentTwo);
        break;
      case "add":
        add(argumentOne, argumentTwo);
        break;
      case "sub":
        subtract(argumentOne, argumentTwo);
        break;
      case "jnz":
        result = jumpIfNotZero(argumentOne, argumentTwo);
        break;
      case "jip":
        result = jumpIfPrime(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, int argumentOne, RegisterInt argumentTwo) {
    int result = 1;

    switch (command) {
      case "jnz":
        result = jumpIfNotZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, RegisterInt argumentOne, RegisterInt argumentTwo) {
    int result = 1;

    switch (command) {
      case "set":
        set(argumentOne, argumentTwo);
        break;
      case "mul":
        multiply(argumentOne, argumentTwo);
        break;
      case "add":
        add(argumentOne, argumentTwo);
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


  private boolean isPrime(int n) {
    if (n%2==0) return false;
    for(int i=3;i*i<=n;i+=2) {
      if(n%i==0)
        return false;
    }
    return true;
  }
}
