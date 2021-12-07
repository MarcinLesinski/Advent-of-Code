package adventOfCode.common

import java.util.stream.Collectors

class Matrix<T>(
    val width: Int,
    val height: Int,
    private val rows: Array<Array<T>>
) {
    operator fun get(x: Int, y: Int): T = rows[y][x]

    fun toText(): String {
        var result = ""
        rows.forEach {
            result += '\n';
            it.forEach {
                result += it.toString() + " "
            }
        }
        return result
    }

    fun forEachField(block: (T) -> Unit) {
        rows.flatten().forEach(block)
    }

    fun fields() = rows.flatten()

    fun columns() = (0 until width).map { column ->
            rows.map { it[column] }
        }

    fun rows() = rows

    fun forEachColumn(block: (List<T>) -> Unit) {
        for (row in 0 until width) {
            block(rows.map { it[row] })
        }
    }

    fun forEachRow(block: (Array<T>) -> Unit) {
        rows.forEach(block)
    }

    fun filterFields(block: (T) -> Boolean): List<T> {
        return rows.flatten().filter(block)
    }

    fun indices(block: (x: Int, y: Int) -> Unit) {
        for (y in rows.indices) {
            for (x in rows[y].indices) {
                block(x, y)
            }
        }
    }
}

inline fun <reified T> Matrix(width: Int, height: Int, initialValue: T): Matrix<T> {
    val initCell = { _: Int -> initialValue }
    val initRow: (Int) -> Array<T> = { i: Int -> Array(width, initCell) }
    val fields = Array(height, initRow)
    return Matrix(width, height, fields)
}

inline fun <reified T> Matrix(height: Int, noinline initRow: (Int) -> Array<T>): Matrix<T> {
    val fields = Array(height, initRow)
    val width = fields[0].size
    return Matrix(width, height, fields)
}

inline fun <reified T> Matrix(rawMatrix: List<List<T>>): Matrix<T> {
    val height = rawMatrix.size
    val width = rawMatrix[0].size
    val rawMatrixAsArrays = rawMatrix.map{ it.toTypedArray() }.toTypedArray()
    return Matrix(width, height, rawMatrixAsArrays)
}
