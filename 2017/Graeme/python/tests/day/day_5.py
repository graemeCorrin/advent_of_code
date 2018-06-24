import pathlib
import unittest
from advent.day.day_5 import Day5


class TestDay5(unittest.TestCase):
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_5.txt'

    maze_1 = []
    with open(in_file) as f:
        for line in f:
            # Get list of ints from file, strip newline characters
            maze_1.append(int(line.rstrip()))
    maze_2 = maze_1[:]

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day5.steps_to_escape([0, 3, 0, 1, -3]), 5)

    def test_part_1_solution(self):
        self.assertEqual(Day5.steps_to_escape(self.maze_1), 364539)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day5.steps_to_escape([0, 3, 0, 1, -3], 2), 10)

    def test_part_2_solution(self):
        self.assertEqual(Day5.steps_to_escape(self.maze_2, 2), 27477714)


if __name__ == '__main__':
    unittest.main()
