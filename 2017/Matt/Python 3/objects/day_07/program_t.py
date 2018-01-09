class Program:
    def __init__(self, name, weight, holding):
        self.name = name
        self.weight = weight
        self.holding = holding
        self.held_by = 'Bottom'
        self.num_below = 0
        self.level = 0
        self.path_above = set()
        self.weight_above = 0

    def __repr__(self):
        return repr((self.name, self.weight, self.holding, self.num_below, self.held_by))
