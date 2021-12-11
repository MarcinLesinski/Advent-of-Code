package adventOfCode.puzzles.year2021.day11

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day11Part1Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 11)

        val actual = Day11Part1(input).solve()

        Assertions.assertEquals(1656, actual)
    }
}
