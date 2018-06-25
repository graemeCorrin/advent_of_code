class Registers:

    __max_val = None

    def __init__(self):
        self.__registers = {}

    def process_instruction(self, instruction: str):
        """
        Process an instruction, updating the relevant register if necessary

        :param instruction: Instruction to process
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

            if not self.__max_val or self.get_reg(reg_1) > self.__max_val:
                self.__max_val = self.get_reg(reg_1)

    def get_current_max(self) -> int:
        """
        Returns the maximum value currently stored in a register

        :return: Maximum value in registers
        """
        return self.__registers[max(self.__registers, key=lambda k: self.__registers[k])]

    def get_max(self) -> int:
        """
        Returns the maximum value ever stored in a register

        :return: Maximum value ever stored in a register
        """
        return self.__max_val

    def get_reg(self, register: str) -> int:
        """
        Get value from register

        :param register: Register containing value
        :return: Value in register
        """
        try:
            return self.__registers[register]
        except:
            return 0

    def __inc_reg(self, register: str, value: int):
        """
        Increment value in register

        :param register: Register to increment
        :param value: Value to increment register by
        """
        try:
            self.__registers[register] += value
        except:
            self.__registers[register] = value

    def __dec_reg(self, register: str, value: int):
        """
        Decrement value in register

        :param register: Register to decrement
        :param value: Value to decrement register by
        """
        try:
            self.__registers[register] -= value
        except:
            self.__registers[register] = value * -1
