
class Day04:
    def __init__(self):
        self.pass_file = 'data/Day 4.txt'
        self.count_passphrase = 0

    def part_1(self):
        with open(self.pass_file) as f:
            for line in f:
                phrase = line.split()
                if len(phrase) == len(set(phrase)):
                    self.count_passphrase += 1

        print(self.count_passphrase)

    def part_2(self):
        with open(self.pass_file) as f:
            for line in f:
                phrase = line.split()
                phrase = [''.join(sorted(word, reverse=True)) for word in phrase]

                if len(phrase) == len(set(phrase)):
                    self.count_passphrase += 1

        print(self.count_passphrase)
