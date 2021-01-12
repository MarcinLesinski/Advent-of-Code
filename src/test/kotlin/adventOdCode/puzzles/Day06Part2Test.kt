package adventOdCode.puzzles

import adventOdCode.common.DataReader
import adventOdCode.puzzles.day5.common.SeatDecoder
import adventOdCode.puzzles.day5.common.parseInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day06Part2Test {

    @Test
    fun example(){
        val lines = DataReader.readData("/day6_sample.data")
        val actual = Day06Part2(lines).solve()

        assertEquals(6, actual )
    }

}