package adventOfCode.puzzles.year2021.day06

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day06Part2Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 6)

        val actual = Day06Part2(input).solve()

        Assertions.assertEquals(26984457539, actual)
    }
}
