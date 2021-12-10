package adventOfCode.puzzles.year2021.day05

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines

@Year(2021)
@Day(5, 1)
internal class Day05Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val lines = input
            .asLines()
            .map { it.split(",", " -> ") }
            .map { Line(Point(it[0].toInt(), it[1].toInt()), Point(it[2].toInt(), it[3].toInt())) }
            .filter { it.orthogonal }
        val board = Board()
        lines.forEach {
            board.draw(it)
        }

        return board.countXOrMore(2)
    }
}
