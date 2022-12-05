package adventOfCode.puzzles.year2021.day04

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day05Part1Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 4)

        val actual = Day04Part1(input).solve()

        Assertions.assertEquals(4512, actual)
    }
}
