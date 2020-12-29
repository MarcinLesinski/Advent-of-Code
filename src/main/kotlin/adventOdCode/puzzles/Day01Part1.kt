package adventOdCode.puzzles

import adventOdCode.domain.Numbers
import adventOdCode.domain.Puzzle
import adventOdCode.domain.forEachPair

class Day01Part1(input: Numbers): Puzzle<Numbers, Int>(input) {
    private val targetValue = 2020

    override fun solve(): Int {
        var result: Int? = null

        input.forEachPair { a, b ->
            if ( a + b == targetValue ) {
                result = a * b
                return@forEachPair
            }}

        return result!!
    }
}