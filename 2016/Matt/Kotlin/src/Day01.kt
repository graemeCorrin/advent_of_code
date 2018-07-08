package html.advent2016

import java.io.BufferedReader
import java.io.File
import kotlin.math.abs

class Day01() : DayBase() {
    private val dataFile = "data/day01";
    private val turnMap = mapOf("L" to -1, "R" to 1)

    override fun solution() {
        val data: MutableList<Array<String>> = getData()
        println(part1(data))
        println(part2(data))
    }


    private fun getData(): MutableList<Array<String>> {
        val bufferedReader: BufferedReader = File(dataFile).bufferedReader()

        val inputString = bufferedReader.use { it.readText() }
        val list = inputString.split(", ")

        val commandList: MutableList<Array<String>> = mutableListOf()

        for (line: String in list) {
            commandList.add(line.split("".toRegex(), 2).toTypedArray())
        }

        return commandList
    }


    private fun part1(data: MutableList<Array<String>>): Int {
        var facing = 0;
        val position: IntArray = intArrayOf(0, 0)

        for (command: Array<String> in data) {
            facing += turnMap.getOrDefault(command[0], 0)
            if (facing < 0)
                facing += 4
            if (facing > 3)
                facing -= 4

            val move: Int = command[1].toInt()
            when(facing) {
                0 -> position[0] -= move
                1 -> position[1] += move
                2 -> position[0] += move
                3 -> position[1] -= move
            }
        }
        return (abs(position[0]) + abs(position[1]))
    }


    private fun part2(data: MutableList<Array<String>>): Int {
        var facing = 0;
        val position: IntArray = intArrayOf(0, 0)
        val trail: MutableSet<IntArray> = mutableSetOf(position.copyOf())
        var repeat = false
        var seen = IntArray(2)

        for (command: Array<String> in data) {
            facing += turnMap.getOrDefault(command[0], 0)
            if (facing < 0)
                facing += 4
            if (facing > 3)
                facing -= 4

            for (i in 1..command[1].toInt()) {
                when (facing) {
                    0 -> position[0] -= 1
                    1 -> position[1] += 1
                    2 -> position[0] += 1
                    3 -> position[1] -= 1
                }
                for (pair: IntArray in trail) {
                    if (pair[0] == position[0] && pair[1] == position[1]) {
                        seen = position.copyOf()
                        repeat = true
                        break
                    }
                }
                if (repeat) {
                    break
                } else {
                    trail.add(position.copyOf())
                }
            }
            if (repeat)
                break
        }
        return (abs(seen[0]) + abs(seen[1]))
    }
}