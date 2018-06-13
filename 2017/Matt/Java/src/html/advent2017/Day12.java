package html.advent2017;

import html.advent2017.day12.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Day12 extends DayBase {
  private String dataFile = "data/day12";


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
        line = line.replaceAll(" <-> ", " ");
        line = line.replaceAll(",", "");
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
    HashMap<String, Program> programDictionary = new HashMap<>();
    for (String line : data) {
      programDictionary.put(line.split(" ")[0], new Program(line.split(" ")[0]));
    }

    for (String line : data) {
      String[] words = line.split(" ");
      for (int i = 1; i < words.length; i++) {
        programDictionary.get(words[0]).addPipe(programDictionary.get(words[i]));
      }
    }

    HashSet<Program> zeroPingGroup = new HashSet<>();
    programDictionary.get("0").getPingGroup(zeroPingGroup);

    return zeroPingGroup.size();
  }


  private  int part2(String[] data) {
    int groupCount = 0;
    HashMap<String, Program> programDictionary = new HashMap<>();
    HashSet<Program> inGroup = new HashSet<>();

    for (String line : data) {
      programDictionary.put(line.split(" ")[0], new Program(line.split(" ")[0]));

    }

    for (String line : data) {
      String[] words = line.split(" ");
      for (int i = 1; i < words.length; i++) {
        programDictionary.get(words[0]).addPipe(programDictionary.get(words[i]));
      }
    }

    for (Program prog : programDictionary.values()) {
      if (!inGroup.contains(prog)) {
        HashSet<Program> group = new HashSet<>();
        prog.getPingGroup(group);
        inGroup.addAll(group);
        groupCount++;
      }
    }

    return groupCount;
  }
}
