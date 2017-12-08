import collections


def main():

    in_file = 'inputs/day_7.txt'

    # Part 1
    result = find_bottom(in_file)
    print(result)

    # Part 2
    result = find_incorrect_weight(in_file)
    print(result)


def find_bottom(in_file):

    all_nodes = set()
    all_parents = set()

    with open(in_file) as f:
        for l in f:
            line = "".join(l.split())
            line_split = line.split('->')

            all_nodes.add(line_split[0].split('(')[0])

            if len(line_split) > 1:
                all_parents.update(line_split[1].split(','))

    diff = all_nodes - all_parents
    if len(diff) > 1:
        raise Exception("Multiple heads")

    return diff.pop()


def find_incorrect_weight(in_file):

    Node = collections.namedtuple('Node', ['weight', 'parents'])
    tree = {}
    all_parents = set()

    with open(in_file) as f:
        for l in f:
            line = "".join(l.split())
            line_split = line.split('->')

            name, weight = line_split[0].split('(')
            weight = weight[:-1]

            if len(line_split) > 1:
                parents = tuple(line_split[1].split(','))
                all_parents.update(parents)
            else:
                parents = ()

            tree[name] = Node(int(weight), parents)

    diff = set(tree.keys()) - all_parents
    if len(diff) > 1:
        raise Exception("Multiple heads")

    bottom = diff.pop()

    try:
        weight = get_weight_of_balanced_tree(tree, bottom)
        raise Exception("Tree is balanced")
    except ValueError as e:
        return e.message


def get_weight_of_balanced_tree(tree, root):

    node = tree[root]
    if not node.parents:
        return node.weight

    parent_weights = []
    for parent in node.parents:
        parent_weights.append(get_weight_of_balanced_tree(tree, parent))

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


if __name__ == "__main__":
    main()
