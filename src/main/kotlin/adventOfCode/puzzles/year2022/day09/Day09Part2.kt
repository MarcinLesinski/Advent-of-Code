package adventOfCode.puzzles.year2022.day09

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import kotlin.math.abs
import kotlin.math.sign

@Year(2022)
@Day(9, 2)
internal class Day09Part2(input: RawInput): Puzzle<Int>(input)  {

    override fun solve(): Int {

        val line = LongLine()
        val steps = steps(input)
        steps.forEach {
            line.move(it)
        }
        return line.tail.coordsWithHistory.history.distinct().count()
    }
}//2376
