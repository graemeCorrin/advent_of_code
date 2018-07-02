
class Day16:

    @staticmethod
    def part_1(dance: list, programs: str) -> str:
        """
        Get the state of the input programs after they have performed the input set of dance moves

        :param dance: list of moves to perform
        :param programs: starting state of programs
        :return: state of programs after dance
        """

        progs = list(programs)

        for move in dance:
            cmd = move[0]

            if cmd == 's':
                ind = -1 * int(move[1:])
                progs = progs[ind:] + progs[:ind]
            elif cmd == 'x':
                pos1, pos2 = map(int, move[1:].split('/'))
                tmp = progs[pos1]
                progs[pos1] = progs[pos2]
                progs[pos2] = tmp
            elif cmd == 'p':
                pos1, pos2 = map(progs.index, move[1:].split('/'))
                tmp = progs[pos1]
                progs[pos1] = progs[pos2]
                progs[pos2] = tmp

        return ''.join(progs)

    @staticmethod
    def part_2(dance: list, programs: str) -> str:
        """
        Get the state of the input programs after they have performed the input set of dance moves 1 billion times

        :param dance: list of moves to perform
        :param programs: starting state of programs
        :return: state of programs after 1 billion dances
        """

        states = [programs]
        set_states = {programs}

        for i in range(1000000000):
            new_state = Day16.part_1(dance, states[i])
            states.append(new_state)
            set_states.add(new_state)

            if len(set_states) < len(states):
                break

        return states[1000000000 % (len(states) - 1)]
