package adventOfCode.puzzles.year2019.day01

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asNumbers

@Year(2019)
@Day(1, 1)
internal class Day01Part1(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int = input.asNumbers().map(::calc).sum()

    fun calc(number: Int): Int = number.div(3) - 2

}
