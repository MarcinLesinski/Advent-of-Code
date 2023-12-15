package adventOfCode.common

import org.junit.jupiter.api.Test

class RangesTest{

    @Test
    fun `should draw common part from two ranges`() {
        val twoRanges = Ranges(
            Range(10, 20),
            Range(30, 40)
        )

        val range = Range(15, 35)

        val result = twoRanges.draw(range)

        assert(result[0] == Range(15, 20))
        assert(result[1] == Range(30, 35))
    }

    @Test
    fun minus() {
        val rangeA = Range(10, 20)
        val rangeB = Range(10, 20)
        val result = rangeA.minus(rangeB)

        assert(result.isEmpty())
    }

}