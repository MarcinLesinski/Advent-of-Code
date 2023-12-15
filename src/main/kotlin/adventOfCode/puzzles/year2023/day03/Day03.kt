package adventOfCode.puzzles.year2023.day03

import adventOfCode.common.multiplyBy
import adventOfCode.domain.*
import kotlin.math.abs

@Year(2023)
@Day(3, 1)
internal class Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val numbers = input.asLines().mapIndexed{ row, line ->
            extractNumbers(line, row.toLong())
        }.flatten()

        val parts = input.asLines().mapIndexed{ row, line ->
            extractSigns(line, row.toLong())
        }.flatten()

        return numbers.filter { it.hasSign(parts) }.sumOf { it.value }.toInt()
    }
}


@Year(2023)
@Day(3, 2)
internal class Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val numbers = input.asLines().mapIndexed{ row, line ->
            extractNumbers(line, row.toLong())
        }.flatten()

        val parts = input.asLines().mapIndexed{ row, line ->
            extractParts(line, row.toLong())
        }.flatten()

        return parts.map{it.ratio(numbers)} .sum().toInt()
    }

}

data class Number(
    val value: Long,
    val cells: List<Point>
) {
    fun hasSign(parts: List<Part>): Boolean {
        val result = cells.any{ numberPoint ->
            parts.any{ it.cell.areNeighbours(numberPoint) }
        }
        return result
    }
}

data class Part(
    val value: String,
    val cell: Point
) {
    fun ratio(numbers: List<Number>): Long {
        val labels = numbers.filter{it.hasSign(listOf(this))}
        if (labels.size != 2) return 0

        return labels.multiplyBy { it.value }
    }
}


data class Point(
    val row: Long,
    val col: Long
) {
    fun areNeighbours( other: Point ): Boolean {
        val dr = abs(this.row - other.row)
        val dc = abs(this.col - other.col)
        val diagonal = (dr == 1L) and (dc == 1L)
        val sameRow = (dr == 0L) and (dc == 1L)
        val sameCol = (dr == 1L) and (dc == 0L)
        return diagonal or sameRow or sameCol
    }
}

data class RawCell(
    val char: String,
    val cords: Point
)


fun extractParts(line: String, row: Long): List<Part> {
    val result = mutableListOf<Part>()
    line.forEachIndexed{ col, char ->
        if((char.toString() == "*")) {
            result.add(Part(char.toString(), Point(row, col.toLong())))
        }
    }
    return result
}

fun extractSigns(line: String, row: Long): List<Part> {
    val result = mutableListOf<Part>()
    line.forEachIndexed{ col, char ->
        if((char.isDigit().not()) and (char.toString() != ".")) {
            result.add(Part(char.toString(), Point(row, col.toLong())))
        }
    }
    return result
}

fun extractNumbers(line: String, row: Long): List<Number>{
    var numberAsText = ""
    val points = mutableListOf<Point>()
    val result = mutableListOf<Number>()
    line.forEachIndexed{ col, char ->
        if(char.isDigit()) {
            numberAsText += char.toString()
            points.add(Point(row, col.toLong()))
        } else if(points.isEmpty().not()) {
            result.add(Number(numberAsText.toLong(), ArrayList(points)))
            numberAsText = ""
            points.clear()
        }
    }

    if(points.isEmpty().not()) {
        result.add(Number(numberAsText.toLong(), ArrayList(points)))
    }
    return result
}