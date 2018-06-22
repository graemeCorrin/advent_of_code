import unittest
from advent.day.day_3 import Day3


class TestDay3(unittest.TestCase):
    input_value = 361527

    # Part 1

    def test_part_1_example_1(self):
        self.assertEqual(Day3.steps_to_center(1), 0)

    def test_part_1_example_2(self):
        self.assertEqual(Day3.steps_to_center(12), 3)

    def test_part_1_example_3(self):
        self.assertEqual(Day3.steps_to_center(23), 2)

    def test_part_1_example_4(self):
        self.assertEqual(Day3.steps_to_center(1024), 31)

    def test_part_1_solution(self):
        self.assertEqual(Day3.steps_to_center(self.input_value), 326)

    # Part 2

    def test_part_2_solution(self):
        self.assertEqual(Day3.first_larger_value(self.input_value), 363010)


if __name__ == '__main__':
    unittest.main()
