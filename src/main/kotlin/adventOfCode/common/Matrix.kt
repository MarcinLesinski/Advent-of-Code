package adventOfCode.common

class Matrix<T>(
    val width: Int,
    val height: Int,
    private val rows: Array<Array<T>>
) {
    operator fun get(x: Int, y: Int): T = rows[y][x]
    operator fun set(x: Int, y: Int, data: T) = rows[y][x] == data

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

    fun forEachFieldWithCoords(block: (data:T, col: Int, row: Int) -> Unit) {
        rows.forEachIndexed{ row, rowData ->
            rowData.forEachIndexed{col, data ->
                block(data, col, row)
            }
        }
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
//
//    inline fun <reified R> map(crossinline block: (T)->R): Matrix<R> {
//
//        return Matrix(this.width, this.height )
//        val result = Matrix(this.width, this.height,  )
//        this.forEachFieldWithCoords{data, col, row ->
//            result[col, row] = block(data)
//        }
//        return result
//    }

   inline fun <reified R> mapWithCoords(noinline  block: (data:T, col:Int, row:Int)->R): Matrix<R> {
        return Matrix(this.width, this.height){ col, row ->
            block(this[col, row], col, row)
        }
    }

    fun sumBy(block: (T) -> Int): Int{
        var sum = 0
        this.forEachField {
            sum += block(it)
        }
        return sum
    }

    fun count(predicate: (T) -> Boolean ): Int {
        var count = 0
        forEachField {
            if (predicate(it)) count += 1
        }
        return count
    }

    fun print(block: (T)-> String){
        this.forEachRow {
            it.forEach { print(block(it)) }
            println()
        }
    }
}

inline fun <reified T> Matrix(width: Int, height: Int, initialValue: T): Matrix<T> {
    val initCell = { _: Int -> initialValue }
    val initRow: (Int) -> Array<T> = { i: Int -> Array(width, initCell) }
    val fields = Array(height, initRow)
    return Matrix(width, height, fields)
}

inline fun <reified T> Matrix(width: Int, height: Int, initialCell: (col:Int, row: Int) -> T): Matrix<T> {
    val data =  mutableListOf<Array<T>>()
    for (row in 0 until  height) {
        val rowData = mutableListOf<T>()
        for (col in 0 until width) {
            rowData.add( initialCell(col, row))
        }
        data.add(rowData.toTypedArray())
    }

    return Matrix(width, height, data.toTypedArray())
}

inline fun <reified T> Matrix(width: Int, height: Int, initialCell: () -> T): Matrix<T> {
    val data =  mutableListOf<Array<T>>()
    for (row in 0 until  height) {
        val rowData = mutableListOf<T>()
        for (col in 0 until width) {
            rowData.add( initialCell())
        }
        data.add(rowData.toTypedArray())
    }

    return Matrix(width, height, data.toTypedArray())
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
