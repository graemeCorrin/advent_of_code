package html.advent2017.day18;

public class DuetMusic {
  private long lastPlayedSound;

  public DuetMusic() {
    lastPlayedSound = 0;
  }


  public void sound(long x) {
    lastPlayedSound = x;
  }


  public void sound(Register x) {
    sound(x.getValue());
  }


  public void set(Register x, long y) {
    x.setValue(y);
  }


  public void set(Register x, Register y) {
    set(x, y.getValue());
  }


  public void add(Register x, long y) {
    x.setValue(x.getValue() + y);
  }


  public void add(Register x, Register y) {
    add(x, y.getValue());
  }


  public void multiply(Register x, long y) {
    x.setValue(x.getValue() * y);
  }


  public void multiply(Register x, Register y) {
    multiply(x, y.getValue());
  }


  public void modulo(Register x, long y) {
    x.setValue(x.getValue() % y);
  }


  public void modulo(Register x, Register y) {
    modulo(x, y.getValue());
  }


  public long recover(long x) {
    if (x != 0) {
      return lastPlayedSound;
    }
    return 0;
  }


  public long recover(Register x) {
    return recover(x.getValue());
  }


  public long jumpIfGreaterThanZero(long x, long y) {
    return x > 0 ? y : 1;
  }


  public long jumpIfGreaterThanZero(Register x, long y) {
    return jumpIfGreaterThanZero(x.getValue(), y);
  }


  public long jumpIfGreaterThanZero(long x, Register y) {
    return jumpIfGreaterThanZero(x, y.getValue());
  }


  public long jumpIfGreaterThanZero(Register x, Register y) {
    return jumpIfGreaterThanZero(x.getValue(), y.getValue());
  }
}
