package adventOfCode.puzzles.year2021.day07

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day07Part2Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 7)

        val actual = Day07Part2(input).solve()

        Assertions.assertEquals(168, actual)
    }
}
