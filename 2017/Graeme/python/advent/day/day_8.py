from advent.helper.registers import Registers


class Day8:

    @staticmethod
    def part_1(instructions: list) -> int:
        registers = Registers()

        for instruction in instructions:
            registers.process_instruction(instruction)

        return registers.get_current_max()

    @staticmethod
    def part_2(instructions: list) -> int:
        registers = Registers()

        for instruction in instructions:
            registers.process_instruction(instruction)

        return registers.get_max()
