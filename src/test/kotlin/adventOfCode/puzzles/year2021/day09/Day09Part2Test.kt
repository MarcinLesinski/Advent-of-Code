package adventOfCode.puzzles.year2021.day09

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day09Part2Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 9)

        val actual = Day09Part2(input).solve()

        Assertions.assertEquals(1134, actual)
    }
}
