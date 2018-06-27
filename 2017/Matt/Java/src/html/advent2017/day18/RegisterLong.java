package html.advent2017.day18;

public class RegisterLong {
  private String name;
  private long value;

  public RegisterLong() {
    this("");
  }


  public RegisterLong(String name) {
    this(name, 0);
  }


  public RegisterLong(String name, long value) {
    this.name = name;
    this.value = value;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getName() {
    return name;
  }


  public void setValue(long value) {
    this.value = value;
  }


  public long getValue() {
    return value;
  }
}
