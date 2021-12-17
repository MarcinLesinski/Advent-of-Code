package adventOfCode.puzzles.year2021.day16

import adventOfCode.common.DataReader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class Day16Part1Test {

    @Test
    fun D2FE28() {
        val actual = Parser("D2FE28").parse()
        assert(actual.header.version == 6)
        assert(actual.header.typeId == 4)
        assert(actual.value() == 2021L)
        assert(actual.versionSum() == 6)
    }

    @Test
    fun `38006F45291200`() {
        val actual = Parser("38006F45291200").parse()
        assert( actual.header.version == 1 )
        assert( actual.header.typeId == 6 )
        assert( actual.subPackages.size == 2 )
        assert( actual.value() == 30L )
        assert(actual.versionSum() == 9)
    }

    @Test
    fun `EE00D40C823060`() {
        val actual = Parser("EE00D40C823060").parse()
        assert(actual.header.version == 7)
        assert(actual.header.typeId == 3)
        assert(actual.subPackages.size == 3)
        assert(actual.value() == 6L)
        assert(actual.versionSum() == 14)
    }

    @Test
    fun `8A004A801A8002F478`(){
        val actual = Parser("8A004A801A8002F478").parse()
        assert( actual.versionSum() == 16 )
    }

    @Test
    fun `620080001611562C8802118E34`() {
        val actual = Parser("620080001611562C8802118E34").parse()
        assert( actual.header.version == 3 )
        assert( actual.subPackages.size == 2 )
        assert( actual.versionSum() == 12 )
    }

    @Test
    fun `C0015000016115A2E0802F182340`(){
        val actual = Parser("C0015000016115A2E0802F182340").parse()
        assert( actual.versionSum() == 23 )
    }

    @Test
    fun `A0016C880162017C3686B18A3D4780`(){
        val actual = Parser("A0016C880162017C3686B18A3D4780").parse()
        assert( actual.versionSum() == 31 )
    }
}
