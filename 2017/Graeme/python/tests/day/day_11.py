import pathlib
import unittest
from advent.day.day_11 import Day11


class TestDay11(unittest.TestCase):
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_11.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list = line.split(',')

    # Part 1

    def test_part_1_example_1(self):
        self.assertEqual(Day11.dist_from_center(['ne', 'ne', 'ne']), 3)

    def test_part_1_example_2(self):
        self.assertEqual(Day11.dist_from_center(['ne', 'ne', 'sw', 'sw']), 0)

    def test_part_1_example_3(self):
        self.assertEqual(Day11.dist_from_center(['ne', 'ne', 's', 's']), 2)

    def test_part_1_example_4(self):
        self.assertEqual(Day11.dist_from_center(['se', 'sw', 'se', 'sw', 'sw']), 3)

    def test_part_1_solution(self):
        self.assertEqual(Day11.dist_from_center(self.input_list), 794)

    # Part 2

    def test_part_2_solution(self):
        self.assertEqual(Day11.furthest_dist_from_center(self.input_list), 1524)


if __name__ == '__main__':
    unittest.main()
