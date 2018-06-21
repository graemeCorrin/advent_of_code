package html.advent2017.day18;

public class DuetProgram {
  private DuetProcess processZero;
  private DuetProcess processOne;

  public DuetProgram() {
    processZero = new DuetProcess("0", "1");
    processOne = new DuetProcess("1", "0");
    processZero.setSisterReference(processOne);
    processOne.setSisterReference(processZero);
  }


  public long run(String commandListFilePath) {
    processZero.reset(commandListFilePath);
    processOne.reset(commandListFilePath);

    while((!processZero.isComplete() && !processZero.isWait())
        || (!processOne.isComplete() && !processOne.isWait())) {
      processZero.runFrame();
      processOne.runFrame();
    }

    return processOne.getSendCount();
  }
}
