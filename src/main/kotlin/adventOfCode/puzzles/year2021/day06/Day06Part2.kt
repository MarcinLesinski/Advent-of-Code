package adventOfCode.puzzles.year2021.day06

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year

@Year(2021)
@Day(6, 2)
internal class Day06Part2(input: RawInput) : Puzzle<Long>(input) {
    override fun solve(): Long {
        val ages = input.trim().split(",").map{it.toLong()}
        val agesToCount = ages
            .groupBy { it }
            .map{ it.key to it.value.size.toLong() }

        val simulation = Simulation(agesToCount)
        (1..256).forEach{
            simulation.step()
        }

        return simulation.fishCount()
    }
}
