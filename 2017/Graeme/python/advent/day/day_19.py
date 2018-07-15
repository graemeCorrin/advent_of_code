import pathlib
from enum import Enum


Direction = Enum('Direction', 'left, right, up, down')


class Day19:

    @staticmethod
    def walk_path(in_file: pathlib.Path) -> (str, int):
        with open(in_file) as file:
            lines = file.read().splitlines()

        path = {}
        for y, line in enumerate(lines):
            for x, value in enumerate(line):
                if value.strip():
                    try:
                        path[y][x] = value
                    except:
                        path[y] = {x: value}

        y = 0
        x = list(path[0].keys())[0]
        dir = Direction.down
        letters = list('ABCDEFGHIJKLMNOPQRSTUVWXYZ')
        letters_seen = []
        steps = 0

        while y in path and x in path[y]:
            steps += 1

            # Record letters
            if path[y][x].upper() in letters:
                letters_seen.append(path[y][x])

            # Are we at a corner?
            if path[y][x] == '+':
                if dir == Direction.left or dir == Direction.right:
                    if y + 1 in path and x in path[y + 1]:
                        dir = Direction.down
                    elif y - 1 in path and x in path[y - 1]:
                        dir = Direction.up
                    else:
                        break
                elif dir == Direction.up or dir == Direction.down:
                    if x + 1 in path[y]:
                        dir = Direction.right
                    elif x - 1 in path[y]:
                        dir = Direction.left
                    else:
                        break

            # Advance position
            if dir == Direction.left:
                x -= 1
            elif dir == Direction.right:
                x += 1
            elif dir == Direction.up:
                y -= 1
            elif dir == Direction.down:
                y += 1
            else:
                raise ValueError("Invalid direction")

        return ''.join(letters_seen), steps

