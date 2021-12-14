package adventOfCode.puzzles.year2021.day14

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day14Part1Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 14)

        val actual = Day14Part1(input).solve()

        Assertions.assertEquals(1588, actual)
    }
}
