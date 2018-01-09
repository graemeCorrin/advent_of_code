import math


class Day03:
    memory_location = 368078

    def __init__(self):
        self.steps_to_centre = None
        self.first_value_larger = None

    def part_1(self):
        if self.memory_location == 1:
            print(0)
            return

        self.steps_to_centre = 0
        distances_in_level = []

        trun_root_mem = math.trunc(math.sqrt(self.memory_location))
        level = math.trunc(math.ceil(trun_root_mem / 2))
        if trun_root_mem ** 2 == self.memory_location:
            if self.memory_location % 2 == 1:
                level -= 1
        start_of_level = (((2 * (level - 1)) + 1) ** 2) + 1

        for count in range(level * 2):
            option = None
            if count < level:
                option = (level * 2) - (count + 1)
            elif count >= level:
                option = count + 1
            distances_in_level.append(option)

        self.steps_to_centre = distances_in_level[math.trunc((self.memory_location - start_of_level) % (level * 2))]

        print(distances_in_level)
        print('level ' + str(level))
        print('steps ' + str(self.steps_to_centre))

    def part_2(self):
        table = [[], [[1], [1, 2], [4, 5], [10, 11, 23]], [[25, 26, 54], [57, 59, 122, 133], [142, 147, 304, 330],
                                                           [351, 362, 747, 806, 880]]]
        level = 3
        value = 880
        while not self.first_value_larger:
            table.append([])
            if level >= 3:
                for m in range(4):
                    if value > self.memory_location:
                        self.first_value_larger = value
                        break
                    table[level].append([])
                    if m == 0:
                        count = (level * 2) - 1
                    elif m == 1 or m == 2:
                        count = level * 2
                    elif m == 3:
                        count = (level * 2) + 1

                    for n in range(count):
                        # First square in leg/pre-corner
                        if n == 0:
                            value = value + table[level - 1][m][0] + table[level - 1][m][1]
                        # Corner square
                        elif n == 1:
                            value = value + table[level - 1][m][1]
                        # Post-corner square
                        elif n == 2:
                            value = value + table[level - 1][m][1] + table[level - 1][m][2] + table[level][m][0]
                        # Regular square
                        elif 2 < n < count - 2:
                            value = value + table[level - 1][m][n - 2] + table[level - 1][m][n - 1] \
                                    + table[level - 1][m][n]
                        elif m != 3:
                            # Second-last square in leg
                            if n == count - 2:
                                value = value + table[level - 1][m][count - 4] + table[level - 1][m][count - 3] \
                                        + table[level - 1][m + 1][0]
                            # Last square in leg
                            elif n == count - 1:
                                value = value + table[level - 1][m][count - 3] + table[level - 1][m + 1][0] \
                                        + table[level - 1][m + 1][1]
                        elif m == 3:
                            # Second-last square in level
                            if n == count - 2:
                                value = value + table[level - 1][m][count - 4] + table[level - 1][m][count - 3] \
                                        + table[level][0][0]
                            # Last square in level
                            elif n == count - 1:
                                value = value + table[level - 1][m][count - 3] + table[level][0][0] + table[level][0][1]
                        table[level][m].append(value)
                        if value > self.memory_location:
                            self.first_value_larger = value
                            break
            level += 1

        print(self.first_value_larger)
