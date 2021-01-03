package adventOdCode.puzzles

import adventOdCode.common.*
import adventOdCode.domain.*
import adventOdCode.puzzles.day3.Ride
import adventOdCode.puzzles.day3.Slope
import adventOdCode.puzzles.day3.Trail

class Day03Part2(input: Lines) : Puzzle<Lines, Long>(input) {
    override fun solve(): Long {
        val input: BitMask = input.asBitMask('#', '.')
        val matrix = Matrix<Boolean>(input.size) { input[it] }

        val slope = Slope(matrix)

        val rides = arrayOf(
            Ride(1,1),
            Ride(3,1),
            Ride(5,1),
            Ride(7,1),
            Ride(1,2)
        )

        return rides.multiplyBy { Trail(slope, it).obstacles().toLong() }
    }
}