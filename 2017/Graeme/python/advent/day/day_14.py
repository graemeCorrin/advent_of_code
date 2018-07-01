from advent.day.day_10 import Day10


class Day14:

    @staticmethod
    def part_1(string: str) -> int:
        """
        Get the number of used spaces on disk based on the knot hash of the input string

        :param string: input string
        :return: number of used spaces
        """
        return sum([bin(int(Day10.get_hash_2(f'{string}-{i}', 256), 16))[2:].zfill(128).count('1') for i in range(128)])

    @staticmethod
    def part_2(string: str) -> int:
        """
        Get the number of used regions on disk based on the knot hash of the input string
        A region is a group us used spaces that are all adjacent

        :param string: input string
        :return: number of used regions
        """

        disk = []
        for i in range(128):
            disk.append([])
            line = bin(int(Day10.get_hash_2(f'{string}-{i}', 256), 16))[2:].zfill(128)
            for val in line:
                disk[i].append(int(val))

        new_disk = []
        for x in range(128):
            new_disk.append([])
            for y in range(128):
                new_disk[x].append(0)

        region = 1
        for i in range(128):
            for j in range(128):
                if new_disk[i][j]:
                    continue

                if disk[i][j] == 1:
                    Day14.__update_disk(disk, new_disk, region, i, j)
                    region += 1

        return region - 1

    @staticmethod
    def __update_disk(disk, new_disk, region, i, j):
        """
        Update the new_disk for the current region

        :param disk: input disk
        :param new_disk: disk to update with regions
        :param region: current region
        :param i: current row
        :param j: current column
        """

        if i > 127 or i < 0 or j > 127 or j < 0:
            return
        if new_disk[i][j]:
            return
        if not disk[i][j]:
            return

        new_disk[i][j] = region

        Day14.__update_disk(disk, new_disk, region, i + 1, j)
        Day14.__update_disk(disk, new_disk, region, i - 1, j)
        Day14.__update_disk(disk, new_disk, region, i, j + 1)
        Day14.__update_disk(disk, new_disk, region, i, j - 1)
