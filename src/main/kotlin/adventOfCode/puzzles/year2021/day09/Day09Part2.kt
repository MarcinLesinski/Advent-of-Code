package adventOfCode.puzzles.year2021.day09

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asMatrix

@Year(2021)
@Day(9, 2)
internal class Day09Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val data = input.asMatrix { it.toInt() }
        val points = PointsBuilder(data).construct()
        return points.filter { it.low }.map(::Basin).map{it.size}.sorted().takeLast(3).reduce{acc, item-> acc*item}
    }
}

class Basin(private val point: Point){
    val size: Int
    get() = scan(point)

    private fun scan(point: Point?): Int {
        return when{
            point == null ->{ 0 }
            point.edge -> { 0 }
            point.inspected -> { 0}
            else -> {
                point.inspected = true
                scan(point.left) + scan(point.right) + scan(point.top) + scan(point.bot) + 1
            }
        }
    }
}

