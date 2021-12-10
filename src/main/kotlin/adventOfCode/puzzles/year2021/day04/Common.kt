package adventOfCode.puzzles.year2021.day04

import adventOfCode.common.Matrix
import adventOfCode.domain.RawInput
import adventOfCode.domain.asLines

class Board(
    private val number: Int,
    private val fields: Matrix<Field>
) {
    private var _won = false
    val won: Boolean get() = _won

    private var _score = 0
    val score get() = _score

    fun mark(number: Int) {
        fields
            .filterFields { !it.checked }
            .filter { it.value == number }
            .forEach { it.checked = true }
        check(number)
    }

    private fun check(currentNumber: Int) {
        val win =
            fields.columns().any { column ->
                column.all { it.checked }
            } || fields.rows().any { row ->
                row.all { it.checked }
            }

        if (win) {
            val score = fields.fields().filter { !it.checked }.sumBy { it.value } * currentNumber
            _won = true
            _score = score
        }
    }
}

class Field(val value: Int, var checked: Boolean = false)

fun readBoards(input: RawInput): List<Board> {
    val width = 5
    val height = 5
    val matrices = input
        .asLines()
        .drop(1)
        .windowed(6, 6)
        .map{
            val rawMatrix = it.drop(1).map{ line ->
                line
                    .split(Regex("[ \t]+")).filter { nn ->nn.isNotEmpty() }
                    .map(String::toInt)
                    .map{number->
                        Field(number, false)
                    }
            }
            Matrix(rawMatrix)
        }

    return matrices.mapIndexed{ index, matrix ->
        Board(index, matrix)
    }
}
