import pathlib
import unittest
from advent.day.day_20 import Day20


class TestDay20(unittest.TestCase):

    example_1 = ['p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>',
                 'p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>']

    example_2 = ['p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>',
                 'p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>',
                 'p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>',
                 'p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>']

    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_20.txt'
    with open(in_file) as file:
        lines = file.read().splitlines()

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day20.part_1(self.example_1), 0)

    def test_part_1_solution(self):
        self.assertEqual(Day20.part_1(self.lines), 170)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day20.part_2(self.example_2), 1)

    def test_part_2_solution(self):
        self.assertEqual(Day20.part_2(self.lines), 571)


if __name__ == '__main__':
    unittest.main()
