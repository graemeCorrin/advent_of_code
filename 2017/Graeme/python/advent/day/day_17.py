
class Day17:

    @staticmethod
    def part_1(step: int) -> int:

        current_pos = 0
        vortex = [0]
        for i in range(1, 2017 + 1):
            current_pos = (current_pos + step) % i + 1
            vortex = vortex[:current_pos] + [i] + vortex[current_pos:]

        return vortex[current_pos + 1]

    @staticmethod
    def part_2(step: int) -> str:
        current_pos = 0
        for i in range(1, 50000000 + 1):
            current_pos = (current_pos + step) % i + 1
            if current_pos == 1:
                val_after_0 = i

        return val_after_0
