package adventOfCode.common

import java.math.BigInteger

//region "BigInteger"
operator fun BigInteger.times(value: Int): BigInteger {
    val valueAsBigInteger = BigInteger.valueOf(value.toLong())
    return this.multiply(valueAsBigInteger)
}
//endregion

//region "List<T>"
fun <T> List<T>.multiplyBy(factor: (T) -> Long): Long {
    var result = 1L
    for (item in this) {
        result *= factor(item)
    }
    return result
}

//region List<Int>
fun List<Int>.multiply(): BigInteger {
    var result = BigInteger.valueOf(1)
    this.forEach { result *= it }
    return result
}

/**  It return new List with removed item at given index  */
fun <T> List<T>.withRemovedAt(index: Int): List<T> {
    return this.filterIndexed{i, _ -> i != index }
}
//endregion

//region List<Int>
fun List<Long>.unique(): Boolean {
    return size == distinct().size
}

fun List<Long>.sumsTo(value: Long): Boolean {
    return sum() == value
}
//endregion
//endregion

//region Array<T>
fun <T> Array<T>.multiplyBy(factor: (T) -> Long): Long {
    var result = 1L
    for (item in this) {
        result *= factor(item)
    }
    return result
}

//endregion

//region Iterable<T>
inline fun <T> Iterable<T>.sumByLong(selector: (T) -> Long): Long {
    var sum = 0L
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

inline fun Iterable<Long>.sum(): Long {
    var sum = 0L
    for (element in this) {
        sum += element
    }
    return sum
}
//endregion

fun <T> commonItems(vararg lists: List<T>): List<T> {
    return lists
        .toList()
        .fold(listOf()) { acc: List<T>, ts: List<T> ->
            if (acc.isEmpty()) return@fold ts
            val res = mutableListOf<T>()
            acc.forEach { a ->
                if (ts.contains(a)) res.add(a)
            }
            res
        }
}

fun ClosedRange<Int>.fullyContains(that: ClosedRange<Int>): Boolean {
    return ((that.start >= this.start) and (that.endInclusive <= this.endInclusive))
}

fun ClosedRange<Int>.hasCommonPartWith(that: ClosedRange<Int>): Boolean {
    return ((this.start >= that.start) and (this.start <= that.endInclusive)) or

            ((this.endInclusive >= that.start) and (this.endInclusive <= that.endInclusive)) or

            ((that.start >= this.start) and (that.start <= this.endInclusive)) or

            ((that.endInclusive >= this.start) and (that.endInclusive <= this.endInclusive))
}
