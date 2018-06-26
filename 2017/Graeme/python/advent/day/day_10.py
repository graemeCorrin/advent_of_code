

class Day10:

    @staticmethod
    def get_hash(lengths: list, circle_size: int) -> int:
        """
        Get the hash, as an integer, of the input list of lengths

        :param lengths: List of lengths
        :param circle_size: Size of the circle
        :return: hash
        """

        circle = list(range(circle_size))
        skip = 0
        i = 0

        for length in lengths:

            # reverse from i to i + length
            values = []
            for j in range(i, length + i):
                values.append(circle[j % len(circle)])

            values.reverse()

            for j in range(i, length + i):
                circle[j % len(circle)] = values[j - i]

            i = (i + length + skip) % len(circle)
            skip += 1

        return circle[0] * circle[1]

    @staticmethod
    def get_hash_2(string: str, circle_size: int) -> str:
        """
        Get the hash, as a hexadecimal string, from an input string

        :param string: Input string to hash
        :param circle_size: Size of the circle
        :return: Hash
        """

        string = [ord(l) for l in string] + [17, 31, 73, 47, 23]
        circle = list(range(circle_size))

        skip = 0
        current_position = 0

        # Generate sparse hash
        for i in range(64):

            for length in string:

                values = []
                for j in range(current_position, length + current_position):
                    values.append(circle[j % len(circle)])

                values.reverse()

                for j in range(current_position, length + current_position):
                    circle[j % len(circle)] = values[j - current_position]

                current_position = (current_position + length + skip) % len(circle)
                skip += 1

        # Generate dense hash
        dense_hash = []
        for i in range(16):
            value = circle[16 * i]
            for j in range(1, 16):
                value = value ^ circle[16 * i + j]
            dense_hash.append(value)

        # Convert to hex string
        dense_hash_string = ''.join([hex(value)[2:].zfill(2) for value in dense_hash])

        return dense_hash_string
