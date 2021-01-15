package adventOfCode.puzzles

import adventOfCode.common.*
import adventOfCode.domain.*
import adventOfCode.puzzles.day3.Ride
import adventOfCode.puzzles.day3.Slope
import adventOfCode.puzzles.day3.Trail

@Day(3, 1)
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