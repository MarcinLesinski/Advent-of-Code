package adventOfCode.puzzles.year2021.day14

import adventOfCode.common.DataReader
import java.math.BigInteger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day14Part2Test {

    @Test
    fun example() {
        val input = DataReader.readRawData(2021, 14)

        val actual = Day14Part2(input).solve()

        Assertions.assertEquals(BigInteger("2188189693529"), actual)
    }
}
