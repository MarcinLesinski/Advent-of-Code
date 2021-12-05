package adventOfCode.puzzles.year2020


import adventOfCode.common.DataReader
import adventOfCode.common.Matrix
import adventOfCode.common.multiplyBy
import adventOfCode.domain.BitMask
import adventOfCode.domain.asBitMask
import adventOfCode.puzzles.year2020.day3.Ride
import adventOfCode.puzzles.year2020.day3.Slope
import adventOfCode.puzzles.year2020.day3.Trail

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day03Part2Test {

    @Test
    fun example() {
        val rides = arrayOf(
            Ride(1,1),
            Ride(3,1),
            Ride(5,1),
            Ride(7,1),
            Ride(1,2)
        )

        val input: BitMask = DataReader.readData(2020,3).asBitMask('#', '.')
        val matrix = Matrix<Boolean>(input.size) { input[it] }
        val slope = Slope(matrix)

        var actual = rides.multiplyBy { Trail(slope, it).obstacles().toLong() }

        assertEquals(336, actual)
    }
}
