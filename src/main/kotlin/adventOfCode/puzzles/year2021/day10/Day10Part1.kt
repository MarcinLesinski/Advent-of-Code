package adventOfCode.puzzles.year2021.day10

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines

@Year(2021)
@Day(10, 1)
internal class Day10Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        return input.asLines().mapNotNull { corruptedChar(it) }
            .map{
                when(it){
                    ')'->3
                    ']'->57
                    '}'->1197
                    '>' -> 25137
                    else -> 0
                }
            }.sum()
    }
}

