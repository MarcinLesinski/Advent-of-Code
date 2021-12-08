package adventOfCode.puzzles.year2021.day08

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines

@Year(2021)
@Day(8, 1)
internal class Day08Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        return input.asLines().map{
            it.split(" | ")[1].trim()
        }.map{ it.split(" ") }.flatten().count{
            it.length in arrayOf(2, 4, 3, 7)
        }
    }
}


