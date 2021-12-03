package adventOfCode.puzzles.year2020

import adventOfCode.domain.*
import adventOfCode.puzzles.year2020.day4.PassportsReader

@Year(2020) @Day(4, 1)
class Day04Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val passports = PassportsReader().readSimple(input)
        return passports?.count { it.valid() } ?: 0
    }
}
