package adventOfCode.puzzles.year2021.day12

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asMatrix
import java.util.ArrayDeque

@Year(2021)
@Day(12, 2)
internal class Day12Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        input.asLines()
        val factory  = Factory(input.asLines().filter{it.trim().isNotEmpty()})
        factory.construct(2)
        factory.start().run("", true)
        return factory.end().entries()
    }
}

