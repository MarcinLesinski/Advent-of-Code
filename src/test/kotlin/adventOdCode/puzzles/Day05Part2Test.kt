package adventOdCode.puzzles

import adventOdCode.common.DataReader
import adventOdCode.puzzles.day5.common.SeatDecoder
import adventOdCode.puzzles.day5.common.parseInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Part2Test {

    @Test
    fun example(){
        val lines = DataReader.readData(5)
        val actual = Day05Part2(lines).solve()

        assertEquals(711, actual )
    }

}