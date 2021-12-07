package adventOfCode.puzzles.year2021.day03

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asBitMask
import adventOfCode.domain.asLines

@Year(2021)
@Day(3, 2)
internal class Day03Part2(input: RawInput) : Puzzle<Int>(input) {

    private val bits = input.asLines().asBitMask('1', '0').map { Bits(it, false) }

    override fun solve(): Int {
        val oxygenGeneratorRating = oxygenGeneratorRating(bits)
        resetBits()
        val cO2ScrubberRating = cO2ScrubberRating(bits)
        return oxygenGeneratorRating * cO2ScrubberRating
    }

    private fun oxygenGeneratorRating(bits: List<Bits>): Int {
        val length = bits[0].bits.size
        for (column in 0 until length) {
            val groups = bits.filter { !it.excluded }.map { it.bits[column] }.partition { it }
            val mostCommonBt = if (groups.first.size > groups.second.size) {
                true
            } else groups.first.size == groups.second.size
            excludeBits(column, !mostCommonBt)
            if (notExcludedBitsCount() == 1) break
        }

        return getFinalBits()
    }

    private fun cO2ScrubberRating(bits: List<Bits>): Int {
        val length = bits[0].bits.size
        for (column in 0 until length) {
            val groups = bits.filter { !it.excluded }.map { it.bits[column] }.partition { it }
            val leastCommonBt = if (groups.first.size > groups.second.size) {
                false
            } else groups.first.size < groups.second.size
            excludeBits(column, !leastCommonBt)
            if (notExcludedBitsCount() == 1) break
        }

        return getFinalBits()
    }

    private fun notExcludedBitsCount(): Int = bits.filter{!it.excluded}.size

    private fun excludeBits(column: Int, bit: Boolean) {
        bits.filter{!it.excluded}. filter { it.bits[column] == bit }.forEach { it.excluded = true }
    }

    private fun resetBits() {
        bits.forEach { it.excluded = false }
    }

    private fun getFinalBits(): Int {
        assert(bits.filter { !it.excluded }.size == 1)
        val finalBits = bits.first { !it.excluded }.bits
        val value = finalBits.joinToString("") {
            if (it) "1" else "0"
        }.let {
            Integer.parseInt(it, 2)
        }
        return value
    }
}

class Bits(val bits: Array<Boolean>, var excluded: Boolean)
