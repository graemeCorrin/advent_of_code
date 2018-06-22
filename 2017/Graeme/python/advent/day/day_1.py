class Day1:

    @staticmethod
    def part_1(string: str) -> float:
        """
        Solution for Day 1 Part 1.  Sum all digits in input string that match their counterpart, where the counterpart
        of a digit is the digit that is 1 position away from it

        :param string: Input string of digits
        :return: Sum of matching digit pairs
        """
        return Day1.__captcha(string, 1)

    @staticmethod
    def part_2(string: str) -> float:
        """
        Solution for Day 1 Part 2.  Sum all digits in input string that match their counterpart, where the counterpart
        of a digit is the digit that is len(string) / 2 positions away from it

        :param string: Input string of digits
        :return: Sum of matching digit pairs
        """
        return Day1.__captcha(string, int(len(string) / 2))

    @staticmethod
    def __captcha(string: str, step: int) -> float:
        """
        Sum all digits in input string that match their counterpart, where the counterpart of a digit is the digit that
        is a number of positions away from it as defined by the step value

        :param string: Input string of digits
        :param step: The step between digit pairs
        :return: Sum of matching digit pairs
        """

        final_sum = 0
        length = len(string)
        for i in range(length):
            next_i = i + step if i + step < length else i + step - length
            if string[i] == string[next_i]:
                final_sum += int(string[i])

        return final_sum
