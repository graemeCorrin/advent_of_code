class Day13:

    @staticmethod
    def part_1(strings: list) -> int:
        """
        Get the severity of crossing the given firewall

        :param strings: list of layers and their depths
        :return: severity of crossing the firewall
        """

        max_layer = 0
        firewall = {}
        for string in strings:
            layer, depth = map(int, string.split(': '))

            firewall[layer] = depth

            if layer > max_layer:
                max_layer = layer

        severity = 0
        for i in range(max_layer + 1):
            if i in firewall:
                if i % ((firewall[i] - 1) * 2) == 0:
                    severity += i * firewall[i]

        return severity

    @staticmethod
    def part_2(strings: list) -> int:
        """
        Get the minimum time required to wait to pass the firewall with 0 severity

        :param strings: list of layers and their depths
        :return: minimum wait time
        """

        max_layer = 0
        firewall = {}
        for string in strings:
            layer, depth = map(int, string.split(': '))

            firewall[layer] = depth

            if layer > max_layer:
                max_layer = layer

        for i in range(10000000):
            success = True
            for j in range(max_layer + 1):
                if j in firewall:
                    if (j + i) % ((firewall[j] - 1) * 2) == 0:
                        success = False
            if success:
                return i
