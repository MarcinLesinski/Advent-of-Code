package adventOfCode.puzzles

import adventOfCode.common.*
import adventOfCode.domain.*
import adventOfCode.puzzles.day4.PassportsReader

@Day(4, 1)
class Day04Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val passports = PassportsReader().readSimple(input)
        return passports?.count { it.valid() } ?: 0
    }
}