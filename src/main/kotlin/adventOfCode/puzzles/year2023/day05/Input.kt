package adventOfCode.puzzles.year2023.day05

import adventOfCode.common.Range

data class Input(
    val kind: String,
    val values: List<Long>
)

data class InputRange(
    val from: Long,
    val to: Long
) {
    val isValid get() = to - from >= 0

    fun overflow(from: Long, to: Long): Boolean {
        val a = (this.from >= from).not()
        val b = (this.to >= from).not()
        val c = (this.to <= to).not()
        val d = (this.from <= to).not()
        return a or b or c or d
    }

    fun isValid(from: Long, to: Long): Boolean {
        val isValid = this.isValid
        val overflow = this.overflow(from, to)

        return isValid and overflow.not()
    }

    fun toRange(): Range = Range(from, to)
}

data class InputBasedOnRanges(
    val kind: String,
    val ranges: List<InputRange>
)
