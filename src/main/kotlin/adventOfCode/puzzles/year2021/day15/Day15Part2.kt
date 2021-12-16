package adventOfCode.puzzles.year2021.day15

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asMatrix
import adventOfCode.domain.asNumbers
import adventOfCode.domain.split
import java.math.BigInteger
import java.util.PriorityQueue

@Year(2021)
@Day(15, 2)
internal class Day15Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val cave = input.asMatrix { it.toInt() }
        val cave5x5 = spreadCave(cave)
        val factory = Factory(cave5x5)
        factory.construct()
        gend = factory.end
        factory.start.run(0 )//, setOf())
        return factory.end.minimalRisk
    }
}

fun spreadCave(cave0: Matrix<Int>): Matrix<Int> {
    val inc = { data: Int, col: Int, row: Int ->
        if (data == 9) 1 else (data + 1)
    }
    val caves = mutableMapOf<Int, Matrix<Int>>()
    caves[0] = cave0
    caves[1] = caves[0]!!.mapWithCoords(inc)
    caves[2] = caves[1]!!.mapWithCoords(inc)
    caves[3] = caves[2]!!.mapWithCoords(inc)
    caves[4] = caves[3]!!.mapWithCoords(inc)
    caves[5] = caves[4]!!.mapWithCoords(inc)
    caves[6] = caves[5]!!.mapWithCoords(inc)
    caves[7] = caves[6]!!.mapWithCoords(inc)
    caves[8] = caves[7]!!.mapWithCoords(inc)

    val oWidth = cave0.width
    val oHeight = cave0.height
    val cave5x5 = Matrix( oWidth * 5, oHeight * 5, 0)
    return cave5x5.mapWithCoords { data, col, row ->
        val c = col.div(oWidth)
        val r = row.div(oHeight)
        val cave =  caves[c+r]!!
        cave[col.rem(oWidth), row.rem(oHeight)]
    }
}
