import pathlib
import unittest
from advent.day.day_19 import Day19


class TestDay19(unittest.TestCase):

    example_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_19_test.txt'
    input_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_19.txt'

    # Part 1 & 2

    def test_part_1_2_example(self):
        self.assertEqual(Day19.walk_path(self.example_file), ('ABCDEF', 38))

    def test_part_1_2_solution(self):
        self.assertEqual(Day19.walk_path(self.input_file), ('DWNBGECOMY', 17228))


if __name__ == '__main__':
    unittest.main()
