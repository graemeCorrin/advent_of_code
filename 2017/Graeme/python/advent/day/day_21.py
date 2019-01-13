import numpy


class Day21:

    @staticmethod
    def part_1(lines: list, start: str, itr: int) -> int:

        def string_to_array(string):
            return numpy.array([list(l) for l in string.split('/')])

        def array_to_string(array):
            return '/'.join([''.join(x) for x in array])

        rules = {}

        for line in lines:
            before, after = line.split(' => ')

            before_np = string_to_array(before)
            rules[before] = after
            rules[array_to_string(numpy.rot90(before_np, k=1))] = after
            rules[array_to_string(numpy.rot90(before_np, k=2))] = after
            rules[array_to_string(numpy.rot90(before_np, k=3))] = after

            before_np_flip = numpy.flip(before_np, 0)
            rules[array_to_string(before_np_flip)] = after
            rules[array_to_string(numpy.rot90(before_np_flip, k=1))] = after
            rules[array_to_string(numpy.rot90(before_np_flip, k=2))] = after
            rules[array_to_string(numpy.rot90(before_np_flip, k=3))] = after

        grid = string_to_array(start)

        for i in range(itr):

            if len(grid) % 3 == 0:
                block_size = 3
            else:
                block_size = 2






        return 1

    @staticmethod
    def part_2(lines: list) -> int:

        return 1
