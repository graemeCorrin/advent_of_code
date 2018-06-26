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
