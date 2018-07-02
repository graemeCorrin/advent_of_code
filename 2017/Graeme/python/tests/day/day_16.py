import pathlib
import unittest
from advent.day.day_16 import Day16


class TestDay16(unittest.TestCase):

    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_16.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list = line.split(',')
            break

    example = ['s1', 'x3/4', 'pe/b']

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day16.part_1(self.example, 'abcde'), 'baedc')

    def test_part_1_solution(self):
        self.assertEqual(Day16.part_1(self.input_list, 'abcdefghijklmnop'), 'cgpfhdnambekjiol')

    # Part 2

    def test_part_2_solution(self):
        self.assertEqual(Day16.part_2(self.input_list, 'abcdefghijklmnop'), 'gjmiofcnaehpdlbk')


if __name__ == '__main__':
    unittest.main()
