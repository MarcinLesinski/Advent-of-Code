package adventOfCode.puzzles.year2022.day01

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbers
import adventOfCode.domain.asNumbersSections
import java.lang.Integer.sum

@Year(2022)
@Day(1, 1)
internal class Day01Part1(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {
        return input
            .asNumbersSections()
            .map{it.sum()}
            .max()!!
    }
}
