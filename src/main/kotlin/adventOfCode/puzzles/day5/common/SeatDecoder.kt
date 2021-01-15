package adventOfCode.puzzles.day5.common

class SeatDecoder(val rows: Int, val columns: Int) {
    private val pattern = Regex("^[0-1]+")
    private val rowsDecoder = SequenceDecoder(rows)
    private val columnsDecoder = SequenceDecoder(columns)

    fun decode(turns: String): Int {
        check(turns.length == rows + columns) { "wrong input length" }
        check(pattern.matches(turns)) { "wrong input chars" }
        /* it is possible to use
            SequenceDecoder(rows + columns).decode(turns)
         e.g. for performance reasons

         following solution focuses on
         readability and task content representation "ddd like"
         */
        val row = rowsDecoder.decode(turns.take(rows))
        val column = columnsDecoder.decode(turns.takeLast(columns))
        return row * 8 + column
    }
}

