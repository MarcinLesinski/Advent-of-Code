package adventOfCode.puzzles.year2020

import adventOfCode.common.*
import adventOfCode.domain.*
import adventOfCode.puzzles.year2020.day3.Ride
import adventOfCode.puzzles.year2020.day3.Slope
import adventOfCode.puzzles.year2020.day3.Trail

@Year(2020) @Day(3, 2)
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
