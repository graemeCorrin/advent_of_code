import pathlib
import unittest
from advent.day.day_18 import Day18


class TestDay18(unittest.TestCase):

    input_list = []
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_18.txt'
    with open(in_file) as file:
        for line in file:
            input_list.append(list(map(Day18.to_int, line.split())))

    example = [['set', 'a', 1],
               ['add', 'a', 2],
               ['mul', 'a', 'a'],
               ['mod', 'a', 5],
               ['snd', 'a'],
               ['set', 'a', 0],
               ['rcv', 'a'],
               ['jgz', 'a', -1],
               ['set', 'a', 1],
               ['jgz', 'a', -2]]

    example_2 = [['snd', 1],
                 ['snd', 2],
                 ['snd', 'p'],
                 ['rcv', 'a'],
                 ['rcv', 'b'],
                 ['rcv', 'c'],
                 ['rcv' 'd']]

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day18.part_1(self.example), 4)

    def test_part_1_solution(self):
        self.assertEqual(Day18.part_1(self.input_list), 3423)

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day18.part_2(self.example_2), 3)

    def test_part_2_solution(self):
        self.assertEqual(Day18.part_2(self.input_list), 7493)


if __name__ == '__main__':
    unittest.main()
