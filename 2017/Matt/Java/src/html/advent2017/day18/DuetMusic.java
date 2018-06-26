package html.advent2017.day18;

public class DuetMusic {
  private long lastPlayedSound;

  public DuetMusic() {
    lastPlayedSound = 0;
  }


  public void sound(long x) {
    lastPlayedSound = x;
  }


  public void sound(RegisterLong x) {
    sound(x.getValue());
  }


  public void set(RegisterLong x, long y) {
    x.setValue(y);
  }


  public void set(RegisterLong x, RegisterLong y) {
    set(x, y.getValue());
  }


  public void add(RegisterLong x, long y) {
    x.setValue(x.getValue() + y);
  }


  public void add(RegisterLong x, RegisterLong y) {
    add(x, y.getValue());
  }


  public void multiply(RegisterLong x, long y) {
    x.setValue(x.getValue() * y);
  }


  public void multiply(RegisterLong x, RegisterLong y) {
    multiply(x, y.getValue());
  }


  public void modulo(RegisterLong x, long y) {
    x.setValue(x.getValue() % y);
  }


  public void modulo(RegisterLong x, RegisterLong y) {
    modulo(x, y.getValue());
  }


  public long recover(long x) {
    if (x != 0) {
      return lastPlayedSound;
    }
    return 0;
  }


  public long recover(RegisterLong x) {
    return recover(x.getValue());
  }


  public long jumpIfGreaterThanZero(long x, long y) {
    return x > 0 ? y : 1;
  }


  public long jumpIfGreaterThanZero(RegisterLong x, long y) {
    return jumpIfGreaterThanZero(x.getValue(), y);
  }


  public long jumpIfGreaterThanZero(long x, RegisterLong y) {
    return jumpIfGreaterThanZero(x, y.getValue());
  }


  public long jumpIfGreaterThanZero(RegisterLong x, RegisterLong y) {
    return jumpIfGreaterThanZero(x.getValue(), y.getValue());
  }
}
