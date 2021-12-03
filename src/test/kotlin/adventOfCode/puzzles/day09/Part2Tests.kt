package adventOfCode.puzzles.day09

import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2020.day9.Part2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Part2Tests {

    @Test
    internal fun sample() {
        val input = DataReader.readRawData("day09/sample.data")
        val actual = Part2(input).run{
            this.expectedValue = 127
            this}
            .solve()
        assertEquals(62, actual)
    }
}
