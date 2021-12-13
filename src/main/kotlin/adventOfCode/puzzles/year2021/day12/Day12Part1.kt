package adventOfCode.puzzles.year2021.day12

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asMatrix

@Year(2021)
@Day(12, 1)
internal class Day12Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        input.asLines()
        val factory  = Factory(input.asLines().filter{it.trim().isNotEmpty()})
        factory.construct(1)
        factory.start().run("", false)
        return factory.end().entries()
    }
}

