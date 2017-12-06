
def main():

    array = [10, 3, 15, 10, 5, 15, 5, 15, 9, 2, 5, 8, 5, 2, 3, 6]

    # Part 1
    result = steps_to_infinite_loop(array)
    print(result)

    # Part 2
    # The first call of the function modified the original array
    # calling the same function again will give you the number of steps IN the infinite loop
    result = steps_to_infinite_loop(array)
    print(result)


def steps_to_infinite_loop(array):
    """
    Redistribute the largest element in the list evenly across the list, starting at the element after the largest
    element.  Continue until a configuration of the list is seen twice.  Return the number of steps.  This will be
    the number of steps before an infinite loop is detected.

    :param list array: Input array of integers
    :return: Steps till an infinite loop is detected
    :rtype: int
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


if __name__ == "__main__":
    main()
