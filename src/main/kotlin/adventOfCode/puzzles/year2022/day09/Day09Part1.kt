package adventOfCode.puzzles.year2022.day09

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year

@Year(2022)
@Day(9, 1)
internal class Day09Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val steps = steps(input)
        val line = Line()

        steps.forEach {
            line.move(it)
        }

        return  line.tail.coordsWithHistory.history.distinct().count()
    }
}
