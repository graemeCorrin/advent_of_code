package html.advent2017.day25;

import java.util.HashMap;

public class TuringMachine {
  private int cursor;
  private String turingState;
  private HashMap<String, TuringState> stateMap;
  private int[] tape;
  private int tapeLength;

  public TuringMachine(String initialTuringState, HashMap<String, TuringState> stateMap) {
    cursor = 0;
    turingState = initialTuringState;
    this.stateMap = stateMap;
    tape = new int[16];
    tapeLength = tape.length;
  }


  public void step() {
    int currentValue = tape[cursor];
    TuringState currentState = stateMap.get(turingState);
    if (currentValue == 0) {
      tape[cursor] = currentState.getZeroWrite();
      cursor += currentState.getZeroMove();
      turingState = currentState.getZeroState();
    } else if(currentValue== 1) {
      tape[cursor] = currentState.getOneWrite();
      cursor += currentState.getOneMove();
      turingState = currentState.getOneState();
    }

    if (cursor >= tapeLength) {
      expandTapeRight();
    } else if (cursor < 0) {
      expandTapeLeft();
    }
  }


  public long checksum() {
    long result = 0;
    for (int value : tape) {
      result += (long) value;
    }
    return result;
  }


  private void expandTapeRight() {
    int[] temp = new int[tapeLength * 2];
    System.arraycopy(tape, 0, temp, tapeLength / 2, tapeLength);
    cursor -= tapeLength / 2;
    tapeLength *= 2;
    tape = temp;
  }


  private void expandTapeLeft() {
    int[] temp = new int[tapeLength * 2];
    System.arraycopy(tape, 0, temp, tapeLength / 2, tapeLength);
    cursor += tapeLength / 2;
    tapeLength *= 2;
    tape = temp;
  }
}
