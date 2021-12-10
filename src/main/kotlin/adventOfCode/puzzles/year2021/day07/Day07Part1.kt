package adventOfCode.puzzles.year2021.day07

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import kotlin.math.absoluteValue

@Year(2021)
@Day(7, 1)
internal class Day07Part1(input: RawInput) : Puzzle<Int>(input) {
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

    fun calcFuelConsumption(level: Int, levels: List<Int> ): Int {
        return levels.map{ (it-level).absoluteValue }.sum()
    }

}


