package adventOfCode.puzzles.year2021.day08

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines

@Year(2021)
@Day(8, 2)
internal class Day08Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val segments = input.asLines().map { line ->
            line.split(" | ").map { section ->
                section.split(" ")
            }
        }
        val sum = mutableListOf<Int>()
        segments.forEach{
            val specification = it[0]
            val codes = it[1]
            val decoder = Decoder(specification)
            val res = codes.map{decoder.decode(it)}.map{it.toString()}.reduce{acc, item ->
                acc+item
            }.toInt()
            sum.add(res)
        }

        return sum.sum()
    }
}

class Decoder(private val candidates: List<String>) {
    private val one = one()
    private val four = four()
    private val seven = seven()
    private val eight = eight()
    private val three = three(one)
    private val nine = nine(three)
    private val six = six(one)
    private val zero = zero(six, nine)
    private val five = five(six)
    private val two = two(five, three)
    private val digits = listOf(zero, one, two, three, four, five, six, seven, eight, nine)

    fun decode(code: String): Int {
        return digits.first{ it.same(code) }.value
    }

    private fun one(): Digit = Digit(1, candidates.first { it.length == 2 })
    private fun four(): Digit = Digit(4, candidates.first { it.length == 4 })
    private fun seven(): Digit = Digit(7, candidates.first { it.length == 3 })
    private fun eight(): Digit = Digit(8, candidates.first { it.length == 7 })
    private fun three(one: Digit): Digit {
        val code = candidates.filter { it.length == 5 }.first { one.isAPartOf(it) }
        return Digit(3, code)
    }

    private fun nine(three: Digit): Digit {
        val code = candidates.filter { it.length == 6 }.first { three.isAPartOf(it) }
        return Digit(9, code)
    }

    private fun six(one: Digit): Digit {
        val code = candidates.filter { it.length == 6 }.first{!one.isAPartOf(it)}
        return Digit(6, code)
    }

    private fun zero(six: Digit, nine: Digit): Digit {
        val code = candidates.filter { it.length == 6 }.filter { !six.same(it) }.filter{!nine.same(it)}.first()
        return Digit(0, code)
    }

    private fun five(six: Digit): Digit {
        val rightTop = six.reverse().first()
        val code = candidates.filter { it.length == 5 }.first{!it.contains(rightTop) }
        return Digit(5, code)
    }

    private fun two(five: Digit, three: Digit): Digit {
        val code = candidates.filter { it.length == 5 }.filter { !five.same(it) }.filter { !three.same(it) }.first()
        return Digit(2, code)
    }
}

class Digit(val value: Int, val code: String) {
    private val allSegments = setOf("a", "b", "c", "d", "e", "f", "g")
    fun contains(digitCode: String): Boolean {
        return digitCode.all {
            code.contains(it)
        }
    }

    fun isAPartOf(digitCode: String): Boolean {
        return code.all {
            digitCode.contains(it)
        }
    }

    fun same(digitCode: String): Boolean {
        return code.all {
            digitCode.contains(it)
        } && digitCode.all {
            code.contains(it)
        }
    }

    fun reverse(): List<String> {
        return allSegments.filter {
            !code.contains(it)
        }
    }
}
