import re
from advent.helper.particle import Particle


class Day20:

    @staticmethod
    def part_1(lines: list) -> int:

        # Get Particles with minimum acceleration

        smallest_acc = None
        smallest_acc_particles = []

        for i in range(len(lines)):
            string = lines[i]
            pattern = re.compile('p=<(?P<pos>.*?)(?=>)>, v=<(?P<vel>.*?)(?=>)>, a=<(?P<acc>.*?)(?=>)>')
            match = pattern.match(string)
            pos = tuple(map(int, match.group("pos").split(',')))
            vel = tuple(map(int, match.group("vel").split(',')))
            acc = tuple(map(int, match.group("acc").split(',')))

            abs_acc = sum(map(abs, acc))

            if not smallest_acc or abs_acc < smallest_acc:
                smallest_acc = abs_acc
                smallest_acc_particles = [Particle(i, pos, vel, acc)]
            elif abs_acc == smallest_acc:
                smallest_acc_particles.append(Particle(i, pos, vel, acc))

        if len(smallest_acc_particles) == 1:
            return smallest_acc_particles[0].id

        # Update Particles until all velocities and accelerations are in the same direction

        all_same_direction = False
        while not all_same_direction:

            for particle in smallest_acc_particles:
                particle.update()

            all_same_direction = True
            for particle in smallest_acc_particles:
                if not particle.vel.same_sign(particle.acc):
                    all_same_direction = False

        # Get minium velocities

        smallest_vel = None
        smallest_vel_particles = []

        for particle in smallest_acc_particles:
            abs_vel = sum(map(abs, particle.vel.t()))

            if not smallest_vel or abs_vel < smallest_vel:
                smallest_vel = abs_vel
                smallest_vel_particles = [particle]
            elif abs_vel == smallest_vel:
                smallest_vel_particles.append(particle)

        if len(smallest_vel_particles) == 1:
            return smallest_vel_particles[0].id

        # Get minimum distance from origin

        closest_particle = None
        for particle in smallest_acc_particles:
            if not closest_particle:
                closest_particle = particle
            elif particle.distance_from_origin() < closest_particle.distance_from_origin():
                closest_particle = particle

        return closest_particle.id

    @staticmethod
    def part_2(lines: list):

        particles = []
        for i in range(len(lines)):
            string = lines[i]
            pattern = re.compile('p=<(?P<pos>.*?)(?=>)>, v=<(?P<vel>.*?)(?=>)>, a=<(?P<acc>.*?)(?=>)>')
            match = pattern.match(string)
            pos = tuple(map(int, match.group("pos").split(',')))
            vel = tuple(map(int, match.group("vel").split(',')))
            acc = tuple(map(int, match.group("acc").split(',')))
            particles.append(Particle(i, pos, vel, acc))

        collisions = {}

        for i in range(len(particles) - 1):
            for j in range(i + 1, len(particles)):
                t = particles[i].get_collisions(particles[j])
                if t >= 0:
                    if t not in collisions:
                        collisions[t] = list()
                    collisions[t].append((i, j))

        p = set(range(len(particles)))
        for key in sorted(list(collisions.keys())):
            r = set()
            for i, j in collisions[key]:
                if i in p and j in p:
                    r.add(i)
                    r.add(j)
            for i in r:
                p.remove(i)

        return len(p)
