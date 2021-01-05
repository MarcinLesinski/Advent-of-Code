package adventOdCode.puzzles

import adventOdCode.common.DataReader
import adventOdCode.domain.Lines
import adventOdCode.domain.Puzzle
import adventOdCode.puzzles.day4.PassportsReader

class Day04Part2(input: Lines) : Puzzle<Lines, Int>(input) {
    override fun solve(): Int {
        val input = DataReader.readRawData(4)

        val passports = PassportsReader().read(input)
        return passports?.count{it.valid()} ?: 0
    }
}