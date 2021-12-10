package adventOfCode.puzzles.year2021.day10

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day10Part1Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 10)

        val actual = Day10Part1(input).solve()

        Assertions.assertEquals(26397, actual)
    }
}
