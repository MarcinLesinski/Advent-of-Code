package adventOdCode.domain

import adventOdCode.common.times
import java.math.BigInteger


typealias Input<T> = List<T>
typealias Lines = Input<String>
typealias Numbers = Input<Int>
typealias RawInput = Lines
typealias BitMask = List<Array<Boolean>>

fun Numbers.multiply(): BigInteger {
    var result = BigInteger.valueOf(1)
    this.forEach { result *= it }
    return result
}

fun <T> Input<T>.forEachPair(onPair: (T, T) -> Unit) {
    for (i in 0 until this.size) {
        for (j in i + 1 until this.size) {
            onPair(this[i], this[j])
        }
    }
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

fun RawInput.asNumbers(): Numbers {
    return this.map { it.toInt() }
}

fun RawInput.asBitMask(set: Char, unset: Char): BitMask {
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

fun BitMask.height(): Int{
    return this[0].size
}

fun BitMask.toText(): String{
    var result = ""
    this.forEach {  result += '\n'; it.forEach { result += if(it) '#' else '.'}}
    return result
}
