package adventOfCode.puzzles.year2021.day15

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asMatrix
import kotlin.math.min

@Year(2021)
@Day(15, 1)
internal class Day15Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val points = input.asMatrix { it.toInt() }
        val factory = Factory(points)
        factory.construct()
        gend = factory.end
        factory.start.run(0 )//, setOf())
        return factory.end.minimalRisk
    }
}
lateinit var gend: EndPoint
class Factory(private val data: Matrix<Int>) {
    lateinit var start: StartPoint
    lateinit var end: EndPoint

    fun construct() {
        val randomPathRisk = data.columns()[0].sum() + data.rows()[0].sum()
        val points = data.mapWithCoords { value, col, row ->
            when {
                col == 0 && row == 0 -> {
                    start = StartPoint("$col-$row")
                    start
                }
                col == data.width - 1 && row == data.height - 1 -> {
                    end = EndPoint(value, "$col-$row", randomPathRisk)
                    end
                }
                else -> Point(value, "$col-$row")
            }
        }

        points.forEachFieldWithCoords { point, col, row ->

            val right = if (col < points.width - 1) points[col + 1, row] else null
            val bottom = if (row < points.height - 1) points[col, row + 1] else null
            val left = if (col > 0) points[col - 1, row] else null
            val up = if (row > 0) points[col, row - 1] else null
            point.addNode(right)
            point.addNode(left)
//            if ((row == 1 && col == 0).not())
            point.addNode(bottom)
            point.addNode(up)

//            if ((row == 0 && col ==1).not())
        }
    }
}

open class Point(val risk: Int, val name: String) {
    var minIn = Int.MAX_VALUE
    private val nodes = mutableListOf<Point>()
    open fun run(riskSum: Int) {
        if (riskSum + risk >= gend.minimalRisk) return
        if (riskSum < minIn) {
            minIn = riskSum
                nodes.forEach { it.run(riskSum + risk) }
        }
    }

    fun addNode(point: Point?) {
        point?.run(nodes::add)
    }
}

class StartPoint(name: String) : Point(0, name)

class EndPoint(risk: Int, name: String, private val max: Int) : Point(risk, name) {
    var minimalRisk = max
    override fun run(riskSum: Int) {
        minimalRisk = min(riskSum + risk, minimalRisk)
    }
}
