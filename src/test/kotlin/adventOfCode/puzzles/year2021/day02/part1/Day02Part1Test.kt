package adventOfCode.puzzles.year2021.day02.part1

import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2021.day02.Day02Part1
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day02Part1Test {

    @Test
    fun example(){
        val data = DataReader.readRawData(2021, 2)
        val actual = Day02Part1(data).solve()

        Assertions.assertEquals(150, actual)
    }
}
