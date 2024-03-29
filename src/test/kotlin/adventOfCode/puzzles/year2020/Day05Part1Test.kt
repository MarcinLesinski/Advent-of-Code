package adventOfCode.puzzles.year2020

import adventOfCode.puzzles.year2020.day5.common.SeatDecoder
import adventOfCode.puzzles.year2020.day5.common.parseInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day05Part1Test {

    @Test
    fun example(){
        val input = "FBFBBFFRLR"

        val actual = SeatDecoder(7, 3).decode(parseInput(input))

        assertEquals(357, actual )
    }

}
