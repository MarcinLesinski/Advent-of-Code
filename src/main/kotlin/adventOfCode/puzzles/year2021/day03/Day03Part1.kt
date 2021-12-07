package adventOfCode.puzzles.year2021.day03

import adventOfCode.domain.BitMask
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asBitMask
import adventOfCode.domain.asLines

@Year(2021)
@Day(3, 1)
internal class Day03Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val bits = input.asLines().asBitMask('1', '0')
        val gamma = gamma(bits)
        val epsilon = epsilon(bits)
        return gamma * epsilon
    }

    private fun gamma(bits: BitMask): Int {
        val length = bits[0].size
        var binary = ""
        for (column in 0 until length) {
            val groups = bits.map { it[column] }.partition { it }
            binary += if (groups.first.size > groups.second.size) {
                "1"
            } else {
                "0"
            }
        }
        return Integer.parseInt(binary, 2)
    }

    private fun epsilon(bits: BitMask): Int {
        val length = bits[0].size
        var binary = ""
        for (column in 0 until length) {
            val groups = bits.map { it[column] }.partition { it }
            binary += if (groups.first.size < groups.second.size) {
                "1"
            } else {
                "0"
            }
        }
        return Integer.parseInt(binary, 2)
    }
}
