package html.advent2017.day18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class DuetProcess {
  private String duetProcessID;
  private String sisterProcessID;
  private DuetProcess sisterReference;
  private String[][] commandList;
  private LinkedList<Long> receiveQueue;
  private HashMap<String, RegisterLong> registerHashMap;

  private boolean wait = false;
  private boolean complete = false;
  private int commandIndex;
  private long sendCount;


  public DuetProcess(String duetProcessID, String sisterProcessID) {
    this.duetProcessID = duetProcessID;
    this.sisterProcessID = sisterProcessID;
  }
  
  
  void reset(String commandListFilePath) {
    receiveQueue = new LinkedList<>();
    registerHashMap = new HashMap<>();
    registerHashMap.put("p", new RegisterLong("p", Long.parseLong(getDuetProcessID())));
    commandIndex = 0;
    setCommandList(commandListFilePath);
    sendCount = 0;
  }
  
  
  void runFrame() {
    if (!isComplete()) {
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
  }


  String getDuetProcessID() {
    return duetProcessID;
  }


  String getSisterProcessID() {
    return sisterProcessID;
  }


  void setSisterReference(DuetProcess sisterReference) {
    this.sisterReference = sisterReference;
  }


  private void setCommandList(String inputFilePath) {
    String line;
    int lineCount = 0;
    String[] lines = new String[2000];

    try {
      FileReader fRead = new FileReader(inputFilePath);
      BufferedReader bRead = new BufferedReader(fRead);
      while ((line = bRead.readLine()) != null) {
        lines[lineCount] = line;
        lineCount++;
      }
      bRead.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    commandList = new String[lineCount][];
    for (int i = 0; i < lineCount; i++) {
      commandList[i] = lines[i].split(" ");
    }
  }


  private void addToReceiveQueue(long x) {
    receiveQueue.add(x);
  }


  boolean isWait() {
    return wait;
  }
  
  
  boolean isComplete() {
    return complete;
  }


  long getSendCount() {
    return sendCount;
  }


  private void send(long x) {
    sisterReference.addToReceiveQueue(x);
    sendCount++;
  }


  private void send(RegisterLong x) {
    send(x.getValue());
  }


  private void set(RegisterLong x, long y) {
    x.setValue(y);
  }


  private void set(RegisterLong x, RegisterLong y) {
    set(x, y.getValue());
  }


  private void add(RegisterLong x, long y) {
    x.setValue(x.getValue() + y);
  }


  private void add(RegisterLong x, RegisterLong y) {
    add(x, y.getValue());
  }


  private void multiply(RegisterLong x, long y) {
    x.setValue(x.getValue() * y);
  }


  private void multiply(RegisterLong x, RegisterLong y) {
    multiply(x, y.getValue());
  }


  private void modulo(RegisterLong x, long y) {
    x.setValue(x.getValue() % y);
  }


  private void modulo(RegisterLong x, RegisterLong y) {
    modulo(x, y.getValue());
  }


  private void receive(RegisterLong x) {
    if (receiveQueue.isEmpty()) {
      wait = true;
    } else {
      wait = false;
      x.setValue(receiveQueue.poll());
    }
  }


  private int jumpIfGreaterThanZero(long x, long y) {
    return x > 0 ? (int) y : 1;
  }


  private int jumpIfGreaterThanZero(RegisterLong x, long y) {
    return jumpIfGreaterThanZero(x.getValue(), y);
  }


  private int jumpIfGreaterThanZero(long x, RegisterLong y) {
    return jumpIfGreaterThanZero(x, y.getValue());
  }


  private int jumpIfGreaterThanZero(RegisterLong x, RegisterLong y) {
    return jumpIfGreaterThanZero(x.getValue(), y.getValue());
  }


  private int commandSwitch(String command, long argumentOne, long argumentTwo) {
    int result = 1;

    switch (command) {
      case "jgz":
        result = jumpIfGreaterThanZero(argumentOne, argumentTwo);
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
      case "add":
        add(argumentOne, argumentTwo);
        break;
      case "mul":
        multiply(argumentOne, argumentTwo);
        break;
      case "mod":
        modulo(argumentOne, argumentTwo);
        break;
      case "jgz":
        result = jumpIfGreaterThanZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, long argumentOne, RegisterLong argumentTwo) {
    int result = 1;

    switch (command) {
      case "jgz":
        result = jumpIfGreaterThanZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }


  private int commandSwitch(String command, RegisterLong argumentOne, RegisterLong argumentTwo) {
    int result = 1;

    switch (command) {
      case "snd":
        send(argumentOne);
        break;
      case "set":
        set(argumentOne, argumentTwo);
        break;
      case "add":
        add(argumentOne, argumentTwo);
        break;
      case "mul":
        multiply(argumentOne, argumentTwo);
        break;
      case "mod":
        modulo(argumentOne, argumentTwo);
        break;
      case "rcv":
        receive(argumentOne);
        if(isWait()) {
          result = 0;
        }
        break;
      case "jgz":
        result = jumpIfGreaterThanZero(argumentOne, argumentTwo);
        break;
    }
    return result;
  }
}
