package adventOfCode.puzzles.year2020.day3

import adventOfCode.common.Matrix

class Slope(
    private val pattern: Matrix<Boolean>) {

    operator fun get(left: Int, top: Int): Boolean{
        val fixedLeft = (left).rem(pattern.width)
        return pattern[fixedLeft, top]
    }

    fun contains(left: Int, top: Int): Boolean {
        return (top) < pattern.height
    }

    override fun toString(): String {
        var result = ""
        pattern.indices{ x, y ->
            result += "[$y $x-"
            result += if (pattern[x, y])
                "x" else "O"
            result += "]"
        }
        return result
    }
}
