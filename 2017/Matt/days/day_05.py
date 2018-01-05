
class Day05:
    def __init__(self):
        self.input = 'data/Day 5.txt'
        self.numbers = []

    def part_1(self):
        with open(self.input) as f:
            for line in f:
                strip_int = int(line.rstrip())
                self.numbers.append(strip_int)
        length = len(self.numbers)
        count = 0
        distance = 0
        while distance < length:
            count += 1
            hop = self.numbers[distance]
            self.numbers[distance] += 1
            distance += hop
        print(count)

    def part_2(self):
        with open(self.input) as f:
            for line in f:
                strip_int = int(line.rstrip())
                self.numbers.append(strip_int)
        length = len(self.numbers)
        count = 0
        distance = 0
        while distance < length:
            count += 1
            hop = self.numbers[distance]
            if self.numbers[distance] >= 3:
                self.numbers[distance] += -1
            elif self.numbers[distance] < 3:
                self.numbers[distance] += 1
            distance += hop
        print(count)

