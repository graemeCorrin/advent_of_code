package html.advent2017;

class Day03 extends DayBase {
  int puzzleInput = 277678;

  enum cardinalDirection {
    UP, LEFT, DOWN, RIGHT;
  }


  void solution() {
    System.out.println(manhattanSteps());   // Part 1
    System.out.println(sumSpiral());        // Part 2
  }


  private int manhattanSteps() {
    if (puzzleInput == 1) {
      return 0;
    }
    int steps = 0;
    int level = (int) Math.round(Math.floor(Math.sqrt(puzzleInput - 1)));
    level += (level % 2) - 1;

    int[] corners = new int[4];
    for (int i = 0; i < 4; i++) {
      corners[i] = (int) Math.round(Math.pow(level, 2) + ((i + 1) * (level + 1)));
    }

    int distToCorner = Integer.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      distToCorner = Math.min(Math.abs(corners[i] - puzzleInput), distToCorner);
    }
    steps = level + 1 - distToCorner;

    return steps;
  }


  private int sumSpiral() {
    int gridSize = 3;
    int level = 1;
    int[][] grid = new int[3][3];
    grid[1][1] = 1;
    int entryCount = 1;
    int currentEntry = 1;
    int[] currentCell = {1, 1};
    cardinalDirection currentDirection = cardinalDirection.RIGHT;
    int directionCount = 0;

    while (currentEntry <= puzzleInput) {
      switch (currentDirection) {
        case RIGHT:
          currentCell[1] += 1;
          directionCount++;
          if (directionCount >= level) {
            currentDirection = cardinalDirection.UP;
            directionCount = 0;
          }
          break;
        case UP:
          currentCell[0] -= 1;
          directionCount++;
          if (directionCount >= level - 2) {
            currentDirection = cardinalDirection.LEFT;
            directionCount = 0;
          }
          break;
        case LEFT:
          currentCell[1] -= 1;
          directionCount++;
          if (directionCount >= level - 1) {
            currentDirection = cardinalDirection.DOWN;
            directionCount = 0;
          }
          break;
        case DOWN:
          currentCell[0] += 1;
          directionCount++;
          if (directionCount >= level - 1) {
            currentDirection = cardinalDirection.RIGHT;
            directionCount = 0;
          }
          break;
      }
      entryCount++;
      if (entryCount > (level * level)) {
        int oldSize = gridSize;
        int newSize = gridSize + 2;

        int[][] tempGrid = new int[newSize][newSize];


        for (int i = 1; i < oldSize - 1; i++) {
          System.arraycopy(grid[i], 1, tempGrid[i + 1], 2, oldSize - 2);
        }
        grid = tempGrid;
        gridSize = newSize;
        currentCell[0] += 1;
        currentCell[1] += 1;
        level += 2;
      }

      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0] - 1][currentCell[1] - 1]; // UL
      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0] - 1][currentCell[1]];     // U
      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0] - 1][currentCell[1] + 1]; // UR
      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0]][currentCell[1] + 1];     // R
      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0] + 1][currentCell[1] + 1]; // DR
      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0] + 1][currentCell[1]];     // D
      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0] + 1][currentCell[1] - 1]; // DL
      grid[currentCell[0]][currentCell[1]] += grid[currentCell[0]][currentCell[1] - 1];     // L

      currentEntry = grid[currentCell[0]][currentCell[1]];
    }

    return currentEntry;
  }
}
