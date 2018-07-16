package html.advent2016

import java.io.File

class Day09 : DayBase() {
    private val dataFile = "data/day09"

    override fun solution() {
        val data = getData()
        println(part1(data))
        println(part2(data))
    }


    private fun getData(): String {
        return File(dataFile).readText()
    }


    private fun part1(data: String): Int {
        var decompressedLength = 0
        var index = 0

        while (index < data.length) {
            if (data[index] == '(') {
                var marker = ""
                index++

                while (data[index] != ')') {
                    marker += data[index]
                    index++
                }

                val repeatLength = marker.split("x")[0].toInt()
                val repeatCount = marker.split("x")[1].toInt()

                decompressedLength += repeatLength * repeatCount
                index += repeatLength

            } else {
                decompressedLength++
            }
            index++
        }

        return decompressedLength
    }


    private fun part2(data: String): Long {
        return decompressedSegmentLength(1, data)
    }


    private fun decompressedSegmentLength(numberOfRepeats: Int, compressedSegment: String): Long {
        var decompressedLength: Long = 0
        var index = 0

        while (index < compressedSegment.length) {
            if (compressedSegment[index] == '(') {
                var marker = ""
                index++

                while (compressedSegment[index] != ')') {
                    marker += compressedSegment[index]
                    index++
                }
                index++

                val repeatLength = marker.split("x")[0].toInt()
                val repeatCount = marker.split("x")[1].toInt()

                decompressedLength += decompressedSegmentLength(repeatCount
                        , compressedSegment.substring(index, index + repeatLength))

                index += repeatLength
            } else {
                decompressedLength++
                index++
            }
        }

        return decompressedLength * numberOfRepeats
    }
}


fun main(args: Array<String>) {
    val day = Day09()
    day.solution()
}