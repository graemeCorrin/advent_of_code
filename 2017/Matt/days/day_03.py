import math as m


class Day03:
    memory_location = 368078
    # memory_location = 48

    def __init__(self):
        self.steps_to_centre = None

    def part_1(self):
        if self.memory_location == 1:
            print(0)
            return
        self.steps_to_centre = 0
        distances_in_level = []
        trun_root_mem = m.trunc(m.sqrt(self.memory_location))
        level = m.trunc(m.ceil(trun_root_mem / 2))
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

        self.steps_to_centre = distances_in_level[m.trunc((self.memory_location - start_of_level) % (level * 2))]
        print(distances_in_level)
        print('level ' + str(level))
        print('steps ' + str(self.steps_to_centre))

    def part_2(self):
        pass
