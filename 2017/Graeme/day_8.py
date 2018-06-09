class Registers:

    __max_val = None

    def __init__(self):
        self.__registers = {}

    def process_instruction(self, instruction):
        """
        Process an instruction, updating the relevant register if necessary

        :param str instruction: Instruction to process
        """
        reg_1, action, val_1, junk, reg_2, operator, val_2 = instruction.split(" ")
        cond = False

        if operator == '==':
            if self.get_reg(reg_2) == int(val_2):
                cond = True
        elif operator == '!=':
            if self.get_reg(reg_2) != int(val_2):
                cond = True
        elif operator == '<':
            if self.get_reg(reg_2) < int(val_2):
                cond = True
        elif operator == '>':
            if self.get_reg(reg_2) > int(val_2):
                cond = True
        elif operator == '<=':
            if self.get_reg(reg_2) <= int(val_2):
                cond = True
        elif operator == '>=':
            if self.get_reg(reg_2) >= int(val_2):
                cond = True
        else:
            raise ValueError("Unrecognized operator: {}".format(operator))

        if cond:
            if action == 'inc':
                self.__inc_reg(reg_1, int(val_1))
            if action == 'dec':
                self.__dec_reg(reg_1, int(val_1))

            if self.get_reg(reg_1) > self.__max_val:
                self.__max_val = self.get_reg(reg_1)

    def get_current_max(self):
        """
        Returns the maximum value currently stored in a register

        :return: Maximum value in registers
        :rtype: int
        """
        return self.__registers[max(self.__registers, key=lambda k: self.__registers[k])]

    def get_max(self):
        """
        Returns the maximum value ever stored in a register

        :return: Maximum value ever stored in a register
        :rtype: int
        """
        return self.__max_val

    def get_reg(self, register):
        """
        Get value from register

        :param str register: Register containing value
        :return: Value in register
        :rtype: int
        """
        try:
            return self.__registers[register]
        except:
            return 0

    def __inc_reg(self, register, value):
        """
        Increment value in register

        :param str register: Register to increment
        :param int value: Value to increment register by
        """
        try:
            self.__registers[register] += value
        except:
            self.__registers[register] = value

    def __dec_reg(self, register, value):
        """
        Decrement value in register

        :param str register: Register to decrement
        :param int value: Value to decrement register by
        """
        try:
            self.__registers[register] -= value
        except:
            self.__registers[register] = value * -1


def main():

    in_file = 'inputs/day_8.txt'
    registers = Registers()

    # Process every instruction in input file
    with open(in_file) as f:
        for line in f:
            registers.process_instruction(line)

    # Part 1
    print(registers.get_current_max())

    # Part 2
    print(registers.get_max())


if __name__ == "__main__":
    main()
