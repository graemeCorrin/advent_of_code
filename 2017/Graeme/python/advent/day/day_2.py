from typing import List


class Day2:

    @staticmethod
    def checksum_difference(table: List[List[int]]) -> int:
        """
        Sum the largest difference of values in each row of the input table

        :param table: Input table
        :return: Sum
        """

        checksum = 0
        for row in table:
            min_val = None
            max_val = None
            for cell in row:
                if not min_val or cell < min_val:
                    min_val = cell
                if not max_val or cell > max_val:
                    max_val = cell
            checksum += max_val - min_val
        return checksum

    @staticmethod
    def checksum_quotient(table: List[List[int]]) -> int:
        """
        Sum the first quotient of the evenly divisible values found in each row

        :param table: Input table
        :return: Sum
        """
        i = 0
        checksum = 0
        for row in table:
            i += 1
            for cell_1 in row:
                for cell_2 in row:
                    if cell_1 != cell_2 and cell_1 % cell_2 == 0:
                        checksum += cell_1 / cell_2
                        continue
        return int(checksum)
