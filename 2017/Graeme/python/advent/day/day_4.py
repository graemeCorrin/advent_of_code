import pathlib


class Day4:

    @staticmethod
    def check_pass_phrases_from_file(in_file: pathlib.Path, allow_anagrams: bool=True):
        """
        Calculate number of valid pass phrases from a file where every line is a pass phrase, and a

        :param in_file: Input file containing pass phrases
        :param allow_anagrams: If valid pass phrases allow anagrams
        :return: Number of valid pass phrases
        """

        valid_phrases = 0
        with open(in_file) as f:
            for line in f:
                if Day4.check_pass_phrase(line, allow_anagrams):
                    valid_phrases += 1

        return valid_phrases

    @staticmethod
    def check_pass_phrase(phrase: str, allow_anagrams: bool=True) -> bool:
        """
        Check if the input pass phrase is valid.  A valid pass phrase contains no duplicate words.
        If allow_anagrams is False, anagrams count as duplicate words.

        :param phrase: Pass phrase to check
        :param allow_anagrams: If valid pass phrases allow anagrams
        :return: True if pass phrase is valid, False otherwise
        """

        # Get list of words, removing newline character
        words = phrase.rstrip().split(' ')

        # If anagrams count as duplicates, sort every word in list
        if not allow_anagrams:
            words = [''.join(sorted(word)) for word in words]

        # Hash the list to remove duplicates, if the length is unchanged, there were no duplicates
        if len(words) == len(set(words)):
            return True

        return False