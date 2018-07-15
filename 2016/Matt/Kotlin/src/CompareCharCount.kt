package html.advent2016

class CompareCharCount {
    companion object : Comparator<CharCounter> {
        override fun compare(o1: CharCounter, o2: CharCounter): Int = when {
            o1.getCount() != o2.getCount() -> o2.getCount() - o1.getCount()
            else -> o1.getID() - o2.getID()
        }
    }
}