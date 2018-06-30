package html.advent2017.day24;

public class Component {
  private String componentID;
  private int[] portValues;

  public Component() {
    this("", new int[2]);
  }


  public Component(String componentID) {
    this(componentID, new int[2]);
  }


  public Component(int[] portValues) {
    this("", portValues);
  }


  public Component(String componentID, int[] portValues) {
    this.componentID = componentID;
    this.portValues = portValues;
  }


  public Component(int portValueA, int portValueB) {
    this("", portValueA, portValueB);
  }


  public Component(String componentID, int portValueA, int portValueB) {
    this(componentID, new int[2]);
    portValues[0] = portValueA;
    portValues[1] = portValueB;
  }


  public Component(Component other) {
    componentID = other.componentID;
    portValues = other.portValues;
  }


  public Component copyComponent() {
    return new Component(this);
  }


  public void setComponentID(String componentID) {
    this.componentID = componentID;
  }


  public String getComponentID() {
    return componentID;
  }


  public void setPortValues(int[] portValues) {
    this.portValues = portValues;
  }


  public int[] getPortValues() {
    return portValues;
  }


  public void flipComponent() {
    int temp = portValues[0];
    portValues[0] = portValues[1];
    portValues[1] = temp;
  }


  public int getComponentStrength() {
    return (portValues[0] + portValues[1]);
  }
}
