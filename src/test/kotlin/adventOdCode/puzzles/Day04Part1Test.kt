package adventOdCode.puzzles


import adventOdCode.common.DataReader
import adventOdCode.puzzles.day4.Passport
import adventOdCode.puzzles.day4.PassportsReader

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day04Part1Test {

    @Test
    fun example() {
        val input = DataReader
            .readRawData(4)

        val passports = PassportsReader().readSimple(input)
        val actual = passports?.count{it.valid()}

        assertEquals(2, actual)
    }
}