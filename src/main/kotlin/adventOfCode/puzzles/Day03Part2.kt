package adventOfCode.puzzles

import adventOfCode.common.*
import adventOfCode.domain.*
import adventOfCode.puzzles.day3.Ride
import adventOfCode.puzzles.day3.Slope
import adventOfCode.puzzles.day3.Trail

@Day(3, 2)
class Day03Part2(input: RawInput) : Puzzle<Long>(input) {
    override fun solve(): Long {
        val input: BitMask = input.lines().asBitMask('#', '.')
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