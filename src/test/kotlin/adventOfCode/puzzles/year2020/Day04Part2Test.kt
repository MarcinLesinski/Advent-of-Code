package adventOfCode.puzzles.year2020


import adventOfCode.common.DataReader
import adventOfCode.puzzles.year2020.day4.PassportsReader
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day04Part2Test {

    @Test
    fun allValid() {
        val input = DataReader.readRawData("/year2020/day4B_valid.data")

        val passports = PassportsReader().read(input)
        val actual = passports?.count{it.valid()}

        assertEquals(4, actual)
    }

    @Test
    fun allInvalid() {
        val input = DataReader.readRawData("/year2020/day4B_invalid.data")
        val passports = PassportsReader().read(input)
        val actual = passports?.count{it.valid()}

        assertEquals(0, actual)
    }

}
