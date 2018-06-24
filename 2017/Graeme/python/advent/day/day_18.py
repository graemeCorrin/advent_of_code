import pathlib


class Day18:

    @staticmethod
    def part_1() -> int:

        def to_int(val):
            try:
                return int(val)
            except:
                return val

        cmds = []
        in_file = pathlib.Path.cwd().parent.parent / 'data' / 'day_18.txt'
        with open(in_file) as file:
            for line in file:
                cmds.append(list(map(to_int, line.split())))

        registers = 'abcdefghijklmnopqrstuvwxyz'
        reg = dict(zip(registers, [0] * len(registers)))
        played = None

        i = 0
        while i < len(cmds):

            cmd = cmds[i]

            if cmd[0] == 'snd':
                played = reg[cmd[1]]
            elif cmd[0] == 'set':
                reg[cmd[1]] = reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'add':
                reg[cmd[1]] += reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'mul':
                reg[cmd[1]] *= reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'mod':
                reg[cmd[1]] %= reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'rcv':
                return played
            elif cmd[0] == 'jgz':
                i = i + 1 if reg.get(cmd[1], cmd[1]) == 0 else i + reg.get(cmd[2], cmd[2])
                continue

            i += 1
