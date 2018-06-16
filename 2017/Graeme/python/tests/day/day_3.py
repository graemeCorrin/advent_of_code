import unittest
from advent.day.day_3 import Day3


class TestDay3(unittest.TestCase):
    input_value = 361527

    def test_solution_1(self):
        self.assertEqual(Day3.steps_to_center(self.input_value), 326)

    def test_solution_2(self):
        self.assertEqual(Day3.first_larger_value(self.input_value), 363010)


if __name__ == '__main__':
    unittest.main()
