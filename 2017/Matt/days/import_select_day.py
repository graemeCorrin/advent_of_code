from days.day_01 import Day01
from days.day_02 import Day02
from days.day_03 import Day03
from days.day_04 import Day04
from days.day_05 import Day05
from days.day_06 import Day06
from days.day_07 import Day07
from days.day_08 import Day08
from days.day_09 import Day09
from days.day_10 import Day10
from days.day_11 import Day11
from days.day_12 import Day12
from days.day_13 import Day13
from days.day_14 import Day14
from days.day_15 import Day15
from days.day_16 import Day16
from days.day_17 import Day17
from days.day_18 import Day18
from days.day_19 import Day19
from days.day_20 import Day20
from days.day_21 import Day21
from days.day_22 import Day22
from days.day_23 import Day23
from days.day_24 import Day24
from days.day_25 import Day25


class Select:
    def __init__(self, day):
        self.day = day
        self.solution = None

    def puzzle(self):
        if self.day == 1:
            self.solution = Day01()
        elif self.day == 2:
            self.solution = Day02()
        elif self.day == 3:
            self.solution = Day03()
        elif self.day == 4:
            self.solution = Day04()
        elif self.day == 5:
            self.solution = Day05()
        elif self.day == 6:
            self.solution = Day06()
        elif self.day == 7:
            self.solution = Day07()
        elif self.day == 8:
            self.solution = Day08()
        elif self.day == 9:
            self.solution = Day09()
        elif self.day == 10:
            self.solution = Day10()
        elif self.day == 11:
            self.solution = Day11()
        elif self.day == 12:
            self.solution = Day12()
        elif self.day == 13:
            self.solution = Day13()
        elif self.day == 14:
            self.solution = Day14()
        elif self.day == 15:
            self.solution = Day15()
        elif self.day == 16:
            self.solution = Day16()
        elif self.day == 17:
            self.solution = Day17()
        elif self.day == 18:
            self.solution = Day18()
        elif self.day == 19:
            self.solution = Day19()
        elif self.day == 20:
            self.solution = Day20()
        elif self.day == 21:
            self.solution = Day21()
        elif self.day == 22:
            self.solution = Day22()
        elif self.day == 23:
            self.solution = Day23()
        elif self.day == 24:
            self.solution = Day24()
        elif self.day == 25:
            self.solution = Day25()
        return self.solution
