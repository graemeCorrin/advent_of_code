package html.advent2016

import java.io.File

class Day04() : DayBase() {
    val dataFile = "data/day04"


    override fun solution() {
        val data = getData()
        val realRoomData = part1(data)
        println(part2(realRoomData))
    }


    private fun getData(): List<Triple<String, String, Int>> {
        val temp = File(dataFile).useLines { it.toList() }
        val data: MutableList<Triple<String, String, Int>> = mutableListOf()

        for (line: String in temp) {
            val cut: Int = line.lastIndexOf('-')
            val encryptedName = line.substring(0, cut)
            val secondHalf = line.substring(cut).replace("]", "").split("[")
            val checkSum = secondHalf[1]
            val sectorID = secondHalf[0].replace("-", "").toInt()

            data.add(Triple(encryptedName, checkSum, sectorID))
        }

        return data.toList()
    }


    private fun part1(data: List<Triple<String, String, Int>>): List<Pair<String, Int>> {
        var validSectorSum = 0
        val realRoomList: MutableList<Pair<String, Int>> = mutableListOf()

        for (line: Triple<String, String, Int> in data) {
            val encryptedString = line.first.replace("-", "")
            val checkSum = line.second
            val sectorID = line.third

            val charCounterMap = mutableMapOf<Char, CharCounter>()
            for (char in 'a'..'z') {
                charCounterMap[char] = CharCounter(char)
            }

            for (char in encryptedString) {
                charCounterMap[char]?.incrementCount()
            }

            val sortedCharsByMostCommon = charCounterMap.values.toList().sortedWith(CompareCharCount)
            var valid = true

            for (i in 0 until 5) {
                if (checkSum[i] != sortedCharsByMostCommon[i].getID())
                    valid = false
            }
            if (valid) {
                validSectorSum += sectorID
                realRoomList.add(Pair(line.first, sectorID))
            }
        }

        println(validSectorSum)
        return realRoomList.toList()
    }


    private fun part2(data: List<Pair<String, Int>>): Int {

        for (line: Pair<String, Int> in data) {
            val encryptedRoomName = line.first
            val shift = line.second
            var realRoomName = ""

            for (char in encryptedRoomName) {
                when (char) {
                    in 'a'..'z' -> {
                        realRoomName += 'a'.plus((char.minus('a') + shift) % 26)
                    }
                    '-' -> realRoomName += ' '
                }
            }
            if (realRoomName.contains("north(.*)pole".toRegex())) {
                return line.second
            }
        }

        return 0
    }
}


fun main(args: Array<String>) {
    val day = Day04()
    day.solution()
}