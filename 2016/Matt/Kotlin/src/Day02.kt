package html.advent2016

import java.io.File

class Day02() : DayBase() {
    private val dataFile = "data/day02"
    private val keyPadOne = arrayOf(arrayOf('1','2','3'), arrayOf('4','5','6'), arrayOf('7','8','9'))
    private val keyPadTwo = arrayOf(arrayOf('0','0','1','0','0'), arrayOf('0','2','3','4','0')
            , arrayOf('5','6','7','8','9'), arrayOf('0','A','B','C','0'), arrayOf('0','0','D','0','0'))

    override fun solution() {
        val data = getData()
        println(part1(data))
        println(part2(data))
    }


    private fun getData(): List<String> {
        return File(dataFile).useLines { it.toList() }
    }


    private fun part1(data: List<String>): String {
        var result = ""
        val index = intArrayOf(1, 1)
        
        for (line: String in data) {
            val commandCount = line.length

            for (i in 0 until commandCount) {
                when(line[i]) {
                    'U' -> index[0] -= 1
                    'D' -> index[0] += 1
                    'L' -> index[1] -= 1
                    'R' -> index[1] += 1
                }
                if (index[0] < 0)
                    index[0] = 0
                if (index[0] > 2)
                    index[0] = 2
                if (index[1] < 0)
                    index[1] = 0
                if (index[1] > 2)
                    index[1] = 2
            }

            result += keyPadOne[index[0]][index[1]]
        }

        return result
    }


    private fun part2(data: List<String>): String {
        var result = ""
        val index = intArrayOf(2, 2)

        for (line: String in data) {
            val commandCount = line.length

            for (i in 0 until commandCount) {
                val oldIndex = index.copyOf()
                when(line[i]) {
                    'U' -> index[0] -= 1
                    'D' -> index[0] += 1
                    'L' -> index[1] -= 1
                    'R' -> index[1] += 1
                }

                if (index[0] < 0)
                    index[0] = 0
                if (index[0] > 4)
                    index[0] = 4
                if (index[1] < 0)
                    index[1] = 0
                if (index[1] > 4)
                    index[1] = 4
                if (keyPadTwo[index[0]][index[1]] == '0') {
                    index[0] = oldIndex[0]
                    index[1] = oldIndex[1]
                }
            }

            result += keyPadTwo[index[0]][index[1]]
        }

        return result
    }
}


fun main(args: Array<String>) {
    val day = Day02()
    day.solution()
}