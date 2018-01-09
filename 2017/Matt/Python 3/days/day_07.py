import copy
from operator import itemgetter
from objects.day_07.program_t import Program
import collections


class Day07:
    def __init__(self):
        self.program_tower = 'data/Day 7.txt'

    def part_1(self):
        pass

    def part_2(self):
        pass

    def tree_data(self):
        with open(self.program_tower) as f:
            for line in f:
                split_line = line.rstrip().split(' -> ')
                name_weight = split_line[0].split()
                try:
                    holding = split_line[1].split(', ')
                except IndexError:
                    holding = []
                program = Program(name_weight[0], int(name_weight[1].strip('()')), holding)
                programs.append(program)
        program_dict = {x.name: x for x in programs}
