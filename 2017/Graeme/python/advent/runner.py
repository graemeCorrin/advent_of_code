import argparse
import pathlib

from advent.day.day_1 import Day1
from advent.day.day_2 import Day2
from advent.day.day_3 import Day3
from advent.day.day_4 import Day4
from advent.day.day_5 import Day5
from advent.day.day_6 import Day6
from advent.day.day_7 import Day7
from advent.day.day_8 import Day8
from advent.day.day_9 import Day9
from advent.day.day_10 import Day10
from advent.day.day_11 import Day11
from advent.day.day_12 import Day12
from advent.day.day_13 import Day13
from advent.day.day_14 import Day14
from advent.day.day_15 import Day15
from advent.day.day_16 import Day16
from advent.day.day_17 import Day17
from advent.day.day_18 import Day18
from advent.day.day_19 import Day19
from advent.day.day_20 import Day20
from advent.day.day_21 import Day21


def __run():
    days = __get_input_parameters()
    run_days(days)


def __get_input_parameters():
    parser = argparse.ArgumentParser(description='')
    parser.add_argument('-d', '--days', type=int, nargs='+', help='days to run')

    args = parser.parse_args()

    return args.days


def run_days(days=None):
    all_days = not days

    if all_days or 1 in days:
        __run_day1()

    if all_days or 2 in days:
        __run_day2()

    if all_days or 3 in days:
        __run_day3()

    if all_days or 4 in days:
        __run_day4()

    if all_days or 5 in days:
        __run_day5()

    if all_days or 6 in days:
        __run_day6()

    if all_days or 7 in days:
        __run_day7()

    if all_days or 8 in days:
        __run_day8()

    if all_days or 9 in days:
        __run_day9()

    if all_days or 10 in days:
        __run_day10()

    if all_days or 11 in days:
        __run_day11()

    if all_days or 12 in days:
        __run_day12()

    if all_days or 13 in days:
        __run_day13()

    if all_days or 14 in days:
        __run_day14()

    if all_days or 15 in days:
        __run_day15()

    if all_days or 16 in days:
        __run_day16()

    if all_days or 17 in days:
        __run_day17()

    if all_days or 18 in days:
        __run_day18()

    if all_days or 19 in days:
        __run_day19()

    if all_days or 20 in days:
        __run_day20()

    if all_days or 21 in days:
        __run_day21()


def __run_day1():
    string = '522883333635584854991545936673798259831295958381745562154597678479248946819836599823272273487661233235' \
             '237619281355294981427594757577433952981197664436151779558699831924224161481362273425579756957157769923' \
             '859266728742816639822157288586941641968268775974397843457182126714651433839462452564833873992947991236' \
             '817266988557731971838927816876684448794876169743872255685788243322439372313129887625262664351723688399' \
             '911566565693552167577286651618589931713249471672361549347639711562768788766519478174637734146899595455' \
             '451825291685922739769388525432962881235561248759444552239585355173456749883838224861613796963797136961' \
             '544359997358832638879289396992485531643795231349255167154571426278473834351716654419719454717351515592' \
             '724417544729647428215411495118164831787582752581445375884619454887278994337228195299522277917381244418' \
             '649111542647618867225324974447894686331791513683219913286891789124359119571935472112911622916468825685' \
             '362833923391967146878191316741562421415279386458533294446842884917187687343362152424228948813567531354' \
             '449824549863742413915378292572374524972874388549387779264857667319688994956831723412586336918795378861' \
             '184138835399987551917289632952434652726523176786883969669332827338177272678294916611293295435692375748' \
             '513936729869992298492597772497294427799168682321929593973431387483486179617959165917472643235753311389' \
             '621278156665915493941986679748834744855171948163257223163246357559159969638822334421922832513423323853' \
             '885428943775633184888724242338754221469115722672517968363896741567869762513817763344476512622388547834' \
             '895133263439829161213485285868394246617832992265582222542653435919169617763316796283984798582667695541' \
             '742661712628825536612316917467434841793215829133464676763776432322684277152359856242939993578978821595' \
             '836736246765244485412395197211835841762967945497868733713767549529576845171963199939861782828767193758' \
             '499869795942584588314573632381822512931184599721498766343337568962174666562918725251164396931528331626' \
             '9222835744532431378945137649959158495714472963839397214332815241141327714672141875129895'

    print("Day 1")

    # Part 1
    print(f"  Part One: {Day1.part_1(string)}")

    # Part 2
    print(f"  Part Two: {Day1.part_2(string)}")


def __run_day2():
    table = [[1208, 412, 743, 57, 1097, 53, 71, 1029, 719, 133, 258, 69, 1104, 373, 367, 365],
             [4011, 4316, 1755, 4992, 228, 240, 3333, 208, 247, 3319, 4555, 717, 1483, 4608, 1387, 3542],
             [675, 134, 106, 115, 204, 437, 1035, 1142, 195, 1115, 569, 140, 1133, 190, 701, 1016],
             [4455, 2184, 5109, 221, 3794, 246, 5214, 4572, 3571, 3395, 2054, 5050, 216, 878, 237, 3880],
             [4185, 5959, 292, 2293, 118, 5603, 2167, 5436, 3079, 167, 243, 256, 5382, 207, 5258, 4234],
             [94, 402, 126, 1293, 801, 1604, 1481, 1292, 1428, 1051, 345, 1510, 1417, 684, 133, 119],
             [120, 1921, 115, 3188, 82, 334, 366, 3467, 103, 863, 3060, 2123, 3429, 1974, 557, 3090],
             [53, 446, 994, 71, 872, 898, 89, 982, 957, 789, 1040, 100, 133, 82, 84, 791],
             [2297, 733, 575, 2896, 1470, 169, 2925, 1901, 195, 2757, 1627, 1216, 148, 3037, 392, 221],
             [1343, 483, 67, 1655, 57, 71, 1562, 447, 58, 1561, 889, 1741, 1338, 88, 1363, 560],
             [2387, 3991, 3394, 6300, 2281, 6976, 234, 204, 6244, 854, 1564, 210, 195, 7007, 3773, 3623],
             [1523, 77, 1236, 1277, 112, 171, 70, 1198, 86, 1664, 1767, 75, 315, 143, 1450, 1610],
             [168, 2683, 1480, 200, 1666, 1999, 3418, 2177, 156, 430, 2959, 3264, 2989, 136, 110, 3526],
             [8702, 6973, 203, 4401, 8135, 7752, 1704, 8890, 182, 9315, 255, 229, 6539, 647, 6431, 6178],
             [2290, 157, 2759, 3771, 4112, 2063, 153, 3538, 3740, 130, 3474, 1013, 180, 2164, 170, 189],
             [525, 1263, 146, 954, 188, 232, 1019, 918, 268, 172, 1196, 1091, 1128, 234, 650, 420]]

    print("Day 2")

    # Part 1
    print(f"  Part One: {Day2.checksum_difference(table)}")

    # Part 2
    print(f"  Part Two: {Day2.checksum_quotient(table)}")


def __run_day3():
    input_value = 361527

    print("Day 3")

    # Part 1
    print(f"  Part One: {Day3.steps_to_center(input_value)}")

    # Part 2
    print(f"  Part Two: {Day3.first_larger_value(input_value)}")


def __run_day4():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_4.txt'

    print("Day 4")

    # Part 1
    print(f"  Part One: {Day4.check_pass_phrases_from_file(in_file)}")

    # Part 2
    print(f"  Part Two: {Day4.check_pass_phrases_from_file(in_file, False)}")


def __run_day5():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_5.txt'

    maze_1 = []
    with open(in_file) as f:
        for line in f:
            # Get list of ints from file, strip newline characters
            maze_1.append(int(line.rstrip()))
    maze_2 = maze_1[:]

    print("Day 5")

    # Part 1
    print(f"  Part One: {Day5.steps_to_escape(maze_1)}")

    # Part 2
    print(f"  Part Two: {Day5.steps_to_escape(maze_2, 2)}")


def __run_day6():
    array = [10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6]

    print("Day 6")

    # Part 1
    print(f"  Part One: {Day6.steps_to_infinite_loop(array)}")

    # Part 2
    # The first call of the function modified the original array
    # calling the same function again will give you the number of steps IN the infinite loop
    print(f"  Part Two: {Day6.steps_to_infinite_loop(array)}")


def __run_day7():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_7.txt'

    programs = []
    with open(in_file) as f:
        for line in f:
            # Get list of ints from file, strip newline characters
            programs.append(line.rstrip())

    print("Day 7")

    # Part 1
    print(f"  Part One: {Day7.find_root(programs)}")

    # Part 2
    print(f"  Part Two: {Day7.find_incorrect_weight(programs)}")


def __run_day8():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_8.txt'

    instructions = []
    with open(in_file) as f:
        for line in f:
            instructions.append(line.rstrip())

    print("Day 8")

    # Part 1
    print(f"  Part One: {Day8.part_1(instructions)}")

    # Part 2
    print(f"  Part Two: {Day8.part_2(instructions)}")


def __run_day9():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_9.txt'
    input_string = ''
    with open(in_file) as f:
        for line in f:
            input_string = line

    print("Day 9")

    # Part 1
    print(f"  Part One: {Day9.get_weight(input_string)}")

    # Part 2
    print(f"  Part Two: {Day9.count_garbage(input_string)}")


def __run_day10():
    input_lengths = [76, 1, 88, 148, 166, 217, 130, 0, 128, 254, 16, 2, 130, 71, 255, 229]
    input_string = '76,1,88,148,166,217,130,0,128,254,16,2,130,71,255,229'

    print("Day 10")

    # Part 1
    print(f"  Part One: {Day10.get_hash(input_lengths, 256)}")

    # Part 2
    print(f"  Part Two: {Day10.get_hash_2(input_string, 256)}")


def __run_day11():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_11.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list = line.split(',')

    print("Day 11")

    # Part 1
    print(f"  Part One: {Day11.dist_from_center(input_list)}")

    # Part 2
    print(f"  Part Two: {Day11.furthest_dist_from_center(input_list)}")


def __run_day12():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_12.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list.append(line.rstrip())

    print("Day 12")

    # Part 1
    print(f"  Part One: {Day12.part_1(input_list)}")

    # Part 2
    print(f"  Part Two: {Day12.part_2(input_list)}")


def __run_day13():
    in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_13.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list.append(line.rstrip())

    print("Day 13")

    # Part 1
    print(f"  Part One: {Day13.part_1(input_list)}")

    # Part 2
    print(f"  Part Two: {Day13.part_2(input_list)}")


def __run_day14():

    print("Day 14")

    # Part 1
    print(f"  Part One: {Day14.part_1('ffayrhll')}")

    # Part 2
    print(f"  Part Two: {Day14.part_2('ffayrhll')}")


def __run_day15():

    print("Day 15")

    # Part 1
    print(f"  Part One: {Day15.part_1(591, 393)}")

    # Part 2
    print(f"  Part Two: {Day15.part_2(591, 393)}")


def __run_day16():
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_16.txt'
    input_list = []
    with open(in_file) as f:
        for line in f:
            input_list = line.split(',')
            break

    print("Day 16")

    # Part 1
    print(f"  Part One: {Day16.part_1(input_list, 'abcdefghijklmnop')}")

    # Part 2
    print(f"  Part Two: {Day16.part_2(input_list, 'abcdefghijklmnop')}")


def __run_day17():

    print("Day 17")

    # Part 1
    print(f"  Part One: {Day17.part_1(335)}")

    # Part 2
    print(f"  Part Two: {Day17.part_2(335)}")


def __run_day18():

    input_list = []
    in_file = pathlib.Path.cwd().parent / 'data' / 'day_18.txt'
    with open(in_file) as file:
        for line in file:
            input_list.append(list(map(Day18.to_int, line.split())))

    print("Day 18")

    # Part 1
    print(f"  Part One: {Day18.part_1(input_list)}")

    # Part 2
    print(f"  Part Two: {Day18.part_2(input_list)}")


def __run_day19():

    in_file = pathlib.Path.cwd().parent / 'data' / 'day_19.txt'
    with open(in_file) as file:
        lines = file.read().splitlines()

    print("Day 19")
    one, two = Day19.walk_path(lines)

    # Part 1
    print(f"  Part One: {one}")

    # Part 2
    print(f"  Part Two: {two}")


def __run_day20():

    in_file = pathlib.Path.cwd().parent / 'data' / 'day_20.txt'
    with open(in_file) as file:
        lines = file.read().splitlines()

    print("Day 20")

    # Part 1
    print(f"  Part One: {Day20.part_1(lines)}")

    # Part 2
    print(f"  Part Two: {Day20.part_2(lines)}")


def __run_day21():

    in_file = pathlib.Path.cwd().parent / 'data' / 'day_21.txt'
    with open(in_file) as file:
        lines = file.read().splitlines()

    example = ['../.# => ##./#../...',
               '.#./..#/### => #..#/..../..../#..#']

    input_string = '.#./..#/###'

    print("Day 21")

    # Part 1
    print(f"  Part One: {Day21.part_1(example, input_string, 5)}")

    # Part 2
    print(f"  Part Two: {Day21.part_2(lines)}")


if __name__ == "__main__":
    __run()
