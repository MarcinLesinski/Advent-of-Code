package adventOfCode.puzzles.year2021.day13

import adventOfCode.common.Matrix
import kotlin.math.max

class Paper(private var points: Matrix<Boolean>) {
    fun foldHorizontal(foldRow: Int) {
        println("y: " + foldRow)
        if ( foldRow < (points.height / 2) )
        {
            error("")
        }
        // up
        val newPoints = Matrix(points.width, foldRow, false)
        newPoints.forEachFieldWithCoords { data, col, row ->
            val delta = (points.height - 1) - foldRow
            val overlap = ( (foldRow - delta) <= row )
            newPoints[col, row] = if ( overlap ) {
                val distanceToFoldLine = (foldRow - row)
                points[col, row] || points[col, foldRow + distanceToFoldLine]
            } else
            {
                points[col, row]
            }
        }
        this.points = newPoints
    }

    fun foldVertical(foldCol: Int) {
        println("x: " + foldCol)
        if ( foldCol < (points.width / 2) )
        {
            error("")
        }
        val newPoints = Matrix(foldCol, points.height, false)
        newPoints.forEachFieldWithCoords { data, col, row ->
            val delta = (points.width - 1) - foldCol
            val overlap = ( (foldCol - delta) <= col )
            newPoints[col, row] = if ( overlap ) {
                val distanceToFoldLine = (foldCol - col)
                points[col, row] || points[foldCol + distanceToFoldLine, row]
            } else
            {
                points[col, row]
            }
        }
        this.points = newPoints
    }

    fun dots(): Int = points.count { it }

    fun drow() {
        points.print {
            if(it) "#" else "."
        }
    }
}

class PaperFactory(private val points: List<String>) {
    fun construct(): Paper {
        var maxRow = 0
        var maxCol = 0
        val coords = points.map {
            val  (colText, rowText) = it.split(",")
            val row = rowText.toInt()
            val col = colText.toInt()
            maxRow = max(maxRow, row)
            maxCol = max(maxCol, col)
            row to col
        }
        val data = Matrix(maxCol + 1, maxRow + 1, false)
        coords.forEach {
            val row = it.first
            val col = it.second
            data[col, row] = true
        }

        return Paper(data)
    }
}

sealed class Fold(val line: Int)
class VerticalFold(line: Int) : Fold(line)
class HorizontalFold(line: Int) : Fold(line)

class FoldsFactory(private val data: List<String>) {
    fun construct(): List<Fold> {
        return data.map {
            val (axisText, lineText) = it.drop(11).split("=")
            return@map when (axisText) {
                "x" -> {
                    VerticalFold(lineText.toInt())
                }
                "y" -> {
                    HorizontalFold(lineText.toInt())
                }
                else -> error("")
            }
        }
    }
}
