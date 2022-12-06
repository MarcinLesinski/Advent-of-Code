package adventOfCode.puzzles.year2022.day06

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines

@Year(2022)
@Day(6, 1)
internal class Day06Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        return input.windowed(4).map { unique(it) }.indexOfFirst { it } + 4
    }
}

