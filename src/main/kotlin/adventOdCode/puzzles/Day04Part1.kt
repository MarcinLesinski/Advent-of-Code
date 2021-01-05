package adventOdCode.puzzles

import adventOdCode.common.*
import adventOdCode.domain.*
import adventOdCode.puzzles.day4.PassportsReader

class Day04Part1(input: Lines) : Puzzle<Lines, Int>(input) {
    override fun solve(): Int {
        val input = DataReader
            .readRawData(4)

        val passports = PassportsReader().readSimple(input)
        return passports?.count { it.valid() } ?: 0
    }
}