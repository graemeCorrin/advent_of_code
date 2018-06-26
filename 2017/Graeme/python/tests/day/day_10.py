import pathlib
import unittest
from advent.day.day_10 import Day10


class TestDay6(unittest.TestCase):
    input_lengths = [76, 1, 88, 148, 166, 217, 130, 0, 128, 254, 16, 2, 130, 71, 255, 229]
    input_string = '76,1,88,148,166,217,130,0,128,254,16,2,130,71,255,229'

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day10.get_hash([3, 4, 1, 5], 5), 12)

    def test_part_1_solution(self):
        self.assertEqual(Day10.get_hash(self.input_lengths, 256), 29240)

    # Part 2

    def test_part_2_example_1(self):
        self.assertEqual(Day10.get_hash_2('', 256), 'a2582a3a0e66e6e86e3812dcb672a272')

    def test_part_2_example_2(self):
        self.assertEqual(Day10.get_hash_2('AoC 2017', 256), '33efeb34ea91902bb2f59c9920caa6cd')

    def test_part_2_example_3(self):
        self.assertEqual(Day10.get_hash_2('1,2,3', 256), '3efbe78a8d82f29979031a4aa0b16a9d')

    def test_part_2_example_4(self):
        self.assertEqual(Day10.get_hash_2('1,2,4', 256), '63960835bcdc130f0b66d7ff4f6a5a8e')

    def test_part_2_solution(self):
        self.assertEqual(Day10.get_hash_2(self.input_string, 256), '4db3799145278dc9f73dcdbc680bd53d')


if __name__ == '__main__':
    unittest.main()
