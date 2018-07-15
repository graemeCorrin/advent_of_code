package html.advent2016

abstract class DayBase {
    abstract fun solution();
}


fun main(args: Array<String>) {
    val day: DayBase = Day03()
    day.solution()
}