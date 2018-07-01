package html.advent2017.day25;

public class TuringState {
  private String stateID;
  private int zeroWrite;
  private int zeroMove;
  private String zeroState;
  private int oneWrite;
  private int oneMove;
  private String oneState;

  public TuringState(String stateID) {
    this(stateID, 0, 0, "", 0, 0, "");
  }


  public TuringState(String stateID, int zeroWrite, int zeroMove, String zeroState
                                   , int oneWrite, int oneMove, String oneState) {
    this.stateID = stateID;
    this.zeroWrite = zeroWrite;
    this.zeroMove = zeroMove;
    this.zeroState = zeroState;
    this.oneWrite = oneWrite;
    this.oneMove = oneMove;
    this.oneState = oneState;
  }


  public String getStateID() {
    return stateID;
  }


  public void setZeroWrite(int zeroWrite) {
    this.zeroWrite = zeroWrite;
  }


  public int getZeroWrite() {
    return zeroWrite;
  }


  public void setZeroMove(int zeroMove) {
    this.zeroMove = zeroMove;
  }


  public int getZeroMove() {
    return zeroMove;
  }


  public void setZeroState(String zeroState) {
    this.zeroState = zeroState;
  }


  public String getZeroState() {
    return zeroState;
  }


  public void setOneWrite(int oneWrite) {
    this.oneWrite = oneWrite;
  }


  public int getOneWrite() {
    return oneWrite;
  }


  public void setOneMove(int oneMove) {
    this.oneMove = oneMove;
  }


  public int getOneMove() {
    return oneMove;
  }


  public void setOneState(String oneState) {
    this.oneState = oneState;
  }


  public String getOneState() {
    return oneState;
  }
}
