import pathlib
import unittest
from advent.day.day_19 import Day19


class TestDay19(unittest.TestCase):

    example = ['     |',
               '     |  +--+',
               '     A  |  C',
               ' F---|----E|--+',
               '     |  |  |  D',
               '     +B-+  +--+']
    input_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_19.txt'
    with open(input_file) as file:
        lines = file.read().splitlines()

    # Part 1 & 2

    def test_part_1_2_example(self):
        self.assertEqual(Day19.walk_path(self.example), ('ABCDEF', 38))

    def test_part_1_2_solution(self):
        self.assertEqual(Day19.walk_path(self.lines), ('DWNBGECOMY', 17228))


if __name__ == '__main__':
    unittest.main()
