package adventOfCode.puzzles.year2021.day11

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asMatrix
import java.util.ArrayDeque

@Year(2021)
@Day(11, 2)
internal class Day11Part2(input: RawInput) : Puzzle<Int>(input) {
    private var explosions = 0
    override fun solve(): Int {

        val data = input.asMatrix { it.toInt() }
        val shrooms = ShroomsFactory(data, ::onExplode).construct()

        var turn = 0
        do {
            turn += 1
            shrooms.forEachField { it.passiveIncEnergy() }
            shrooms.forEachField { it.symulate() }
            val count = shrooms.count { it.detonated }
            shrooms.forEachField { it.claim() }
        } while( count != 100 )

        return turn
    }

    private fun onExplode() {
        explosions += 1
    }
}
