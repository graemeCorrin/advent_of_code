import pathlib
import unittest
from advent.day.day_7 import Day7


class TestDay7(unittest.TestCase):

    example_programs = ['pbga (66)',
                        'xhth (57)',
                        'ebii (61)',
                        'havc (66)',
                        'ktlj (57)',
                        'fwft (72) -> ktlj, cntj, xhth',
                        'qoyq (66)',
                        'padx (45) -> pbga, havc, qoyq',
                        'tknk (41) -> ugml, padx, fwft',
                        'jptl (61)',
                        'ugml (68) -> gyxo, ebii, jptl',
                        'gyxo (61)',
                        'cntj (57)']

    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_7.txt'

    programs = []
    with open(in_file) as f:
        for line in f:
            # Get list of ints from file, strip newline characters
            programs.append(line.rstrip())

    # Part 1

    def test_part_1_example(self):
        self.assertEqual(Day7.find_root(self.example_programs), 'tknk')

    def test_part_1_solution(self):
        self.assertEqual(Day7.find_root(self.programs), 'vmpywg')

    # Part 2

    def test_part_2_example(self):
        self.assertEqual(Day7.find_incorrect_weight(self.example_programs), 60)

    def test_part_2_solution(self):
        self.assertEqual(Day7.find_incorrect_weight(self.programs), 1674)


if __name__ == '__main__':
    unittest.main()
