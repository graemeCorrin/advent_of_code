import pathlib
import unittest
from advent.day.day_4 import Day4


class TestDay4(unittest.TestCase):
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_4.txt'

    # Part 1

    def test_part_1_example_1(self):
        self.assertEqual(Day4.check_pass_phrase('aa bb cc dd ee'), True)

    def test_part_1_example_2(self):
        self.assertEqual(Day4.check_pass_phrase('aa bb cc dd aa'), False)

    def test_part_1_example_3(self):
        self.assertEqual(Day4.check_pass_phrase('aa bb cc dd aaa'), True)

    def test_part_1_solution(self):
        self.assertEqual(Day4.check_pass_phrases_from_file(self.in_file), 466)

    # Part 2

    def test_part_2_example_1(self):
        self.assertEqual(Day4.check_pass_phrase('abcde fghij', False), True)

    def test_part_2_example_2(self):
        self.assertEqual(Day4.check_pass_phrase('abcde xyz ecdab', False), False)

    def test_part_2_example_3(self):
        self.assertEqual(Day4.check_pass_phrase('a ab abc abd abf abj', False), True)

    def test_part_2_example_4(self):
        self.assertEqual(Day4.check_pass_phrase('iiii oiii ooii oooi oooo', False), True)

    def test_part_2_example_5(self):
        self.assertEqual(Day4.check_pass_phrase('oiii ioii iioi iiio', False), False)

    def test_part_2_solution(self):
        self.assertEqual(Day4.check_pass_phrases_from_file(self.in_file, False), 251)


if __name__ == '__main__':
    unittest.main()
