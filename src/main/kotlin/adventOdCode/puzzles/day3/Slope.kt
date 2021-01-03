package adventOdCode.puzzles.day3

import adventOdCode.common.*
import java.util.logging.XMLFormatter

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
        for (y in pattern.indices){
            for(x in pattern[y].indices ){
//                result +=  pattern[i, j].toString()
                result += "[$y $x-"
                result += if (pattern[x, y])
                    "x" else "O"
                result += "]"
            }
        }
            return result
    }
}