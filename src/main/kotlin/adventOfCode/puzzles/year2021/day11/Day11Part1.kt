package adventOfCode.puzzles.year2021.day11

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asMatrix

@Year(2021)
@Day(11, 1)
internal class Day11Part1(input: RawInput) : Puzzle<Int>(input) {
    private var explosions = 0
    override fun solve(): Int {

        val data = input.asMatrix { it.toInt() }
        val shrooms = ShroomsFactory(data, ::onExplode).construct()

        repeat(100) {
            shrooms.forEachField { it.passiveIncEnergy() }
            shrooms.forEachField { it.symulate() }
            shrooms.forEachField { it.claim() }
            println()
            println()
            shrooms.print {
                it.energy.toString()
            }
        }
        return explosions
    }

    private fun onExplode() {
        explosions += 1
    }
}

