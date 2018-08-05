package html.advent2016

import java.io.File

class Day08 : DayBase() {
    private val dataFile = "data/day08"
    private val lcdDisplay = Array(6) { IntArray(50) }

    override fun solution() {
        val data = getData()
        println(part1(data))
        part2()
    }


    private fun getData(): List<Triple<String, Int, Int>> {
        val fileLines = File(dataFile).useLines { it.toList() }
        val commandList = mutableListOf<Triple<String, Int, Int>>()

        for (line in fileLines) {
            val commandString = line.replace("rect ", "draw,").replace("rotate row y=", "shiftRow,")
                    .replace("rotate column x=", "shiftCol,").replace("x", ",").replace(" by ", ",")
            val temp = commandString.split(",")

            commandList.add(Triple(temp[0], temp[1].toInt(), temp[2].toInt()))
        }

        return commandList
    }


    private fun part1(commandList: List<Triple<String, Int, Int>>): Int {
        var litCount = 0

        for ((command, valOne, valTwo) in commandList) {
            when (command) {
                "draw" -> {
                    for (i in 0 until valOne) {
                        for (j in 0 until valTwo) {
                            lcdDisplay[j][i] = 1
                        }
                    }
                }
                "shiftRow" -> {
                    val temp = lcdDisplay[valOne].copyOf()
                    for (i in 0 until 50) {
                        lcdDisplay[valOne][(i + valTwo) % 50] = temp[i]
                    }
                }
                "shiftCol" -> {
                    val temp = IntArray(6)
                    for (i in 0 until 6) {
                        temp[i] = lcdDisplay[i][valOne]
                    }
                    for (i in 0 until 6) {
                        lcdDisplay[(i + valTwo) % 6][valOne] = temp[i]
                    }
                }
            }
        }

        for (i in 0 until 6) {
            for(j in 0 until 50) {
                litCount += lcdDisplay[i][j]
            }
        }

        return litCount
    }


    private fun part2() {
        println()
        println()
        for (i in 0 until 6) {
            var displayString = ""
            for (j in 0 until 50) {
                if (j % 5 == 0)
                    displayString += " "

                displayString += if (lcdDisplay[i][j] == 1) "000" else "   "
            }
            println(displayString)
            println(displayString)
        }
    }
}


fun main(args: Array<String>) {
    val day = Day08()
    day.solution()
}