package adventOfCode.puzzles.year2021.day05

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day05Part1Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 5)

        val actual = Day05Part1(input).solve()

        Assertions.assertEquals(5, actual)
    }
}
