package html.advent2017;

import html.advent2017.day25.TuringMachine;
import html.advent2017.day25.TuringState;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Day25 extends  DayBase {
  String dataFile = "data/day25";
  private String initialTuringState;
  private long targetSteps;
  private HashMap<String, TuringState> stateMap;

  void solution() {
    getData();
    System.out.println(part1());
  }


  private long part1() {
    TuringMachine turingMachine = new TuringMachine(initialTuringState, stateMap);
    for (long i = 0; i < targetSteps; i++) {
      turingMachine.step();
    }
    return turingMachine.checksum();
  }


  private void getData() {
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

    stateMap = new HashMap<>();
    TuringState currentTuringState = new TuringState("");
    for (int i = 0; i < lineCount; i++) {
      String[] temp = lines[i].split(" ");

      if (i == 0) {
        initialTuringState = temp[temp.length - 1].replaceAll("\\.", "");
      } else if (i == 1) {
        targetSteps = Long.parseLong(temp[temp.length - 2]);
      } else if (i % 10 == 3) {
        currentTuringState = new TuringState(temp[temp.length - 1].replaceAll(":", ""));
        stateMap.put(currentTuringState.getStateID(), currentTuringState);
      } else if (i % 10 == 5) {
        currentTuringState.setZeroWrite(Integer.parseInt(temp[temp.length - 1].replaceAll("\\.", "")));
      } else if (i % 10 == 6) {
        if (temp[temp.length - 1].replaceAll("\\.", "").equals("left")) {
          currentTuringState.setZeroMove(-1);
        } else if (temp[temp.length - 1].replaceAll("\\.", "").equals("right")) {
          currentTuringState.setZeroMove(1);
        }
      } else if (i % 10 == 7) {
        currentTuringState.setZeroState(temp[temp.length - 1].replaceAll("\\.", ""));
      } else if (i % 10 == 9) {
        currentTuringState.setOneWrite(Integer.parseInt(temp[temp.length - 1].replaceAll("\\.", "")));
      } else if (i % 10 == 0) {
        if (temp[temp.length - 1].replaceAll("\\.", "").equals("left")) {
          currentTuringState.setOneMove(-1);
        } else if (temp[temp.length - 1].replaceAll("\\.", "").equals("right")) {
          currentTuringState.setOneMove(1);
        }
      } else if (i % 10 == 1) {
        currentTuringState.setOneState(temp[temp.length - 1].replaceAll("\\.", ""));
      }
    }
  }



}
