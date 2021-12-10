package adventOfCode.puzzles.year2020

import adventOfCode.common.Matrix
import adventOfCode.domain.BitMask
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asBitMask
import adventOfCode.puzzles.year2020.day3.Ride
import adventOfCode.puzzles.year2020.day3.Slope
import adventOfCode.puzzles.year2020.day3.Trail

@Year(2020) @Day(3, 1)
class Day03Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val input: BitMask = input.lines().asBitMask('#', '.')
        val matrix = Matrix<Boolean>(input.size) { input[it] }

        val slope = Slope(matrix)
        val ride = Ride(3, 1)

        val trail = Trail(slope, ride)
        return trail.obstacles()
    }
}
