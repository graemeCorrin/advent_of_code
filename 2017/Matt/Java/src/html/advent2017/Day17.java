package html.advent2017;

class Day17 extends DayBase {
  private int stepsPerSpin = 329;


  void solution() {
    System.out.println(part1(stepsPerSpin));
    System.out.println(part2(stepsPerSpin));
  }


  private int part1(int stepsPerInsert) {
    int index = 0;
    int[] spinlock = new int[2018];

    for (int i = 1; i < 2018; i++) {
      index = ((index + stepsPerInsert) % i) + 1;
      for (int j = i; j > index; j--) {
        spinlock[j] = spinlock[j - 1];
      }
      spinlock[index] = i;
    }
    return spinlock[index + 1];
  }


  private int part2(int stepsPerInsert) {
    int index = 0;
    int spinIndex1 = 0;

    for (int i = 1; i < 50000000; i++) {
      index = ((index + stepsPerInsert) % i) + 1;
      if (index == 1) {
        spinIndex1 = i;
      }
    }
    return spinIndex1;
  }
}
