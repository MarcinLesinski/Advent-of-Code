package adventOfCode.puzzles.year2021.day01

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asNumbers

@Year(2021)
@Day(1, 2)
internal class Day01Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        return input.asNumbers()
            .windowed(3, 1)
            .map { it.sum() }
            .windowed(2, 1)
            .count { it[0] < it[1] }
    }
}
