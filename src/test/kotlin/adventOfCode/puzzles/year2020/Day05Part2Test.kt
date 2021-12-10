package adventOfCode.puzzles.year2020

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Part2Test {

    @Test
    fun example(){
        val lines = DataReader.readRawData(2020,5)
        val actual = Day05Part2(lines).solve()

        assertEquals(711, actual )
    }

}
