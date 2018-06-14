
class HexNode:

    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    def move_north(self):
        self.y += 1
        self.z -= 1

    def move_north_east(self):
        self.x += 1
        self.z -= 1

    def move_north_west(self):
        self.x -= 1
        self.y += 1

    def move_south(self):
        self.y -= 1
        self.z += 1

    def move_south_east(self):
        self.x += 1
        self.y -= 1

    def move_south_west(self):
        self.x -= 1
        self.z += 1

    def dist_from(self, node):
        # return (abs(self.x - node.x) + abs(self.y - node.y) + abs(self.z - node.z)) / 2
        return max(abs(self.x - node.x), abs(self.y - node.y), abs(self.z - node.z))


def main():

    input_list = []
    in_file = 'inputs/day_11.txt'
    with open(in_file) as f:
        for line in f:
            input_list = line.split(',')

    # Part 1
    result = dist_from_center(input_list)
    print(result)

    # Part 2
    result = furthest_dist_from_center(input_list)
    print(result)


def dist_from_center(input_list):
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


def furthest_dist_from_center(input_list):
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


if __name__ == "__main__":
    main()
