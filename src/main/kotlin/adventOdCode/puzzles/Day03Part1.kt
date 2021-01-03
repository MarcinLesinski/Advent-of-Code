package adventOdCode.puzzles

import adventOdCode.common.*
import adventOdCode.domain.*
import adventOdCode.puzzles.day3.Ride
import adventOdCode.puzzles.day3.Slope
import adventOdCode.puzzles.day3.Trail

class Day03Part1(input: Lines) : Puzzle<Lines, Int>(input) {
    override fun solve(): Int {
        val input: BitMask = input.asBitMask('#', '.')
        val matrix = Matrix<Boolean>(input.size) { input[it] }

        val slope = Slope(matrix)
        val ride = Ride(3, 1)

        val trail = Trail(slope, ride)
        return trail.obstacles()
    }
}