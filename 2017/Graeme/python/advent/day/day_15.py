from collections import deque


class Day15:

    @staticmethod
    def part_1(gen_a: int, gen_b: int) -> int:
        """
        Get number of matches between two generators

        :param gen_a: starting value of generator a
        :param gen_b: starting value of generator a
        :return: number of matches
        """
        matches = 0
        for i in range(40000000):
            gen_a = (gen_a * 16807) % 2147483647
            gen_b = (gen_b * 48271) % 2147483647

            if gen_a & 65535 == gen_b & 65535:
                matches += 1

        return matches

    @staticmethod
    def part_2(gen_a: int, gen_b: int) -> int:
        """
        Get number of matches between two generators

        :param gen_a: starting value of generator a
        :param gen_b: starting value of generator a
        :return: number of matches
        """
        queue_a = deque()
        queue_b = deque()

        while len(queue_a) < 5000000:
            gen_a = (gen_a * 16807) % 2147483647
            if gen_a & 3 == 0:
                queue_a.append(gen_a)

        while len(queue_b) < 5000000:
            gen_b = (gen_b * 48271) % 2147483647
            if gen_b & 7 == 0:
                queue_b.append(gen_b)

        matches = 0
        while queue_a and queue_b:
            if queue_a.popleft() & 65535 == queue_b.popleft() & 65535:
                matches += 1

        return matches
