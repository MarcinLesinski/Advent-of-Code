package adventOdCode.puzzles

import adventOdCode.common.multiply
import adventOdCode.domain.Numbers
import adventOdCode.domain.Puzzle
import adventOdCode.domain.forEachSubset
import java.math.BigInteger

class Day01Part2(input: Numbers): Puzzle<Numbers, BigInteger>(input) {
    private val targetValue = 2020

    override fun solve(): BigInteger {
        var result: BigInteger? = null

        val algorithm = { subset: List<Int> ->
                if (subset.sum() == targetValue)
                    result = subset.multiply()
        }
        input.forEachSubset(3, algorithm)

        return result!!
    }
}