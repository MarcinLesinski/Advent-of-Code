package adventOfCode.puzzles.year2022.day06

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year

@Year(2022)
@Day(6, 2)
internal class Day06Part2(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {
        return input.windowed(14).map { unique(it) }.indexOfFirst { it } + 14
    }
}
