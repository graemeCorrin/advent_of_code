import pathlib
from collections import deque
from threading import Thread, Lock
from queue import Queue
from collections import defaultdict


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
        p1_q = Queue()
        p2_q = Queue()

        # Probably not the most ideal way to capture my desired return value, but we're going with it
        return_value = Queue()

        lock = Lock()

        puzzle_thread_1 = Thread(target=Day18.__process_commands, args=(cmds, 0, p1_q, p2_q, lock))
        puzzle_thread_2 = Thread(target=Day18.__process_commands, args=(cmds, 1, p2_q, p1_q, lock, return_value))

        puzzle_thread_1.start()
        puzzle_thread_2.start()

        return return_value.get()

    @staticmethod
    def __process_commands(cmds: list, thread_id: int, in_q: Queue, out_q: Queue, lock: Lock, ret: Queue=None):

        registers = 'abcdefghijklmnopqrstuvwxyz'
        reg = dict(zip(registers, [0] * len(registers)))
        reg['p'] = thread_id
        snd_msgs = 0
        rcv_msgs = 0

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
                    # print(f"no more messages left for Program {thread_id}")
                    break
                rcv_msgs += 1
            i += 1

        # with lock:
            # print(f"{thread_id}: {snd_msgs} sent, {rcv_msgs} received")

        if ret:
            ret.put(snd_msgs)

    @staticmethod
    def to_int(val):
        try:
            return int(val)
        except:
            return val
