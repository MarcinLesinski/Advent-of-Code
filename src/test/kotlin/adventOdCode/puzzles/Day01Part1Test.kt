package adventOdCode.puzzles

import adventOdCode.domain.Numbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day01Part1Test {

    @Test
    fun example() {
        val input: Numbers = listOf(1721, 979, 366, 299, 675, 1456)
        val result = Day01Part1(input).solve()
        assertEquals( 514579, result )
    }
}