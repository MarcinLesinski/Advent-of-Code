package adventOfCode.puzzles.year2022.day02

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbersSections

@Year(2022)
@Day(2, 1)
internal class Day02Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        return input
            .asLines()
            .map { Match(Choose.of(it[2]), Choose.of(it[0])) }
            .map { it.points() }
            .sum()
    }
}


