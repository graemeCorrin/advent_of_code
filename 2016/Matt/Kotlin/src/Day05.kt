package html.advent2016

import java.io.File
import org.apache.commons.codec.digest.DigestUtils.*

class Day05 : DayBase() {
    private val dataFile = "data/day05"

    override fun solution() {
        val data = getData()
        println(part1(data))
        println(part2(data))
    }


    private fun getData(): String {
        return File(dataFile).readText()
    }


    private fun part1(doorID: String): String {
        var index = 0
        var password = ""

        while (password.length < 8) {
            val hash = md5Hex(doorID + index)
            var valid = true

            for (i in 0 until 5) {
                if (hash[i] != '0')
                    valid = false
            }

            if (valid)
                password += hash[5]

            index ++
        }

        return password
    }


    private fun part2(doorID: String): String {
        var index = 0
        val password = CharArray(8)
        val availablePositions: MutableSet<Char> = mutableSetOf()
        availablePositions.addAll('0'..'7')

        while (availablePositions.isNotEmpty()) {
            val hash = md5Hex(doorID + index)
            var valid = true

            for (i in 0 until 5) {
                if (hash[i] != '0')
                    valid = false
            }

            if (valid) {
                if (availablePositions.contains(hash[5])) {
                    password[hash[5].toInt() - '0'.toInt()] = hash[6]
                    availablePositions.remove(hash[5])
                }
            }

            index ++
        }

        return String(password)
    }
}


fun main(args: Array<String>) {
    val day = Day05()
    day.solution()
}