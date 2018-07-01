import unittest
from advent.day.day_14 import Day14


class TestDay14(unittest.TestCase):
    example = 'flqrgnkx'
    input = 'ffayrhll'

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day14.part_1(self.example), 8108)

    def test_part_1_solution(self):
        self.assertEqual(Day14.part_1(self.input), 8190)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day14.part_2(self.example), 1242)

    def test_part_2_solution(self):
        self.assertEqual(Day14.part_2(self.input), 1134)


if __name__ == '__main__':
    unittest.main()
