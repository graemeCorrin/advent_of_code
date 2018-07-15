package html.advent2016

import java.io.File

class Day07 : DayBase() {
    private val dataFile = "data/day07"

    override fun solution() {
        val data = getData()
        println(part1(data))
        println(part2(data))
    }


    private fun getData(): List<String> {
        return File(dataFile).useLines { it.toList() }
    }


    private fun part1(data: List<String>): Int {
        var supportsTlsCount = 0

        for (line in data) {
            supportsTlsCount += if (supportsTls(line)) 1 else 0
        }

        return supportsTlsCount
    }


    private fun supportsTls(ipv7Address: String): Boolean {
        var editedIP = ipv7Address
        while (editedIP.contains("\\[\\w*]".toRegex())) {
            val squareBracketRange = (editedIP.indexOf('['))..(editedIP.indexOf(']'))
            val hyperNetSequence = editedIP.substring((squareBracketRange.start + 1)
                    ..(squareBracketRange.endInclusive - 1))
            if (isAbba(hyperNetSequence))
                return false

            editedIP = editedIP.replace(editedIP.substring(squareBracketRange), " ")
        }

        return isAbba(editedIP)
    }


    private fun isAbba(testString: String): Boolean {
        if (testString.length < 4)
            return false

        val stringLength = testString.length
        var lastFourChars: String

        for (i in 0 until (stringLength - 3)) {
            lastFourChars = testString.substring(i..i + 3)

            if (lastFourChars[0] != lastFourChars[1] && lastFourChars[0] == lastFourChars[3]
                    && lastFourChars[1] == lastFourChars[2])
                return true
        }

        return false
    }


    private fun part2(data: List<String>): Int {
        var supportsSslCount = 0

        for (line in data) {
            supportsSslCount += if (supportsSsl(line)) 1 else 0
        }

        return supportsSslCount
    }


    private fun supportsSsl(ipv7Address: String): Boolean {
        val abaSet = mutableSetOf<String>()
        val babSet = mutableSetOf<String>()
        var editedIP = ipv7Address

        while (editedIP.contains("\\[\\w*]".toRegex())) {
            val squareBracketRange = (editedIP.indexOf('['))..(editedIP.indexOf(']'))
            val hyperNetSequence = editedIP.substring((squareBracketRange.start + 1)
                    ..(squareBracketRange.endInclusive - 1))
            babSet.addAll(getXyxSet(hyperNetSequence))

            editedIP = editedIP.replace(editedIP.substring(squareBracketRange), " ")
        }

        abaSet.addAll(getXyxSet(editedIP))

        for (aba in abaSet) {
            for (bab in babSet) {
                if (aba[0] == bab[1] && aba[1] == bab[0])
                    return true
            }
        }

        return false
    }


    private fun getXyxSet(testString: String): MutableSet<String> {
        val xyxSet = mutableSetOf<String>()

        if (testString.length >= 3) {

            val stringLength = testString.length
            var lastThreeChars: String

            for (i in 0 until (stringLength - 2)) {
                lastThreeChars = testString.substring(i..i + 2)

                if (lastThreeChars[0] != lastThreeChars[1] && lastThreeChars[0] == lastThreeChars[2])
                    xyxSet.add(lastThreeChars)
            }
        }

        return xyxSet
    }
}


fun main(args: Array<String>) {
    val day = Day07()
    day.solution()
}