
class Day5:

    @staticmethod
    def steps_to_escape(maze, decrement_above=None):
        """
        Return the number of steps it takes to escape the maze.  Starting at index 0, check the number maze[i],
        offset i by the value found, and increment the value in maze[i] by 1.  Continue until i is outside the
        bounds of the list.  If a decrement_above value is provided, and the offset at maze[i] is above the
        decrement_above value, decrement maze[i] instead if incrementing it.

        :param list maze: List to escape
        :param int decrement_above: If offset is above this value, decrement value in list
        :return: Step to escape the list
        :rtype: int
        """

        steps = 0
        index = 0

        # While we are within the bounds of our array
        while -1 < index < len(maze):
            # Get offset
            offset = int(maze[index])

            # Increment or decrement maze[index]
            if decrement_above and offset > decrement_above:
                maze[index] -= 1
            else:
                maze[index] += 1

            # Offset the current index
            index += offset

            # Increment steps taken
            steps += 1

        return steps
