package adventOfCode.puzzles.year2020

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asNumbers
import adventOfCode.domain.forEachPair

@Year(2020) @Day(1, 1)
class Day01Part1(input: RawInput): Puzzle<Int>(input) {
    private val targetValue = 2020

    override fun solve(): Int {
        var result: Int? = null

        input.asNumbers().forEachPair { a, b ->
            if ( a + b == targetValue ) {
                result = a * b
                return@forEachPair
            }}

        return result!!
    }
}
