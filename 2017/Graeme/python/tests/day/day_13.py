import pathlib
import unittest
from advent.day.day_13 import Day13


class TestDay13(unittest.TestCase):
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_13.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list.append(line.rstrip())

    example = ['0: 3', '1: 2', '4: 4', '6: 4']

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day13.part_1(self.example), 24)

    def test_part_1_solution(self):
        self.assertEqual(Day13.part_1(self.input_list), 1704)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day13.part_2(self.example), 10)

    def test_part_2_solution(self):
        self.assertEqual(Day13.part_2(self.input_list), 3970918)


if __name__ == '__main__':
    unittest.main()
