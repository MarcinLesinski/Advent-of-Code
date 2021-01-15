package adventOfCode.common

import java.math.BigInteger

fun List<Int>.multiply(): BigInteger {
    var result = BigInteger.valueOf(1)
    this.forEach{ result *= it }
    return result
}