from threading import Lock
from queue import Queue
from multiprocessing.pool import ThreadPool


class Day18:

    @staticmethod
    def part_1(cmds: list) -> int:

        registers = 'abcdefghijklmnopqrstuvwxyz'
        reg = dict(zip(registers, [0] * len(registers)))
        played = None

        i = 0
        while i < len(cmds):

            cmd = cmds[i]

            if cmd[0] == 'snd':
                played = reg.get(cmd[1], cmd[1])
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
                i = i + 1 if reg.get(cmd[1], cmd[1]) <= 0 else i + reg.get(cmd[2], cmd[2])
                continue

            i += 1

    @staticmethod
    def part_2(cmds: list) -> int:
        pool = ThreadPool(processes=2)

        lock = Lock()
        p1_q = Queue()
        p2_q = Queue()

        async_p0 = pool.apply_async(Day18.__process_commands, (cmds, 0, p1_q, p2_q, lock))
        async_p1 = pool.apply_async(Day18.__process_commands, (cmds, 1, p2_q, p1_q, lock))

        return async_p1.get()

    @staticmethod
    def __process_commands(cmds: list, thread_id: int, in_q: Queue, out_q: Queue, lock: Lock):

        registers = 'abcdefghijklmnopqrstuvwxyz'
        reg = dict(zip(registers, [0] * len(registers)))
        reg['p'] = thread_id
        snd_msgs = 0

        i = 0
        while 0 <= i < len(cmds):

            cmd = cmds[i]

            if cmd[0] == 'set':
                reg[cmd[1]] = reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'add':
                reg[cmd[1]] += reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'mul':
                reg[cmd[1]] *= reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'mod':
                reg[cmd[1]] %= reg.get(cmd[2], cmd[2])
            elif cmd[0] == 'jgz':
                i = i + 1 if reg.get(cmd[1], cmd[1]) <= 0 else i + reg.get(cmd[2], cmd[2])
                continue
            elif cmd[0] == 'snd':
                with lock:
                    out_q.put(reg.get(cmd[1], cmd[1]))
                    snd_msgs += 1
            elif cmd[0] == 'rcv':
                try:
                    reg[cmd[1]] = in_q.get(block=True, timeout=5)
                except:
                    break
            i += 1

        return snd_msgs

    @staticmethod
    def to_int(val):
        try:
            return int(val)
        except:
            return val
