package adventOfCode.puzzles.day08

import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2020.day8.Part1
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Part1Tests {
    @Test
    internal fun name() {
        val input = DataReader.readRawData("day08/sample1.data")
        val actual = Part1(input).solve()
        assertEquals(5, actual)
    }
}
