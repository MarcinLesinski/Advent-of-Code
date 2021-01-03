package adventOdCode.puzzles


import adventOdCode.common.DataReader
import adventOdCode.common.Matrix
import adventOdCode.common.multiplyBy
import adventOdCode.domain.BitMask
import adventOdCode.domain.asBitMask
import adventOdCode.puzzles.day02.part2.InputParser
import adventOdCode.puzzles.day3.Ride
import adventOdCode.puzzles.day3.Slope
import adventOdCode.puzzles.day3.Trail

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

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

        val input: BitMask = DataReader.readData(3).asBitMask('#', '.')
        val matrix = Matrix<Boolean>(input.size) { input[it] }
        val slope = Slope(matrix)

        var actual = rides.multiplyBy { Trail(slope, it).obstacles().toLong() }

        assertEquals(336, actual)
    }
}