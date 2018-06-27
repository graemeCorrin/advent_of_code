
class Day12:

    @staticmethod
    def part_1(input_list: list) -> int:
        """
        Get the number of programs connected to 0

        :param input_list: List of program connects
        :return: Number of programs connected to 0
        """

        # Setup pipes
        pipes = {}
        for line in input_list:
            prog = line.split('<->')[0].strip()
            connections = line.split('<->')[1].strip().split(', ')
            pipes[prog] = connections

        # Find connections to 0
        found = set()
        Day12.__find_connections(pipes, '0', found)

        return len(found)

    @staticmethod
    def part_2(input_list: list) -> int:
        """
        Get the number of program groups

        :param input_list: List of program connects
        :return: Number of distinct program groups
        """

        # Setup pipes
        pipes = {}
        for line in input_list:
            prog = line.split('<->')[0].strip()
            connections = line.split('<->')[1].strip().split(', ')
            pipes[prog] = connections

        groups = 0
        while True:
            if len(pipes) == 0:
                break

            prog = list(pipes.keys())[0]
            found = set()
            Day12.__find_connections(pipes, prog, found)

            for found_prog in found:
                if found_prog in pipes:
                    del pipes[found_prog]

            groups += 1

        return groups

    @staticmethod
    def __find_connections(pipes: dict, prog: str, found: set):
        """
        Add all connections to prog to found

        :param pipes: Dictionary of pipes
        :param prog: Prog to find connections to
        :param found: Set to be updated with all connections to prog
        """
        if prog not in pipes:
            return
        elif prog in found:
            return
        else:
            found.add(prog)
            connections = pipes[prog]
            for connection in connections:
                Day12.__find_connections(pipes, connection, found)
