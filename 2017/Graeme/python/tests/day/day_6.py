import unittest
from advent.day.day_6 import Day6


class TestDay6(unittest.TestCase):
    example_array = [0, 2, 7, 0]
    array = [10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6]

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day6.steps_to_infinite_loop(self.example_array), 5)

    def test_part_1_solution(self):
        self.assertEqual(Day6.steps_to_infinite_loop(self.array), 14029)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day6.steps_to_infinite_loop(self.example_array), 4)

    def test_part_2_solution(self):
        self.assertEqual(Day6.steps_to_infinite_loop(self.array), 2765)


if __name__ == '__main__':
    unittest.main()
