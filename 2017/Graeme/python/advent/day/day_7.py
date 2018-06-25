import collections


class Day7:

    @staticmethod
    def find_root(programs: list) -> str:
        """
        Return the root node in a tree define by an input file

        :param programs: List of programs
        :return: Name of root node
        """

        all_nodes = set()
        all_parents = set()

        for program in programs:
            line = "".join(program.split())
            line_split = line.split('->')

            all_nodes.add(line_split[0].split('(')[0])

            if len(line_split) > 1:
                all_parents.update(line_split[1].split(','))

        diff = all_nodes - all_parents
        if len(diff) > 1:
            raise Exception("Multiple heads")

        return diff.pop()

    @staticmethod
    def find_incorrect_weight(programs: list) -> int:
        """
        Returns the weight required for the incorrect node to re-balance the tree in an otherwise balanced tree
        Assumes only one node had an incorrect weight

        :param programs: List of programs
        :return: The weight required to rebalance the tree
        """

        Node = collections.namedtuple('Node', ['weight', 'parents'])
        tree = {}
        all_parents = set()

        for program in programs:
            line = "".join(program.split())
            line_split = line.split('->')

            name, weight = line_split[0][:-1].split('(')

            if len(line_split) > 1:
                parents = tuple(line_split[1].split(','))
                all_parents.update(parents)
            else:
                parents = ()

            tree[name] = Node(int(weight), parents)

        diff = set(tree.keys()) - all_parents
        if len(diff) > 1:
            raise Exception("Multiple heads")

        root = diff.pop()

        try:
            # Try to get the weight of a balanced tree, this will raise an exception if the tree is unbalanced
            weight = Day7.__get_weight_of_balanced_tree(tree, root)
            raise Exception("Tree is balanced")
        except ValueError as e:
            # We are expecting a ValueError to be raised, safely return the exception message
            # Any other exception is unexpected, let it be raised to the main function
            # Fully recognize that this is a pretty ridiculous way to solve this problem
            return int(str(e).split()[10])

    @staticmethod
    def __get_weight_of_balanced_tree(tree: dict, root: str) -> int:
        """
        Returns the weight of a balanced tree.  Raises exception if tree is unbalanced.
        The tree should be defined by a dictionary of namedtuple('Node', ['weight', 'parents'])

        :param tree: Dictionary defining the tree
        :param root: Name of root node
        :return: Weight of tree
        :raises: ValueError
        """

        node = tree[root]
        if not node.parents:
            return node.weight

        parent_weights = []
        for parent in node.parents:
            parent_weights.append(Day7.__get_weight_of_balanced_tree(tree, parent))

        parent_weights_col = collections.Counter(parent_weights)

        if len(parent_weights_col) == 1:
            return node.weight + sum(parent_weights)
        else:
            good_weight = None
            bad_weight = None
            for weight in parent_weights_col:
                if parent_weights_col[weight] == 1 and not bad_weight:
                    bad_weight = weight
                elif parent_weights_col[weight] > 1 and not good_weight:
                    good_weight = weight
                else:
                    raise Exception("Tree is unbalanced in multiple places")

            for i in range(len(parent_weights)):
                if parent_weights[i] == bad_weight:
                    actual_weight = tree[node.parents[i]].weight
                    diff = good_weight - bad_weight
                    expected_weight = actual_weight + diff
                    msg = "Tree is unbalanced.  Node {} should have a weight of {} but instead has a weight of " \
                          "{}".format(node.parents[i], expected_weight, actual_weight)
                    raise ValueError(msg)

            # Should never hit this case
            raise Exception("Unexpected exception")
