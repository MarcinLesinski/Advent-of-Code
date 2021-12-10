package adventOfCode.domain

import adventOfCode.common.Matrix
import adventOfCode.common.times
import java.math.BigInteger


typealias Input<T> = List<T>
typealias Lines = Input<Line>
typealias Line = String
typealias Numbers = Input<Int>
typealias PositiveNumbers = Input<Long>
typealias RawInput = String
typealias BitMask = List<Array<Boolean>>

//region RawInput
fun RawInput.asNumbers(): Numbers{
    return this
        .trim()
        .lines()
        .asNumbers()
}

fun RawInput.asLines(): Lines{
    return this
        .trim()
        .lines()
}

inline fun <reified T> RawInput.asMatrix(separator: String = "",  convertData: (rawData:String)-> T): Matrix<T> {
    val rawMatrix = this.asLines().map{
        val rowOfData = if (separator == "")
            it.map { ch -> ch.toString() }
        else
            it.split(separator)

        rowOfData.map(convertData)
    }

    return Matrix(rawMatrix)
}

//endregion

fun Numbers.multiply(): BigInteger {
    var result = BigInteger.valueOf(1)
    this.forEach { result *= it }
    return result
}

//region Input<T>
fun <T> Input<T>.forEachPair(onPair: (T, T) -> Unit) {
    for (i in this.indices) {
        for (j in i + 1 until this.size) {
            onPair(this[i], this[j])
        }
    }
}

fun <T> Input<T>.pairs(): List<List<T>>{
    val result = mutableListOf<List<T>>()
    forEachPair{ a, b -> result.add(listOf(a, b)) }
    return result
}

fun <T> Input<T>.forEachSubset(subsetLength: Int, onSubset: (subset: List<T>) -> Unit) {
    val dataSize = this.size
    val indices = arrayOfNulls<Int>(subsetLength)

    fun step(startIndex: Int, level: Int) {
        if (level == 0) {
            return
        }

        for (i in startIndex until dataSize) {
            indices[level - 1] = i
            step(i + 1, level - 1)
            if (level == 1) {
                onSubset(indices.map { i -> this.get(i!!) })
            }
        }

    }
    step(0, subsetLength)
}

fun <T> Input<T>.splitBy(selector: (T) -> Boolean): Array<List<T>> {
    val result = mutableListOf(mutableListOf<T>())
    val emptyGroup = {mutableListOf<T>()}

    fold(result) { groups, item ->
        if (selector(item))
            groups.add(emptyGroup())
        else
            groups.last().add(item)
        groups
    }

    return result.toTypedArray()
}

//endregion

fun Lines.asNumbers(): Numbers {
    return this.map { it.toInt() }
}

fun Lines.asBitMask(set: Char, unset: Char): BitMask {
    return this.map { line ->
        line.map { char ->
            when (char) {
                set -> {
                    true
                }
                unset -> {
                    false
                }
                else -> {
                    error("invalid char: $char")
                }
            }
        }.toTypedArray()
    }
}

fun Line.split(): List<String> = this.split(Regex("[ \t]+"))

fun BitMask.height(): Int{
    return this[0].size
}

fun BitMask.toText(): String{
    var result = ""
    this.forEach {  result += '\n'; it.forEach { result += if(it) '#' else '.'}}
    return result
}
