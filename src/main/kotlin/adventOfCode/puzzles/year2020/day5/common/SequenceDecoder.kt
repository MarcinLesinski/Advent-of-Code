package adventOfCode.puzzles.year2020.day5.common

class SequenceDecoder(private val length: Int) {
    private val pattern = Regex("^[0-1]+")
    fun decode(turns: String): Int {
        check(turns.length == length)
        check(pattern.matches(turns))
        return turns.toInt(2)
    }
}
