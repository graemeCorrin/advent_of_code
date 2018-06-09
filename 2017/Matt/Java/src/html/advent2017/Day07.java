package html.advent2017;

import html.advent2017.day07.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Day07 extends DayBase {
   private String dataFile = "data/day07";
   private Node root;


  void solution() {
    String[] data = getData();
    HashMap<String, Node> treeNodes = buildTree(data);
    System.out.println(part1(treeNodes));
    System.out.println(part2(treeNodes));
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


  private HashMap<String, Node> buildTree(String[] data) {
    HashMap<String, Node> map = new HashMap<>();

    for (int i = 0; i < data.length; i ++) {
      String [] words = data[i].split(" ");
      Node tempNode;

      if (!map.containsKey(words[0])) {
        map.put(words[0], new Node(words[0]));
      }

      tempNode = map.get(words[0]);
      tempNode.setWeight(Integer.parseInt(words[1].replaceAll("\\(", "")
          .replaceAll("\\)", "")));

      for (int j = 3; j < words.length; j++) {
        String childName = words[j].replaceAll(",", "");
        if (!map.containsKey(childName)) {
          map.put(childName, new Node(childName));
        }
        Node tempChild = map.get(childName);
        tempNode.addChild(tempChild);
        tempChild.setParent(map.get(tempNode.getName()));
      }
    }
    return map;
  }


  private String part1(HashMap<String, Node> treeNodes) {
    String result = "oops";

    for (Node value : treeNodes.values()) {
      if (value.isRoot()) {
        root = value;
        result = value.getName();
        break;
      }
    }
    return result;
  }


  private int part2(HashMap<String, Node> treeNodes) {
    root.setTowerWeight();
    return root.findWeightDifference() + root.findDifferentNode().getWeight();
  }
}
