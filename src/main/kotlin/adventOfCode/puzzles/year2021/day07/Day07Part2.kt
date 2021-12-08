package adventOfCode.puzzles.year2021.day07

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@Year(2021)
@Day(7, 2)
internal class Day07Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val levels = input.trim().split(",").map{it.toInt()}
        val min = levels.min()!!
        val max = levels.max()!!
        val results = mutableMapOf<Int, Int>()
        for (level in min..max) {
            val fuelConsumption = calcFuelConsumption(level, levels)
            results[level] = fuelConsumption
        }

        return results.values.min()!!
    }

    private fun calcFuelConsumption(level: Int, levels: List<Int> ): Int {
        return levels.map{ sumPreviousNumbers( (it-level).absoluteValue) }.sum()
    }

    private fun sumPreviousNumbers(number: Int): Int{
        return (((1 + number)/2.0) * number).roundToInt()
    }
}


