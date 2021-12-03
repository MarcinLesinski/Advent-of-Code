package adventOfCode.puzzles

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigInteger

internal class Day01Part2Test {

    @Test
    fun example() {
        val input = listOf(1721, 979, 366, 299, 675, 1456).joinToString(separator = "\n")
        val result = adventOfCode.puzzles.year2020.Day01Part2(input).solve()
        assertEquals( BigInteger.valueOf(241861950), result )
    }
}
