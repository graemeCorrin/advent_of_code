import pathlib
import unittest
from advent.day.day_8 import Day8


class TestDay8(unittest.TestCase):
    example_instructions = ['b inc 5 if a > 1',
                            'a inc 1 if b < 5',
                            'c dec -10 if a >= 1',
                            'c inc -20 if c == 10']

    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_8.txt'
    instructions = []
    with open(in_file) as f:
        for line in f:
            instructions.append(line.rstrip())

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day8.part_1(self.example_instructions), 1)

    def test_part_1_solution(self):
        self.assertEqual(Day8.part_1(self.instructions), 4066)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day8.part_2(self.example_instructions), 10)

    def test_part_2_solution(self):
        self.assertEqual(Day8.part_2(self.instructions), 4829)


if __name__ == '__main__':
    unittest.main()
