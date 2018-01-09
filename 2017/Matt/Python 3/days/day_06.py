import copy


class Day06:
    def __init__(self):
        self.banks = [14, 0, 15, 12, 11, 11, 3, 5, 1, 6, 8, 4, 9, 1, 8, 4]
        self.cycles = 0
        self.length = len(self.banks)
        self.seen_config = [copy.copy(self.banks)]
        self.first_repeat = None

    def part_1(self):
        repeat = False
        while not repeat:
            self.cycles += 1
            most_blocks = sorted(self.banks, reverse=True)[0]
            largest_bank = self.banks.index(most_blocks)
            self.banks[largest_bank] = 0
            while most_blocks > 0:
                largest_bank += 1
                if largest_bank == self.length:
                    largest_bank = 0
                self.banks[largest_bank] += 1
                most_blocks += -1
            if self.banks in self.seen_config:
                self.first_repeat = (copy.copy(self.banks))
                repeat = True
            self.seen_config.append(copy.copy(self.banks))
        print(self.cycles)

    def part_2(self):
        self.part_1()
        self.cycles = 0
        repeat = False
        while not repeat:
            self.cycles += 1
            most_blocks = sorted(self.banks, reverse=True)[0]
            largest_bank = self.banks.index(most_blocks)
            self.banks[largest_bank] = 0
            while most_blocks > 0:
                largest_bank += 1
                if largest_bank == self.length:
                    largest_bank = 0
                self.banks[largest_bank] += 1
                most_blocks += -1
            if self.banks == self.first_repeat:
                repeat = True
        print(self.cycles)
