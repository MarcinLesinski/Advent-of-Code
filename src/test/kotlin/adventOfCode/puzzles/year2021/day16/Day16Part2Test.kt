package adventOfCode.puzzles.year2021.day16

import adventOfCode.common.DataReader
import java.math.BigInteger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day16Part2Test {

    @Test
    fun `C200B40A82`() {
        val actual = Parser("C200B40A82").parse()
        assert(actual.calc() == 3L)
    }

       @Test
    fun `04005AC33890`() {
        val actual = Parser("04005AC33890").parse().calc()
        assert(actual == 54L)
    }

    @Test
    fun `880086C3E88112`() {
        val actual = Parser("880086C3E88112").parse().calc()
        assert(actual == 7L)
    }

    @Test
    fun `CE00C43D881120`() {
        val actual = Parser("CE00C43D881120").parse().calc()
        assert(actual == 9L)
    }

    @Test
    fun `D8005AC2A8F0`() {
        val actual = Parser("D8005AC2A8F0").parse().calc()
        assert(actual == 1L)
    }

    @Test
    fun `F600BC2D8F`() {
        val actual = Parser("F600BC2D8F").parse().calc()
        assert(actual == 0L)
    }

    @Test
    fun `9C005AC2F8F0`() {
        val actual = Parser("9C005AC2F8F0").parse().calc()
        assert(actual == 0L)
    }

    @Test
    fun `9C0141080250320F1802104A08`() {
        val actual = Parser("9C0141080250320F1802104A08").parse().calc()
        assert(actual == 1L)
    }
}
