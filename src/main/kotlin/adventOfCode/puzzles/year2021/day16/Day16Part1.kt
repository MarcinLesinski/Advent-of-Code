package adventOfCode.puzzles.year2021.day16

import adventOfCode.common.multiplyBy
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import java.math.BigInteger
import java.util.ArrayDeque
import java.util.Stack

@Year(2021)
@Day(16, 1)
internal class Day16Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val mainPackage = Parser(input).parse()
        return mainPackage.versionSum()
    }
}

class Parser(rawData: String) {
    private val process = ArrayDeque<Int>()
    private val data = Data(rawData)
    var tabs = ""
    fun parse(): Package {

        val header = header()

        return when (header.typeId) {
            4 -> {
                literal(header)
            }
            else -> {
                val lengthType = data.get(1).toInt(2)
                when (lengthType) {
                    1 -> { //11
                        package11(header)
                    }
                    0 -> { // 15
                        package15(header)
                    }
                    else -> error("")
                }
            }
        }
    }

    private fun literal(header: Header): Literal {
        var binaryValue = ""
        do {
            val literalParse = literalValue()
            binaryValue += literalParse.value
        } while(literalParse.readNext)
        val literalValue = binaryValue.toLong(2)
        println(tabs + "l")
//        cleanup()
        return Literal(header,  literalValue)
    }

    private fun package11(header: Header): Package {
        process.push(15)
        val subPackages = mutableListOf<Package>()
        val subPackagesCount = data.get(11).toInt(2)
        println(tabs + "p11")
        tabs += '\t'
        repeat(subPackagesCount){
            val subPackage = parse()
            subPackages.add(subPackage)
        }
        cleanup()
        tabs = tabs.dropLast(1)
        process.pop()
        return Package(header, subPackages)
    }

    private fun package15(header: Header): Package {
        process.push(15)
        println(tabs + "p15")
        tabs += '\t'
        val subPackagesLength = data.get(15).toInt(2)
        val initialLength = data.bitsCount
        val subPackages = mutableListOf<Package>()

        do {
            val subPackage = parse()
            val currentLength = data.bitsCount
            subPackages.add(subPackage)
        } while(initialLength - currentLength < subPackagesLength )
        cleanup()
        tabs = tabs.dropLast(1)
        process.pop()
        return Package(header, subPackages)
    }

    private fun header(): Header {
        val version = data.get(3).toInt(2)
        val typeId = data.get(3).toInt(2)
        return Header(version, typeId)
    }

    private fun literalValue(): LiteralParse {
        val readNext = data.get(1).let{ it == "1"}
        val value = data.get(4)
        return LiteralParse(readNext, value)
    }

    private fun cleanup() {
        if (process.first != 15 && process.first != 11)
            this.data.cleanup()
    }
}

data class LiteralParse(val readNext: Boolean, val value: String)

data class Header(val version: Int, val typeId: Int)

open class Package(val header: Header,val subPackages: List<Package>) {
    open fun value(): Long {
        return subPackages.sumBy{it.value().toInt()}.toLong()
    }

    open fun versionSum(): Int = header.version + subPackages.sumBy{it.versionSum()}

    open fun calc(): BigInteger {
        val res : BigInteger = when(header.typeId) {
            0 -> { subPackages.map{it.calc()}.reduce{acc, item -> acc.plus(item)}}
            1 -> { subPackages.map{it.calc()}.reduce{acc, item -> acc.multiply(item)}}
            2 -> {  subPackages.minBy{ it.calc() }!!.calc() }
            3 -> {  subPackages.maxBy{ it.calc() }!!.calc() }
            5 -> { if ( subPackages[0].calc() > subPackages[1].calc() ) BigInteger.ONE else BigInteger.ZERO}
            6 -> {if ( subPackages[0].calc() < subPackages[1].calc() ) BigInteger.ONE else BigInteger.ZERO }
            7 -> {if ( subPackages[0].calc() == subPackages[1].calc() ) BigInteger.ONE else BigInteger.ZERO }
            else -> error("")
        }
        return res
    }
}

class Literal(header: Header, val value: Long): Package(header, listOf()) {
    override fun value() = value
    override fun calc() =  BigInteger(value.toString())
}

class Data(private var data: String) {
    private var rest = ""

    fun get(numberOfBits: Int): String {
        var bits: String
        if (numberOfBits <= rest.length) {
            bits = rest.take(numberOfBits)
            rest = rest.drop(numberOfBits)
        } else {
            val charsNeeded = (numberOfBits - rest.length).div(4) + 1
            bits = rest + data.take(charsNeeded).let(::toBits)
            this.rest = bits.drop(numberOfBits)
            this.data = this.data.drop(charsNeeded)
            bits = bits.take(numberOfBits)
        }
//        println("get($numberOfBits) $data  $rest")
        return bits
    }

    private fun toBits(hex: String): String {
        return hex.toLong(radix = 16).toString(2).padStart(hex.length*4, '0')
    }

        fun cleanup(){
            if (rest.all{it == '0'}) {
                rest = ""
                data.trimStart { it == '0' }
            } else if (rest.isEmpty()) {
                data.trimStart { it == '0' }
            }
        }

    val bitsCount
        get() = data.length * 4 + rest.length
}
