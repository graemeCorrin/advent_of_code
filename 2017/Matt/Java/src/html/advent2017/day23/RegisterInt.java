package html.advent2017.day23;

public class RegisterInt {
  private String name;
  private int value;

  public RegisterInt() {
    this("");
  }


  public RegisterInt(String name) {
    this(name, 0);
  }


  public RegisterInt(String name, int value) {
    this.name = name;
    this.value = value;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }


  public void setValue(int value) {
    this.value = value;
  }


  public int getValue() {
    return value;
  }
}
