package adventOdCode.puzzles

import adventOdCode.domain.Numbers
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigInteger

internal class Day01Part2Test {

    @Test
    fun example() {
        val input: Numbers = listOf(1721, 979, 366, 299, 675, 1456)
        val result = Day01Part2(input).solve()
        assertEquals( BigInteger.valueOf(241861950), result )
    }
}