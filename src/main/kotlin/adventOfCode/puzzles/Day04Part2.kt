package adventOfCode.puzzles

import adventOfCode.common.DataReader
import adventOfCode.domain.Day
import adventOfCode.domain.Lines
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day4.PassportsReader

@Day(4, 2)
class Day04Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val passports = PassportsReader().read(input)
        return passports?.count{it.valid()} ?: 0
    }
}