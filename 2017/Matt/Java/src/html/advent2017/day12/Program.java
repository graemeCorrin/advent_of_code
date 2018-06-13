package html.advent2017.day12;

import java.util.HashSet;

public class Program {
  private String name;
  private Program[] pipes;
  private int pipeCount;


  public Program() {
    this("");
  }


  public Program(String name) {
    this.name = name;
    pipes = new Program[10];
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }


  public void addPipe(Program prog) {
    pipes[pipeCount] = prog;
    pipeCount++;
  }


  public Program[] getPipes() {
    return pipes;
  }


  public int getPipeCount() {
    return pipeCount;
  }


  public void getPingGroup(HashSet<Program> programSet) {
    for (int i = 0; i < pipeCount; i++) {
      if (!programSet.contains(pipes[i])) {
        programSet.add(pipes[i]);
        pipes[i].getPingGroup(programSet);
      }
    }
  }
}
