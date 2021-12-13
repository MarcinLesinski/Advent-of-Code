package adventOfCode.puzzles.year2021.day13

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day13Part1Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 13)

        val actual = Day13Part1(input).solve()

        Assertions.assertEquals(16, actual)
    }
}
