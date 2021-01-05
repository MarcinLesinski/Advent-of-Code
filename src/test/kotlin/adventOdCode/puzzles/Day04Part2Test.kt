package adventOdCode.puzzles


import adventOdCode.common.DataReader
import adventOdCode.common.readInput
import adventOdCode.puzzles.day4.Passport
import adventOdCode.puzzles.day4.PassportsReader

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day04Part2Test {

    @Test
    fun allValid() {
        val input = DataReader.readRawData("/day4B_valid.data")

        val passports = PassportsReader().read(input)
        val actual = passports?.count{it.valid()}

        assertEquals(4, actual)
    }

    @Test
    fun allInvalid() {
        val input = DataReader.readRawData("/day4B_invalid.data")
        val passports = PassportsReader().read(input)
        val actual = passports?.count{it.valid()}

        assertEquals(0, actual)
    }

}