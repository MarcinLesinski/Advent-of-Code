package adventOfCode.puzzles.year2021.day02.part2

import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2021.day02.Day02Part2
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day04Part2Test {

    @Test
    fun example(){
        val data = DataReader.readRawData(2021, 2)
        val actual = Day02Part2(data).solve()

        Assertions.assertEquals(900, actual)
    }
}
