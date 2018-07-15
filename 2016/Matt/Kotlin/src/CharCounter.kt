package html.advent2016

class CharCounter(private val id: Char, private var count: Int = 0) {
    fun getID(): Char {
        return id
    }


    fun getCount(): Int {
        return count
    }


    fun resetCount() {
        count = 0
    }


    fun incrementCount() {
        count++
    }
}