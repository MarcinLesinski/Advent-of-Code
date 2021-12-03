package adventOfCode.puzzles.year2020

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.puzzles.year2020.day4.PassportsReader

@Year(2020) @Day(4, 2)
class Day04Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val passports = PassportsReader().read(input)
        return passports?.count{it.valid()} ?: 0
    }
}
