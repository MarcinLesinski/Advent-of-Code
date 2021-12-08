package adventOfCode.puzzles.year2021.day08

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day08Part2Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 8)

        val actual = Day08Part2(input).solve()

        Assertions.assertEquals(61229, actual)
    }
}
