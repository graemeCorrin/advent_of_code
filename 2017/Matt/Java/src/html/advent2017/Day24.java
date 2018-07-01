package html.advent2017;

import html.advent2017.day24.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

class Day24 extends DayBase {
  private String dataFile = "data/day24";
  private HashSet<Component> completeComponentSet;

  void solution() {
    completeComponentSet = getData();
    System.out.println(part1());
    System.out.println(part2());
  }


  private int part1() {
    Component root = new Component(0, 0);
    HashSet<Component> strongestBridgeSet = generateStrongestBridge(root, completeComponentSet);
    return bridgeStrength(strongestBridgeSet);
  }


  private int part2() {
    Component root = new Component(0, 0);
    HashSet<Component> longestBridgeSet = generateLongestBridge(root, completeComponentSet);
    return bridgeStrength(longestBridgeSet);
  }


  private HashSet<Component> getData() {
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

    HashSet<Component> data = new HashSet<>();

    for (int i = 0; i < lineCount; i++) {
      String[] temp = lines[i].split("/");
      int[] ports = new int[2];
      ports[0] = Integer.parseInt(temp[0]);
      ports[1] = Integer.parseInt(temp[1]);
      data.add(new Component(Integer.toString(i), ports));
    }
    return data;
  }


  private HashSet<Component> generateStrongestBridge(Component previousComponent
      , HashSet<Component> unusedComponents) {
    HashSet<Component> availableComponents = new HashSet<>(unusedComponents);
    int maxStrength = 0;
    HashSet<Component> maxUsedComponents = new HashSet<>(completeComponentSet);
    maxUsedComponents.removeAll(unusedComponents);

    for (Component component : availableComponents) {
      boolean doesConnect = false;
      if (component.getPortValues()[0] == previousComponent.getPortValues()[1]) {
        doesConnect = true;
      } else if (component.getPortValues()[1] == previousComponent.getPortValues()[1]) {
        component.flipComponent();
        doesConnect = true;
      }

      if (doesConnect) {
        HashSet<Component> tempAvailableComponents = new HashSet<>(availableComponents);
        tempAvailableComponents.remove(component);

        HashSet<Component> tempUsedComponents = generateStrongestBridge(component, tempAvailableComponents);

        int strength = bridgeStrength(tempUsedComponents);
        if (strength > maxStrength) {
          maxStrength = strength;
          maxUsedComponents = tempUsedComponents;
        }
      }
    }
    return maxUsedComponents;
  }


  private int bridgeStrength(HashSet<Component> usedComponents) {
    int strength = 0;
    for (Component piece : usedComponents) {
      strength += piece.getComponentStrength();
    }
    return strength;
  }


  private HashSet<Component> generateLongestBridge(Component previousComponent
      , HashSet<Component> unusedComponents) {
    HashSet<Component> availableComponents = new HashSet<>(unusedComponents);
    int maxLength = 0;
    HashSet<Component> maxUsedComponents = new HashSet<>(completeComponentSet);
    maxUsedComponents.removeAll(unusedComponents);

    for (Component component : availableComponents) {
      boolean doesConnect = false;
      if (component.getPortValues()[0] == previousComponent.getPortValues()[1]) {
        doesConnect = true;
      } else if (component.getPortValues()[1] == previousComponent.getPortValues()[1]) {
        component.flipComponent();
        doesConnect = true;
      }

      if (doesConnect) {
        HashSet<Component> tempAvailableComponents = new HashSet<>(availableComponents);
        tempAvailableComponents.remove(component);

        HashSet<Component> tempUsedComponents = generateLongestBridge(component, tempAvailableComponents);

        int length = tempUsedComponents.size();
        if (length > maxLength || (length == maxLength && bridgeStrength(tempUsedComponents)
                                                            > bridgeStrength(maxUsedComponents))) {
          maxLength = length;
          maxUsedComponents = tempUsedComponents;
        }
      }
    }
    return maxUsedComponents;
  }
}
