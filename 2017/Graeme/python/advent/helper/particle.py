import math


class Coord:
    def __init__(self, x, y, z):
        self.x = x
        self.y = y
        self.z = z

    def __add__(self, c: 'Coord'):
        return Coord(self.x + c.x, self.y + c.y, self.z + c.z)

    def __sub__(self, c: 'Coord'):
        return Coord(self.x - c.x, self.y - c.y, self.z - c.z)

    def __eq__(self, c: 'Coord'):  # compares two coords
        return self.x == c.x and self.y == c.y and self.z == c.z

    def __repr__(self):
        return f'Coord(x={self.x}, y={self.y}, z={self.z})'

    def t(self):
        return self.x, self.y, self.z

    def same_sign(self, c: 'Coord') -> bool:
        if self.x * c.x < 0:
            return False
        if self.y * c.y < 0:
            return False
        if self.z * c.z < 0:
            return False
        return True


class Particle:

    def __init__(self, id: int, pos: tuple, vel: tuple, acc: tuple):
        self.id = id
        self.pos = Coord(*pos)
        self.vel = Coord(*vel)
        self.acc = Coord(*acc)

    def __repr__(self):
        return f'Particle(id={self.id}, pos={self.pos}, vel={self.vel}, acc={self.acc})'

    def update(self):
        self.pos += self.vel
        self.vel += self.acc

    def distance_from_origin(self):
        return sum(map(abs, self.pos.t()))

    def get_collisions(self, other: 'Particle') -> int:

        # Create quadratic equation for X
        # ax^2 + bx + c = 0
        a = 0.5 * (self.acc.x - other.acc.x)
        b = (self.vel.x + 0.5 * self.acc.x) - (other.vel.x + 0.5 * other.acc.x)
        c = self.pos.x - other.pos.x

        times = []
        if a == 0:
            if b != 0:
                times.append(-c / b)
        else:
            bb = b * b
            ac4 = a * c * 4
            if bb < ac4:
                return -1
            elif bb == ac4:
                times.append(-b / (2 * a))
            else:
                rt = math.sqrt(bb - ac4)
                times.append((-b + rt) / (2 * a))
                times.append((-b - rt) / (2 * a))

        # Filter out negative collisions and collisions not on time steps
        times = map(int, filter(lambda t: round(t) == t >= 0, times))

        for t in times:

            # Check for Y collisions
            a = 0.5 * (self.acc.y - other.acc.y)
            b = (self.vel.y + 0.5 * self.acc.y) - (other.vel.y + 0.5 * other.acc.y)
            c = self.pos.y - other.pos.y
            if a * t * t + b * t + c != 0:
                continue

            # Check for Z collisions
            a = 0.5 * (self.acc.z - other.acc.z)
            b = (self.vel.z + 0.5 * self.acc.z) - (other.vel.z + 0.5 * other.acc.z)
            c = self.pos.z - other.pos.z
            if a * t * t + b * t + c != 0:
                continue

            # if we found a collision, it will be the only collision
            return t

        return -1
