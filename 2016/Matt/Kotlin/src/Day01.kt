package html.advent2016

import java.io.BufferedReader
import java.io.File

class Day01() : DayBase() {
    private val dataFile = "data/day01";

    override fun solution() {
        val data: MutableList<Array<String>> = getData()
    }


    private fun getData(): MutableList<Array<String>> {
        val bufferedReader: BufferedReader = File(dataFile).bufferedReader()

        val inputString = bufferedReader.use { it.readText() }
        var list = inputString.split(", ")

        var commandList: MutableList<Array<String>> = mutableListOf()

        for (line: String in list) {
            commandList.add(line.split("".toRegex(), 2).toTypedArray())
        }

        return commandList
    }
}