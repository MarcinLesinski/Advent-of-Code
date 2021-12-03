package adventOfCode.puzzles.year2020

import adventOfCode.common.multiply
import adventOfCode.domain.*
import java.math.BigInteger

@Year(2020) @Day(1, 2)
class Day01Part2(input: RawInput): Puzzle<BigInteger>(input) {
    private val targetValue = 2020

    override fun solve(): BigInteger {
        var result: BigInteger? = null

        val algorithm = { subset: List<Int> ->
                if (subset.sum() == targetValue)
                    result = subset.multiply()
        }
        input.asNumbers().forEachSubset(3, algorithm)

        return result!!
    }
}
