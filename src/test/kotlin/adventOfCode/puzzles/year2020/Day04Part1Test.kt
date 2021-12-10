package adventOfCode.puzzles.year2020


import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2020.day4.PassportsReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day04Part1Test {

    @Test
    fun example() {
        val input = DataReader
            .readRawData(2020,4)

        val passports = PassportsReader().readSimple(input)
        val actual = passports?.count{it.valid()}

        assertEquals(2, actual)
    }
}
