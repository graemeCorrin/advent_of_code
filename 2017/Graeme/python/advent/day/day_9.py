
def main():

    input_string = ''
    in_file = 'inputs/day_9.txt'
    with open(in_file) as f:
        for line in f:
            input_string = line

    # Part 1
    result = get_weight(input_string)
    print(result)

    # Part 2
    result = count_garbage(input_string)
    print(result)


def get_weight(string, i=0, weight=0):
    """
    Calculate the total weight of an input string, where the weight of each group is 1 + the number of groups above it.
    Ignore characters following "!" and ignore characters inside "<>" ("!" taking precedence).

    :param str string: Input string
    :param int i: Starting index
    :param int weight: Current weight
    :return: Total weight
    :rtype: int
    """

    in_garbage = False
    total_weight = weight

    while i < len(string):
        ch = string[i]

        if ch == '!':
            i += 1

        elif in_garbage:
            if ch == '>':
                in_garbage = False
        else:
            if ch == '{':
                value = get_weight(string, i + 1, weight + 1)
                total_weight += value[0]
                i = value[1]
            elif ch == '}':
                # If we return from here, we are returning to another call of this function
                # We need to return the current index
                return total_weight, i
            elif ch == '<':
                in_garbage = True

        i += 1

    # If we return here, we are returning to the original caller, so we don't return the current index
    # This inconsistent return value is probably a terrible idea, but I'm doing it anyways
    return total_weight


def count_garbage(string, i=0):
    """
    Calculate the total garbage of an input string, where garbage is the number of characters between "<>", excluding
    "!" and characters immediately following "!".

    :param str string: Input string
    :param int i: Starting index
    :return: Total garbage
    :rtype: int
    """

    in_garbage = False
    garbage = 0

    while i < len(string):
        ch = string[i]

        if ch == '!':
            i += 1

        elif in_garbage:
            if ch == '>':
                in_garbage = False
            else:
                garbage += 1
        else:
            if ch == '{':
                value = count_garbage(string, i + 1)
                garbage += value[0]
                i = value[1]
            elif ch == '}':
                # If we return from here, we are returning to another call of this function
                # We need to return the current index
                return garbage, i
            elif ch == '<':
                in_garbage = True

        i += 1

    # If we return here, we are returning to the original caller, so we don't return the current index
    # This inconsistent return value is probably a terrible idea, but I'm doing it anyways
    return garbage


if __name__ == "__main__":
    main()
