package adventOfCode.puzzles.day09

import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2020.day9.Part1
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Part1Tests {

    @Test
    internal fun sample() {
        val input = DataReader.readRawData("day09/sample.data")
        val actual = Part1(input)
            .run{
                this.preambleLength = 5
                this}
            .solve()
        assertEquals(127, actual)
    }
}
