package adventOdCode.common

import java.math.BigInteger


// TODO exception rangeOverflow
fun List<Int>.multiply(): BigInteger {
    var result = BigInteger.valueOf(1)
    this.forEach{ result *= it }
    return result
}