package adventOfCode.puzzles.year2020

import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2020.Day07Part1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day07Part1Test {

    @Test
    fun sample(){
        val input = DataReader.readRawData("year2020/day7_sample.data")

        val actual = Day07Part1(input).solve()
        assertEquals(4, actual )
    }
}
