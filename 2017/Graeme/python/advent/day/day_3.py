import math


class Day3:

    @staticmethod
    def steps_to_center(value: int) -> int:
        """

        :param value: 
        :return: steps from the center
        """

        closest_root = math.ceil(math.sqrt(value))
        if closest_root % 2 == 0:
            closest_root += 1

        square = closest_root * closest_root
        corners = [square,
                   square - (closest_root - 1),
                   square - (closest_root - 1) * 2,
                   square - (closest_root - 1) * 3]

        closest_corner = min(corners, key=lambda corner: abs(corner - value))
        dist_from_corner = abs(closest_corner - value)

        dist_from_center = (closest_root - 1) - dist_from_corner

        return dist_from_center

    @staticmethod
    def first_larger_value(value: int) -> int:

        # Starting grid and cell
        grid = {0: {0: 1}}
        next_cell = [0, 0]

        dirs = ['r', 'u', 'l', 'd']
        current_dir = 0

        tot_length = 0
        cur_length = 1

        while True:

            # Determine next cell
            if dirs[current_dir] == 'r':
                next_cell = [next_cell[0] + 1, next_cell[1]]

            elif dirs[current_dir] == 'u':
                next_cell = [next_cell[0], next_cell[1] + 1]

            elif dirs[current_dir] == 'l':
                next_cell = [next_cell[0] - 1, next_cell[1]]

            elif dirs[current_dir] == 'd':
                next_cell = [next_cell[0], next_cell[1] - 1]

            # Add all values surrounding next_cell, if they exist
            new_val = 0

            new_val = Day3.__try_add(new_val, grid, next_cell[0], next_cell[1] + 1)  # Right
            new_val = Day3.__try_add(new_val, grid, next_cell[0] + 1, next_cell[1] + 1)  # Above, Right
            new_val = Day3.__try_add(new_val, grid, next_cell[0] + 1, next_cell[1])  # Above
            new_val = Day3.__try_add(new_val, grid, next_cell[0] + 1, next_cell[1] - 1)  # Above, Left
            new_val = Day3.__try_add(new_val, grid, next_cell[0], next_cell[1] - 1)  # Left
            new_val = Day3.__try_add(new_val, grid, next_cell[0] - 1, next_cell[1] - 1)  # Below, Left
            new_val = Day3.__try_add(new_val, grid, next_cell[0] - 1, next_cell[1])  # Below
            new_val = Day3.__try_add(new_val, grid, next_cell[0] - 1, next_cell[1] + 1)  # Below, Right

            # If we are at the end of a row or column
            if cur_length > tot_length:

                # If we are at the end of a row, we need to add a new array (but not for columns)
                if dirs[current_dir] == 'r':
                    grid[next_cell[0]] = {}
                elif dirs[current_dir] == 'l':
                    grid[next_cell[0]] = {}

                # Total length of the row/col should increase by 1 every second time the length is hit
                tot_length += 0.5

                # Reset current length of new row/col
                cur_length = 1

                # Change direction
                current_dir += 1
                if current_dir == 4:
                    current_dir = 0

            else:
                # Increment current length of new row/col
                cur_length += 1

            # Add new value to grid
            grid[next_cell[0]][next_cell[1]] = new_val

            # Return first value greater than input value
            if new_val > value:
                return new_val

    @staticmethod
    def __try_add(value, grid, x, y):
        try:
            return value + grid[x][y]
        except:
            return value
