package html.advent2016

class RepetitionCharSlot(private val charSlotID: String, private var testChars: String = "") {

    private val charCounterMap: MutableMap<Char, CharCounter> = mutableMapOf()

    init {
        for (char in 'a'..'z') {
            charCounterMap[char] = CharCounter(char)
        }
    }


    fun getCharSlotID(): String {
        return charSlotID
    }


    fun setTestChars(newTestChars: String) {
        testChars = newTestChars
    }


    fun setTestChars(newTestChars: CharArray) {
        setTestChars(String(newTestChars))
    }


    fun addToTestChars(newChars: String) {
        testChars += newChars
    }


    fun addToTestChars(newChars: CharArray) {
        addToTestChars(String(newChars))
    }


    fun addToTestChars(newChar: Char) {
        addToTestChars(String(charArrayOf(newChar)))
    }


    fun getTestChars(): String {
        return testChars
    }


    fun mostCommonChar(): Char {
        for (char in testChars) {
            charCounterMap[char]?.incrementCount()
        }
        return charCounterMap.values.toList().sortedWith(CompareCharCount)[0].getID()
    }


    fun leastCommonChar(): Char {
        for (char in testChars) {
            charCounterMap[char]?.incrementCount()
        }
        return charCounterMap.values.toList().sortedWith(CompareCharCount).reversed()[0].getID()
    }
}