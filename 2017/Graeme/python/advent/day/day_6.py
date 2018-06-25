
class Day6:

    @staticmethod
    def steps_to_infinite_loop(array: list) -> int:
        """
        Redistribute the largest element in the list evenly across the list, starting at the element after the largest
        element.  Continue until a configuration of the list is seen twice.  Return the number of steps.  This will be
        the number of steps before an infinite loop is detected.

        :param array: Input array of integers
        :return: Steps till an infinite loop is detected
        """
        tuples = set()
        steps = 0

        while True:

            # Check if current configuration already exists, return if it does, add it if it doesn't
            tup = tuple(array)
            if tup in tuples:
                return steps
            else:
                tuples.add(tup)

            steps += 1

            # Get the value and index of the maximum value in the list
            max_i, max_value = max(enumerate(array), key=lambda e: e[1])

            # Reset the value of the maximum element
            array[max_i] = 0

            # Redistribute the maximum value across the list, starting at the next element
            for i in range(1, max_value + 1):
                update_i = (i + max_i) % len(array)
                array[update_i] += 1
