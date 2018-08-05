package html.advent2016

import java.io.File

class Day06 : DayBase() {
    private val dataFile = "data/day06"

    override fun solution() {
        val data = getData()
        println(part1(data))
        println(part2(data))
    }


    private fun getData(): List<String> {
        return File(dataFile).useLines { it.toList() }
    }


    private fun part1(data: List<String>): String {
        val result = CharArray(8)
        val charSlotMap: MutableMap<Int, RepetitionCharSlot> = mutableMapOf()
        for (i in 0..7) {
            charSlotMap[i] = RepetitionCharSlot(i.toString())
        }

        for (line in data) {
            for (i in 0..7) {
                charSlotMap[i]?.addToTestChars(line[i])
            }
        }

        for (i in 0..7) {
            result[i] = charSlotMap[i]!!.mostCommonChar()
        }

        return String(result)
    }


    private fun part2(data: List<String>): String {
        val result = CharArray(8)
        val charSlotMap: MutableMap<Int, RepetitionCharSlot> = mutableMapOf()
        for (i in 0..7) {
            charSlotMap[i] = RepetitionCharSlot(i.toString())
        }

        for (line in data) {
            for (i in 0..7) {
                charSlotMap[i]?.addToTestChars(line[i])
            }
        }

        for (i in 0..7) {
            result[i] = charSlotMap[i]!!.leastCommonChar()
        }

        return String(result)
    }
}


fun main(args: Array<String>) {
    val day = Day06()
    day.solution()
}