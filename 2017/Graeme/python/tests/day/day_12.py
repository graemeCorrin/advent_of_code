import pathlib
import unittest
from advent.day.day_12 import Day12


class TestDay12(unittest.TestCase):
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_12.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list.append(line.rstrip())

    example = ['0 <-> 2',
               '1 <-> 1',
               '2 <-> 0, 3, 4',
               '3 <-> 2, 4',
               '4 <-> 2, 3, 6',
               '5 <-> 6',
               '6 <-> 4, 5']

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day12.part_1(self.example), 6)

    def test_part_1_solution(self):
        self.assertEqual(Day12.part_1(self.input_list), 145)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day12.part_2(self.example), 2)

    def test_part_2_solution(self):
        self.assertEqual(Day12.part_2(self.input_list), 207)


if __name__ == '__main__':
    unittest.main()
