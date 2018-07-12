package html.advent2016

import java.io.File
import kotlin.math.max


class Day03() : DayBase() {
    val dataFile = "data/day03"

    override fun solution() {
        val data = getData()
        println(part1(data))
        println(part2(data))
    }


    private fun getData(): List<List<Int>> {
        val data: MutableList<List<Int>> = mutableListOf()

        val inputLines = File(dataFile).useLines { it.toList() }

        for (line: String in inputLines) {
            data.add(line.trim().split("\\s+".toRegex()).map { it.toInt() })
        }

        return data.toList()
    }


    private fun part1(data: List<List<Int>>): Int {
        var validCount = 0

        for (triangle: List<Int> in data) {
            validCount += if (isValidTriangle(triangle)) 1 else 0
        }

        return validCount
    }


    private fun part2(data: List<List<Int>>): Int {
        var validCount = 0

        val dataSize = data.size
        val setCount = dataSize / 3

        for (i in 0 until setCount) {
            val tupleOne = data[(i * 3)]
            val tupleTwo = data[(i * 3) + 1]
            val tupleThree = data[(i * 3) + 2]

            for (j in 0 until 3) {
                validCount += if (isValidTriangle(tupleOne[j], tupleTwo[j], tupleThree[j])) 1 else 0
            }
        }

        return validCount
    }


    private fun isValidTriangle(triangle: List<Int>): Boolean {
        val high = max(triangle[0], max(triangle[1], triangle[2]))
        val sum = triangle[0] + triangle[1] + triangle[2]
        return (sum - (2 * high) > 0)
    }


    private fun isValidTriangle(sideA: Int, sideB: Int, sideC: Int): Boolean {
        val high = max(sideA, max(sideB, sideC))
        val sum = sideA + sideB + sideC
        return (sum - (2 * high) > 0)
    }
}


fun main(args: Array<String>) {
    val day = Day03()
    day.solution()
}