package adventOfCode.puzzles.year2021.day03

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day03Part2Test {

    @Test
    fun example() {
        val input = """ 
                        00100
                        11110
                        10110
                        10111
                        10101
                        01111
                        00111
                        11100
                        10000
                        11001
                        00010
                        01010
                   """.trimIndent()

        val actual = Day03Part2(input).solve()

        Assertions.assertEquals(230, actual)
    }
}
