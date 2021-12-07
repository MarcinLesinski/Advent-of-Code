package adventOfCode.puzzles.year2021.day05

import kotlin.math.max
import kotlin.math.min

class Line(val start: Point, val end: Point) {
    val orthogonal get() = start.orthogonalWith(end)
    val points: List<Point> by lazy {
        val list = mutableListOf<Point>()

        if (this.orthogonal) {
            drawOrthogonal(list)
        } else {
            drawDiagonal(list)
        }

        list
    }

    private fun drawOrthogonal(list: MutableList<Point>) {
        val lowerX = min(start.x, end.x)
        val higherX = max(start.x, end.x)
        val lowerY = min(start.y, end.y)
        val higherY = max(start.y, end.y)

        for (x in lowerX..higherX) {
            for (y in lowerY..higherY) {
                list.add(Point(x, y))
            }
        }
    }

    private fun drawDiagonal(list: MutableList<Point>) {
        val modifyX = if (start.x < end.x) ::inc else ::dec
        val modifyY = if (start.y < end.y) ::inc else ::dec

        var x = start.x
        var y = start.y
        do {
            val point = Point(x, y)
            list.add(point)
            x = modifyX(x)
            y = modifyY(y)
        } while (point.x != end.x || point.y != end.y)
    }

    private fun inc(coordinate: Int): Int = coordinate + 1
    private fun dec(coordinate: Int): Int = coordinate - 1
}

data class Point(val x: Int, val y: Int) {
    fun orthogonalWith(point: Point): Boolean {
        return x == point.x || y == point.y
    }
}

class Board {
    private val points = mutableMapOf<Point, Int>()
    fun draw(line: Line) {
        line.points.forEach {
            if (points.contains(it)) {
                val count = points[it]!!
                points[it] = count + 1
            } else {
                points[it] = 1
            }
        }
    }

    fun countXOrMore(x: Int): Int {
        return points.values.count { it >= x }
    }
}
