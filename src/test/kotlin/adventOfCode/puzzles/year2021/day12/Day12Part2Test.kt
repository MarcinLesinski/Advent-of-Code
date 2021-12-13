package adventOfCode.puzzles.year2021.day12

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day12Part2Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 12)

        val actual = Day12Part2(input).solve()

        Assertions.assertEquals(3509, actual)
    }
}
