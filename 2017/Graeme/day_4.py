
def main():
    in_file = 'inputs/day_4.txt'

    # Part 1
    result = check_pass_phrases(in_file)
    print(result)

    # Part 2
    result = check_pass_phrases(in_file, False)
    print(result)


def check_pass_phrases(in_file, allow_anagrams=True):
    """
    Calculate number of valid pass phrases from a file where every line is a pass phrase, and a valid pass phrase
    contains no duplicate words.  If allow_anagrams is False, anagrams count as duplicate words.

    :param str in_file: Input file containing pass phrases
    :param bool allow_anagrams: If valid pass phrases allow anagrams
    :return: Number of valid pass phrases
    :rtype: int
    """

    valid_phrases = 0
    with open(in_file) as f:
        for line in f:

            # Get list of words, removing newline character
            words = line.rstrip().split(' ')

            # If anagrams count as duplicates, sort every word in list
            if not allow_anagrams:
                words = [''.join(sorted(word)) for word in words]

            # Hash the list to remove duplicates, if the length is unchanged, there were no duplicates
            if len(words) == len(set(words)):
                valid_phrases += 1

    return valid_phrases


if __name__ == "__main__":
    main()
