from days.import_select_day import Select


class App:
    puzzle_day = 7
    part = 1

    def __init__(self):
        self.select = Select(self.puzzle_day)
        self.solution = self.select.puzzle()

    def execute(self):
        if self.part == 1:
            self.solution.part_1()
        elif self.part == 2:
            self.solution.part_2()


if __name__ == '__main__':
    app = App()
    app.execute()
