import copy
from operator import itemgetter
from objects.day_07.program_t import Program


class Day07:
    def __init__(self):
        self.program_tower = 'data/Day 7.txt'

    def part_1(self):
        programs = []
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
        bottom = copy.copy(program_dict)

        for item in program_dict:
            for held in program_dict[item].holding:
                program_dict[held].held_by = item
                del bottom[held]

        print(bottom)

    # def part_2(self):
    #     programs = []
    #     with open(self.program_tower) as f:
    #         for line in f:
    #             split_line = line.rstrip().split(' -> ')
    #             name_weight = split_line[0].split()
    #             try:
    #                 holding = split_line[1].split(', ')
    #             except IndexError:
    #                 holding = []
    #             program = Program(name_weight[0], int(name_weight[1].strip('()')), holding)
    #             programs.append(program)
    #     program_dict = {x.name: programs.index(x) for x in programs}
    #     bottom = copy.copy(program_dict)
    #
    #     for item in program_dict:
    #         for held in programs[program_dict[item]].holding:
    #             programs[program_dict[held]].held_by = item
    #             del bottom[held]
    #     for item in bottom:
    #         bottom = programs[program_dict[item]]
    #
    #     def builder(prog, super_tree):
    #         for each in prog.holding:
    #             programs[program_dict[each]].level = prog.level + 1
    #             super_tree.append((each, programs[program_dict[each]].level))
    #             sub_tree = []
    #             builder(programs[program_dict[each]], sub_tree)
    #             if sub_tree:
    #                 for y in sub_tree:
    #                     super_tree.append(y)
    #             else:
    #                 super_tree.append(['End'])
    #
    #     tree = [(bottom.name, 0), ]
    #     builder(bottom, tree)
    #     # print(tree)
    #     branch_end = False
    #     for item in tree:
    #         if item[0] == 'End':
    #             branch_end = True
    #         else:
    #             if branch_end:
    #                 print('\n', end='')
    #                 print(' ' * 10 * item[1], end='')
    #                 branch_end = False
    #             print(item[0].ljust(10), end='')

    def part_2(self):
        incorrect_weight = []
        programs = []
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
        bottom = copy.copy(program_dict)

        for item in program_dict:
            for held in program_dict[item].holding:
                program_dict[held].held_by = item
                del bottom[held]

        for item in bottom:
            bottom = program_dict[item]

        def builder(prog, super_tree):
            for each in prog.holding:
                program_dict[each].level = prog.level + 1
                super_tree.append((each, program_dict[each].level, program_dict[each].weight))
                sub_tree = []
                builder(program_dict[each], sub_tree)
                if sub_tree:
                    for y in sub_tree:
                        super_tree.append(y)

        tree = [(bottom.name, 0)]
        builder(bottom, tree)

        weight_path = copy.copy(sorted(tree, key=itemgetter(1), reverse=True))
        for item in weight_path:
            compare_weight = []
            for z in program_dict[item[0]].holding:
                compare_weight.insert(0, program_dict[z].weight_above)
            for i in compare_weight:
                if compare_weight.count(i) == 1:
                    for e in compare_weight:
                        incorrect_weight.append((program_dict[item[0]].holding[compare_weight.index(e)],
                                                 program_dict[item[0]].weight, program_dict[item[0]].weight_above))
                    print(incorrect_weight)
            program_dict[item[0]].weight_above += program_dict[item[0]].weight
