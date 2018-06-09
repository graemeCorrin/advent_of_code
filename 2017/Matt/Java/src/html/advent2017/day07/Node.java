package html.advent2017.day07;

public class Node {
  private String name;
  private int weight;
  private Node[] children;
  private Node parent;
  private boolean root;
  private int childCount;
  private int towerWeight;


  public Node() {
    this("");
  }


  public Node(String name) {
    this(name, 0, 10);
  }


  public Node(String name, int weight, int maxChildren) {
    this.name = name;
    this.weight = weight;
    children = new Node[maxChildren];
    parent = null;
    root = true;
    childCount = 0;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }


  public void setWeight(int weight) {
    this.weight = weight;
  }


  public int getWeight() {
    return weight;
  }


  public void addChild(Node child) {
    children[childCount] = child;
    childCount++;
  }


  public Node getChild(int index) {
    return children[index];
  }


  public void setParent(Node parent) {
    this.parent = parent;
    root = false;
  }


  public Node getParent() {
    return parent;
  }


  public boolean isRoot() {
    return root;
  }


  public int setTowerWeight() {
    towerWeight = weight;
    for (int i = 0; i < childCount; i++) {
      towerWeight += children[i].setTowerWeight();
    }
    return towerWeight;
  }


  public int getTowerWeight() {
    return towerWeight;
  }


  public int findWeightDifference() {
    int difference = 0;
    boolean findDiff = false;

    if (childCount > 0) {
      int baseWeight = children[0].getTowerWeight();
      for (int i = 1; i < childCount; i++) {
        if (baseWeight != children[i].getTowerWeight()) {
          if (findDiff) {
            difference *= -1;
            break;
          } else {
            difference = baseWeight - children[i].getTowerWeight();
            findDiff = true;
          }
        }
      }
    }
    return difference;
  }


  public Node findDifferentNode() {
    Node different = this;
    int diffIndex = -1;

    if (childCount > 0) {
      int baseWeight = children[0].getTowerWeight();
      for (int i = 1; i < childCount; i++) {
        if (baseWeight != children[i].getTowerWeight()) {
          if (diffIndex > -1) {
            diffIndex = 0;
            break;
          } else {
            diffIndex = i;
          }
        }
      }
      if (diffIndex > -1) {
        return children[diffIndex].findDifferentNode();
      }
    }
    return different;
  }
}
