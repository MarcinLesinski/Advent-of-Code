package adventOfCode.puzzles.year2022.day01

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbersSections

@Year(2022)
@Day(1, 2)
internal class Day01Part2(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {
        return input
            .asNumbersSections()
            .map{it.sum()}
            .sortedDescending()
            .take(3)
            .sum()
    }
}
