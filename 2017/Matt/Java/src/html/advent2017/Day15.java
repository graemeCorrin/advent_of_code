package html.advent2017;

class Day15 extends DayBase {
  private long startValueA = 883;
  private long startValueB = 879;
  private long factorA = 16807;
  private long factorB = 48271;
  private long divider = 2147483647;


  void solution() {
    System.out.println(part1());
    System.out.println(part2());
  }


  private long part1() {
    long count = 0;
    long valueA = startValueA;
    long valueB = startValueB;

    for (long i = 0; i < 40000000; i++) {
      valueA = magicGenerator(valueA, factorA, divider);
      valueB = magicGenerator(valueB, factorB, divider);
      if (compareLast16Bits(valueA, valueB)) {
        count++;
      }
//      if (i % 1000000 == 0) {
//        System.out.println(count);
//      }
    }
    return count;
  }


  private long part2() {
    int count = 0;
    long[][] judgeCard = new long[5000000][2];
    long valueA = startValueA;
    long valueB = startValueB;

    for (int i = 0; i < 5000000;) {
      valueA = magicGenerator(valueA, factorA, divider);
      if (valueA % 4 == 0) {
        judgeCard[i][0] = valueA;
        i++;
      }
    }
    for (int j = 0; j < 5000000;) {
      valueB = magicGenerator(valueB, factorB, divider);
      if (valueB % 8 == 0) {
        judgeCard[j][1] = valueB;
        j++;
      }
    }
    for (int k = 0; k < 5000000; k++) {
      if (compareLast16Bits(judgeCard[k][0], judgeCard[k][1])) {
        count++;
      }
    }
    return count;
  }


  private long magicGenerator(long inputValue, long factor, long divisor) {
    return ((inputValue * factor) % divisor);
  }


  private boolean compareLast16Bits(long valueA, long valueB) {
    String stringA = String.format("%32s", Long.toBinaryString(valueA)).replace(' ', '0');
    String stringB = String.format("%32s", Long.toBinaryString(valueB)).replace(' ', '0');

    return (stringA.substring(16).equals(stringB.substring(16)));
  }
}
