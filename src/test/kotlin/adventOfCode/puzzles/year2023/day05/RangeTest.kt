package adventOfCode.puzzles.year2023.day05

import org.junit.jupiter.api.Test

class RangeTest {
    val nvm = 789L

    @Test
    fun `should return one range`(){
        val input = InputRange(30, 70)
        val range = DomainRange(nvm, 1, 100)
//        val ranges = range.transform(input)
//
//        assert(ranges.size == 1)
    }

    @Test
    fun `should return three ranges`(){
        val input = InputRange(1, 100)
        val range = DomainRange(nvm, 30, 40)
//        val ranges = range.transform(input)
//
//        assert(ranges.size == 3)
    }


}