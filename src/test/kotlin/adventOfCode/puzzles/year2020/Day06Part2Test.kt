package adventOfCode.puzzles.year2020

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06Part2Test {

    @Test
    fun example(){
        val lines = DataReader.readRawData("year2020/day6_sample.data")
        val actual = Day06Part2(lines).solve()

        assertEquals(6, actual )
    }

}
