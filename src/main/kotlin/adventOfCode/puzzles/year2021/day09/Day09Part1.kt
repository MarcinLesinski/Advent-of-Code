package adventOfCode.puzzles.year2021.day09

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asMatrix

@Year(2021)
@Day(9, 1)
internal class Day09Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val data = input.asMatrix { it.toInt() }
        val points = PointsBuilder(data).construct()
        return points.filter { it.low }.map { it.value + 1 }.sum()
    }
}
