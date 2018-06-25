import pathlib
import unittest
from advent.day.day_9 import Day9


class TestDay6(unittest.TestCase):
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_9.txt'
    input_string = ''
    with open(in_file) as f:
        for line in f:
            input_string = line

    # Part 1

    def test_part_1_example_1(self):
        self.assertEqual(Day9.get_weight('{}'), 1)

    def test_part_1_example_2(self):
        self.assertEqual(Day9.get_weight('{{{}}}'), 6)

    def test_part_1_example_3(self):
        self.assertEqual(Day9.get_weight('{{},{}}'), 5)

    def test_part_1_example_4(self):
        self.assertEqual(Day9.get_weight('{{{},{},{{}}}}'), 16)

    def test_part_1_example_5(self):
        self.assertEqual(Day9.get_weight('{<a>,<a>,<a>,<a>}'), 1)

    def test_part_1_example_6(self):
        self.assertEqual(Day9.get_weight('{{<ab>},{<ab>},{<ab>},{<ab>}}'), 9)

    def test_part_1_example_7(self):
        self.assertEqual(Day9.get_weight('{{<!!>},{<!!>},{<!!>},{<!!>}}'), 9)

    def test_part_1_example_8(self):
        self.assertEqual(Day9.get_weight('{{<a!>},{<a!>},{<a!>},{<ab>}}'), 3)

    def test_part_1_solution(self):
        self.assertEqual(Day9.get_weight(self.input_string), 16869)

    # Part 2

    def test_part_2_example_1(self):
        self.assertEqual(Day9.count_garbage('<>'), 0)

    def test_part_2_example_2(self):
        self.assertEqual(Day9.count_garbage('<random characters>'), 17)

    def test_part_2_example_3(self):
        self.assertEqual(Day9.count_garbage('<<<<>'), 3)

    def test_part_2_example_4(self):
        self.assertEqual(Day9.count_garbage('<{!>}>'), 2)

    def test_part_2_example_5(self):
        self.assertEqual(Day9.count_garbage('<!!>'), 0)

    def test_part_2_example_6(self):
        self.assertEqual(Day9.count_garbage('<!!!>>'), 0)

    def test_part_2_example_7(self):
        self.assertEqual(Day9.count_garbage('<{o"i!a,<{i<a>'), 10)

    def test_part_2_solution(self):
        self.assertEqual(Day9.count_garbage(self.input_string), 2765)


if __name__ == '__main__':
    unittest.main()
