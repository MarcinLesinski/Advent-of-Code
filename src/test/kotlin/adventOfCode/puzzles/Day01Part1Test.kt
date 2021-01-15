package adventOfCode.puzzles

import adventOfCode.domain.Numbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.reflect.typeOf

internal class Day01Part1Test {

    @Test
    fun example() {
        val input = listOf(1721, 979, 366, 299, 675, 1456).joinToString(separator = "\n")
        val result = Day01Part1(input).solve()
        assertEquals( 514579, result )
    }
}