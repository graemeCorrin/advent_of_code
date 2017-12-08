class Registers:

    __max_val = None

    def __init__(self):
        self.__registers = {}

    def process_file(self, input_file):

        with open(input_file) as f:
            for line in f:
                reg_1, action, val_1, junk, reg_2, operator, val_2 = line.split(" ")
                cond = False

                if operator == '==':
                    if self.__get_reg(reg_2) == int(val_2):
                        cond = True
                elif operator == '!=':
                    if self.__get_reg(reg_2) != int(val_2):
                        cond = True
                elif operator == '<':
                    if self.__get_reg(reg_2) < int(val_2):
                        cond = True
                elif operator == '>':
                    if self.__get_reg(reg_2) > int(val_2):
                        cond = True
                elif operator == '<=':
                    if self.__get_reg(reg_2) <= int(val_2):
                        cond = True
                elif operator == '>=':
                    if self.__get_reg(reg_2) >= int(val_2):
                        cond = True
                else:
                    raise ValueError("Unrecognized operator: {}".format(operator))

                if cond:
                    if action == 'inc':
                        self.__inc_reg(reg_1, int(val_1))
                    if action == 'dec':
                        self.__dec_reg(reg_1, int(val_1))

                    if self.__get_reg(reg_1) > self.__max_val:
                        self.__max_val = self.__get_reg(reg_1)

    def get_current_max(self):
        return self.__registers[max(self.__registers, key=lambda k: self.__registers[k])]

    def get_max(self):
        return self.__max_val

    def __get_reg(self, register):
        try:
            return self.__registers[register]
        except:
            return 0

    def __inc_reg(self, register, value):
        try:
            self.__registers[register] += value
        except:
            self.__registers[register] = value

    def __dec_reg(self, register, value):
        try:
            self.__registers[register] -= value
        except:
            self.__registers[register] = value * -1


def main():

    in_file = 'inputs/day_8.txt'
    registers = Registers()
    registers.process_file(in_file)

    # Part 1
    print(registers.get_current_max())

    # Part 2
    print(registers.get_max())


if __name__ == "__main__":
    main()
