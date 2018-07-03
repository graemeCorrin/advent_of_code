import unittest
from advent.day.day_17 import Day17


class TestDay17(unittest.TestCase):

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day17.part_1(3), 638)

    def test_part_1_solution(self):
        self.assertEqual(Day17.part_1(335), 1282)

    # Part 2

    def test_part_2_solution(self):
        self.assertEqual(Day17.part_2(335), 27650600)


if __name__ == '__main__':
    unittest.main()
