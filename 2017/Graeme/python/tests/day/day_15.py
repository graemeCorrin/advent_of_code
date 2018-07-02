import unittest
from advent.day.day_15 import Day15


class TestDay15(unittest.TestCase):

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day15.part_1(65, 8921), 588)

    def test_part_1_solution(self):
        self.assertEqual(Day15.part_1(591, 393), 619)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day15.part_2(65, 8921), 309)

    def test_part_2_solution(self):
        self.assertEqual(Day15.part_2(591, 393), 290)


if __name__ == '__main__':
    unittest.main()
