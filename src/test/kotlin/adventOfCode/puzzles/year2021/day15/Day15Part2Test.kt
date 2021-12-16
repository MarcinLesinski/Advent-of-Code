package adventOfCode.puzzles.year2021.day15

import adventOfCode.common.DataReader
import java.math.BigInteger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day15Part2Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 15)

        val actual = Day15Part2(input).solve()

        Assertions.assertEquals(315, actual)
    }
}
