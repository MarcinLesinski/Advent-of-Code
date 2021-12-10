package adventOfCode.puzzles.year2021.day09

import adventOfCode.common.Matrix

class PointsBuilder(private val data: Matrix<Int>) {
    private val coordinatesToPoints = mutableMapOf<Cords, Point>()

    fun construct(): List<Point> {
        data.forEachFieldWithCoords { data, col, row ->
            val coords = Cords(row, col)
            val prePoint = Point(data)
            coordinatesToPoints[coords] = prePoint
        }
        coordinatesToPoints.keys.forEach { cords ->
            val point = coordinatesToPoints[cords]!!
            point.left = coordinatesToPoints[cords.left()]
            point.right = coordinatesToPoints[cords.right()]
            point.top = coordinatesToPoints[cords.top()]
            point.bot = coordinatesToPoints[cords.bot()]
        }
        return coordinatesToPoints.values.toList()
    }
}
