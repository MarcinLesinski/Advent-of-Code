package adventOfCode.common

import java.math.BigInteger

operator fun BigInteger.times(value: Int): BigInteger{
    val valueAsBigInteger = BigInteger.valueOf(value.toLong())
    return this.multiply(valueAsBigInteger)
}