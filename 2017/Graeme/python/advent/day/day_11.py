from advent.helper.hexnode import HexNode


class Day11:

    @staticmethod
    def dist_from_center(input_list: list) -> int:
        """
        Walk the directions in the input list, return the distance from the final destination to the center

        :param input_list: list of directions
        :return: distance from center
        """
        node = HexNode(0, 0, 0)

        for direction in input_list:
            if direction == 'n':
                node.move_north()
            if direction == 'ne':
                node.move_north_east()
            if direction == 'nw':
                node.move_north_west()
            if direction == 's':
                node.move_south()
            if direction == 'se':
                node.move_south_east()
            if direction == 'sw':
                node.move_south_west()

        return node.dist_from(HexNode(0, 0, 0))

    @staticmethod
    def furthest_dist_from_center(input_list: list) -> int:
        """
        Walk the directions in the input list, return the maximum distance from the center ever reach

        :param input_list: list of directions
        :return: maximum distance from center
        """
        node = HexNode(0, 0, 0)
        furthest_dist = 0

        for direction in input_list:
            if direction == 'n':
                node.move_north()
            if direction == 'ne':
                node.move_north_east()
            if direction == 'nw':
                node.move_north_west()
            if direction == 's':
                node.move_south()
            if direction == 'se':
                node.move_south_east()
            if direction == 'sw':
                node.move_south_west()

            current_dist = node.dist_from(HexNode(0, 0, 0))
            if current_dist > furthest_dist:
                furthest_dist = current_dist

        return furthest_dist
